package Simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Klasa loggera zapisującego stan każdej epoki
 */
public class DataLogger {
    private PrintWriter writer;

    /**
     * Konstruktor loggera zapisującego do danego pliku
     * @param filename nazwa pliku
     */
    public DataLogger(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
            writer.println("Epoka,Żywi,Zarażeni,Ozdrowieńcy,Zmarli");
        } catch (IOException e) {
            System.err.println("Nie udało się otworzyć pliku do zapisu: " + filename);
        }
    }

    /**
     * Funkcja pobierająca dane o obecnej epoce i zapisująca je do pliku csv
     * @param epoch obecna epoka
     * @param people lista ludzi
     */
    public void log(int epoch, List<Person> people) {
        int alive = 0;
        int infected = 0;
        int immune = 0;
        int dead = 0;

        for (Person p : people) {
            if (!p.isAlive()) {
                dead++;
            } else {
                alive++;
                if (p.isInfected()) infected++;
                if (p.isImmune()) immune++;
            }
        }

        if (writer != null) {
            writer.printf("%d,%d,%d,%d,%d\n", epoch, alive, infected, immune, dead);
        }
    }

    /**
     * Funkcja zamykająca plik na końcu symulacji
     */
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
