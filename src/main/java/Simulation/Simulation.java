package Simulation;

import java.util.Random;

/**
 * Główna klasa symulacji
 */
public class Simulation {
    private final MapGrid grid;
    private final Config config;
    private static final Random random = new Random();
    private final DataLogger logger;
    private final Renderer renderer;

    /**
     * Konstruktor symulacji
     * @param config
     */
    public Simulation(Config config) {
        this.config = config;
        this.grid = new MapGrid(config.getMapWidth(), config.getMapHeight(), config);
        this.logger = new DataLogger("symulacja.csv");
        this.renderer = new Renderer();
        initializeSimulation();
    }

    /**
     * Funkcja inicjalizująca symulację
     * Dodaje ludzi i szpitale
     */
    private void initializeSimulation() {
        for (int i = 0; i < config.getInitialPopulation(); i++) {
            Point position = getRandomPosition();
            Person person = new Person(position);
            if (i < config.getInitialInfected()) {
                person.infect();
            }
            grid.addPerson(person);
        }

        for (int i = 0; i < config.getHospitalsNumber(); i++) {
            Point position = getRandomPosition();
            Hospital hospital = new Hospital(position, config.getHealingRdius());
            grid.addHospital(hospital);
        }
    }

    /**
     * Funkcja do pozyskiwania losowych punktów na planszy
     * @return Point
     */
    private Point getRandomPosition() {
        return new Point(
                random.nextInt(config.getMapWidth()),
                random.nextInt(config.getMapHeight()));
    }

    /**
     * Główna funkcja odpowiedzialna za przebieg symulacji
     * Wykonuje zadaną liczbe epok
     */
    public void run() {
        for (int epoch = 0; epoch < config.getSimulationDuration(); epoch++) {
            grid.movePeople();
            grid.infectPeople();
            grid.healPeople();
            grid.deaths();
            grid.updateTimer();
            renderer.render(grid);
            logger.log(epoch, grid.getPeople());
            try {
                Thread.sleep(config.getDelay());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.close();
        System.out.println("Dane zapisane do pliku csv");
    }
    public static void main(String[] args) {
        Config config = new Config();
        Simulation simulation = new Simulation(config);
        simulation.run();
    }
}
