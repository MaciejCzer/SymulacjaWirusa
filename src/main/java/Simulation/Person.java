package Simulation;

import java.util.Random;

public class Person {
    private Point position;
    private boolean infected;
    private boolean alive;
    private boolean immune;
    private int immunityTime;
    private static final Random rand = new Random();
    public Person(Point position) {
        this.position = position;
        this.alive = true;
        this.infected = false;
        this.immune = false;
    }

    public void move(int mapWidth, int mapHeight) {
        int dx = rand.nextInt(3) - 1;
        int dy = rand.nextInt(3) - 1;

        int newX = Math.min(Math.max(position.getX() + dx, 0), mapWidth - 1);
        int newY = Math.min(Math.max(position.getY() + dy, 0), mapHeight - 1);

        position = new Point(newX, newY);
    }

    public void infect() {
        this.infected = true;
    }

    public void heal() {
        this.infected = false;
        this.immune = true;
        this.immunityTime = 0;
    }

    public void die() {
        this.alive = false;
    }

    public void addImmunityTime() {
            immunityTime++;
    }

    public void removeImmunity() {
        this.immune = false;
        this.immunityTime = 0;
    }

    public Point getPosition() { return position; }
    public boolean isAlive() { return alive; }
    public boolean isInfected() { return infected; }
    public boolean isImmune() { return immune; }
    public int getImmunityTime() { return immunityTime; }
}
