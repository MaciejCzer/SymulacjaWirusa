package Simulation;

public class Hospital {

    private Point position;
    private int healingRdius;

    public Hospital(Point position, int healingRdius) {
        this.position = position;
        this.healingRdius = healingRdius;
    }

    public Point getPosition() {
        return position;
    }

    public int getHealingRdius() {
        return healingRdius;

    }

    public boolean canHeal(Person person) {
        return position.distance(person.getPosition()) <= healingRdius;

    }

    public void heal(Person person) {
        if (person.isInfected()) {
            person.heal();
        }
    }

}
