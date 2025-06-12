package Simulation;

import java.io.IOException;

/**
 * Klasa wyświetlająca przebieg symulacji
 */
public class Renderer {
    private static final char EMPTY = '.';
    private static final char HEALTHY = 'Z';
    private static final char INFECTED = 'C';
    private static final char DEAD = 'X';
    private static final char HOSPITAL = '#';

    /**
     * Wyświetla obecny stan symulacji w konsoli za pomocą znaków
     * @param grid plansza reprezentująca obecny stan symulacji
     */
    public void render(MapGrid grid) {
        char[][] display = new char[grid.getHeight()][grid.getWidth()];

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                display[y][x] = EMPTY;
            }
        }

        for (Hospital hospital : grid.getHospitals()) {
            Point pos = hospital.getPosition();
            display[pos.getY()][pos.getX()] = HOSPITAL;
        }

        for (Person person : grid.getPeople()) {
            Point pos = person.getPosition();
            if (!person.isAlive()) {
                display[pos.getY()][pos.getX()] = DEAD;
            } else if (person.isInfected()) {
                display[pos.getY()][pos.getX()] = INFECTED;
            } else {
                display[pos.getY()][pos.getX()] = HEALTHY;
            }
        }


        System.out.println(HEALTHY + " Zdrowy  " +
                INFECTED + " Zarazony  " +
                DEAD + " Martwy  " +
                HOSPITAL + " Szpital");

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                System.out.print(display[y][x] + " ");
            }
            System.out.println();
        }
    }
}
