package Simulation;

import java.util.ArrayList;
import java.util.List;

public class MapGrid {
    private final int width;
    private final int height;
    private final List<Person> people;
    private List<Hospital> hospitals;
    private Virus virus;

    public MapGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.people = new ArrayList<Person>();
        this.hospitals = new ArrayList<Hospital>();

    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void movePeople() {
        for (Person person : people) {
            if (person.isAlive()) {
                person.move(width, height);
            }
        }
    }

    public List<Person> getPeople() { return people; }
}
