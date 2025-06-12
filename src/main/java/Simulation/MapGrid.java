package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Plansza symulacji zawierająca ludzi i szpitale
 * Odpowiedzialna za poruszanie, infekowanie oraz leczenie
 */
public class MapGrid {
    private final int width;
    private final int height;
    private final List<Person> people;
    private final List<Hospital> hospitals;
    private final Virus virus;
    private final Config config;

    /**
     * Konstruktor Planszy z zadanymi parametrami
     * @param width szerokość
     * @param height wysokość
     * @param config parametry szpitali, ludzi i wirusa
     */
    public MapGrid(int width, int height, Config config) {
        this.config = config;
        this.width = width;
        this.height = height;
        this.people = new ArrayList<Person>();
        this.virus = new Virus(config.getDeathRate(), config.getInfectionRate());
        this.hospitals = new ArrayList<Hospital>();
    }

    /**
     * Funkcja dodająca ludzi
     * @param person
     */
    public void addPerson(Person person) {
        people.add(person);
    }

    /**
     * Funkcja dodająca szpitale
     * @param hospital
     */
    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    /**
     * Funkcja przemieszczająca ludzi
     */
    public void movePeople() {
        for (Person person : people) {
            if (person.isAlive()) {
                person.move(width, height);
            }
        }
    }

    /**
     * Funkcja do infekowania ludzi
     */
    public void infectPeople() {
        for (Person person : people) {
            if (person.isAlive() && person.isInfected()) {
                for (Person other : people) {
                    if (other.isAlive() && !other.isInfected() && !other.isImmune() &&
                            person.getPosition().distance(other.getPosition()) <= 1) {
                        if (virus.attemptInfection()) {
                            other.infect();
                        }
                    }
                }
            }
        }
    }

    /**
     * Funkcja do leczenia ludzi
     */
    public void healPeople() {
        for (Person person : people) {
            if (person.isAlive()) {
                for (Hospital hospital : hospitals) {
                    if (hospital.canHeal(person)) {
                        hospital.heal(person);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Funkcja odpowiedzialna za śmierci
     */
    public void deaths() {
        for (Person person : people) {
            if (person.isAlive() && person.isInfected()) {
                if (virus.death()) {
                    person.die();
                }
            }
        }
    }

    /**
     * Funkcja aktualizująca czas odporności
     */
    public void updateTimer() {
        for (Person person : people) {
                if (person.isImmune()) {
                    person.addImmunityTime();
                    if (person.getImmunityTime() >= config.getImmunityDuration()) {
                        person.removeImmunity();
                    }
                }
            }
        }

    public List<Person> getPeople() { return people; }

    public List<Hospital> getHospitals() { return new ArrayList<>(hospitals); }

    public int getWidth() { return width; }

    public int getHeight() { return height; }
}
