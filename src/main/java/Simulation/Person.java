package Simulation;

import java.util.Random;

public class Person {
    private Point position;
    private boolean alive;
    private boolean infected;
    private static final Random rand = new Random();
    public Person(Point position) {
        this.position = position;
        this.alive = true;
        this.infected = false;
    }

    public void move(int mapWidth, int mapHeight) {
        int dx = rand.nextInt(3) - 1;
        int dy = rand.nextInt(3) - 1;

        int newX = Math.min(Math.max(position.getX() + dx, 0), mapWidth - 1);
        int newY = Math.min(Math.max(position.getY() + dy, 0), mapHeight - 1);

        position = new Point(newX, newY);
    }

    public Point getPosition() { return position; }
    public boolean isAlive() { return alive; }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public void heal() {
        infected = false;

    }
}
