package Simulation;

import java.util.Random;


public class Simulation {
    private final MapGrid grid;
    private final Config config;
    private static final Random random = new Random();

    public Simulation(Config config) {
        this.config = config;
        this.grid = new MapGrid(config.getMapWidth(), config.getMapHeight());
        initializeSimulation();
    }

    private void initializeSimulation() {
        for (int i = 0; i < config.getInitialPopulation(); i++) {
            Point position = getRandomPosition();
            Person person = new Person(position);
            grid.addPerson(person);
        }
    }

    private Point getRandomPosition() {
        return new Point(
                random.nextInt(config.getMapWidth()),
                random.nextInt(config.getMapHeight()));
    }

    public void run() {
        for (int epoch = 0; epoch < config.getSimulationDuration(); epoch++) {
            grid.movePeople();
            //---------------------------
            for (Person person : grid.getPeople()) {
                Point pos = person.getPosition();
                System.out.println(pos.getX() + " " + pos.getY());

            }
            //^to tylko zeby zobaczyc czy dziala^
        }
    }
    public static void main(String[] args) {
        Config config = Config.getDefaultConfig();
        Simulation simulation = new Simulation(config);
        simulation.run();
    }
}
