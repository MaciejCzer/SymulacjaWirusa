package Simulation;

import java.util.Random;

/**
 * Klasa reprezentująca człowieka, ma pozycje, stan zainfekowania, odporność
 */
public class Person {
    private Point position;
    private boolean infected;
    private boolean alive;
    private boolean immune;
    private int immunityTime;
    private static final Random rand = new Random();

    /**
     * Konstruktor danego człowieka
     * @param position początkowa pozycja człowieka
     */
    public Person(Point position) {
        this.position = position;
        this.alive = true;
        this.infected = false;
        this.immune = false;
    }

    /**
     * Funkcja przemieszczająca człowieka o 1 w losowym kierunku w zakresie mapy
     * @param mapWidth szerokość planszy
     * @param mapHeight wysokość planszy
     */
    public void move(int mapWidth, int mapHeight) {
        int dx = rand.nextInt(3) - 1;
        int dy = rand.nextInt(3) - 1;

        int newX = Math.min(Math.max(position.getX() + dx, 0), mapWidth - 1);
        int newY = Math.min(Math.max(position.getY() + dy, 0), mapHeight - 1);

        position = new Point(newX, newY);
    }

    /**
     *Funkcja infekująca człowieka
     */
    public void infect() {
        this.infected = true;
    }

    /**
     * Funkcja lecząca człowieka oraz dająca mu odporność
     */
    public void heal() {
        this.infected = false;
        this.immune = true;
        this.immunityTime = 0;
    }

    /**
     * Funkcja oznaczająca człowieka jako martwego
     */
    public void die() {
        this.alive = false;
    }

    /**
     * Dodawanie czasu odporności
     */
    public void addImmunityTime() {
            immunityTime++;
    }

    /**
     * Odbieranie odporności i resetowanie timera
     */
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
