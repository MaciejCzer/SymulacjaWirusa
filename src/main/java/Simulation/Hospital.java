package Simulation;

/**
 * Klasa reprezentująca szpital który leczy ludzi w danym zasięgu
 */
public class Hospital {

    private Point position;
    private int healingRdius;

    /**
     * Konstruktor szpitala z daną pozycją oraz zasięgiem leczenia
     * @param position pozycja szpitala
     * @param healingRdius zasięg leczenia
     */
    public Hospital(Point position, int healingRdius) {
        this.position = position;
        this.healingRdius = healingRdius;
    }

    /**
     * Sprawdzanie czy osoba znajduje się w zasięgu szpitala
     * @param person osoba sprawdzana czy jest w zasięgu
     * @return True jeżeli jest w zasięgu False jeżeli nie jest
     */
    public boolean canHeal(Person person) {
        return position.distance(person.getPosition()) <= healingRdius;

    }

    /**
     * Leczenie człowieka w zasięgu szpitala
     * @param person człowiek w zasięgu leczenia
     */
    public void heal(Person person) {
        if (person.isInfected()) {
            person.heal();
        }
    }

    public Point getPosition() {
        return position;
    }

    public int getHealingRdius() {
        return healingRdius;

    }
}
