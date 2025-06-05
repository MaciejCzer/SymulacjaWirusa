package Simulation;

import java.util.ArrayList;
import java.util.List;

public class MapGrid {
    private final int width;
    private final int height;
    private final List<Person> people;
    private final List<Hospital> hospitals;
    private final Virus virus;
    private final Config config;

    public MapGrid(int width, int height, Config config) {
        this.config = config;
        this.width = width;
        this.height = height;
        this.people = new ArrayList<Person>();
        this.virus = new Virus(config.getDeathRate(), config.getInfectionRate());
        this.hospitals = new ArrayList<Hospital>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    public void movePeople() {
        for (Person person : people) {
            if (person.isAlive()) {
                person.move(width, height);
            }
        }
    }

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

    public void deaths() {
        for (Person person : people) {
            if (person.isAlive() && person.isInfected()) {
                if (virus.death()) {
                    person.die();
                }
            }
        }
    }

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
}
