package Simulation;

public class Config {
    private final int mapWidth;
    private final int mapHeight;
    private final int initialPopulation;
    private final int simulationDuration;
    public Config(int mapWidth, int mapHeight, int initialPopulation, int simulationDuration) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.initialPopulation = initialPopulation;
        this.simulationDuration = simulationDuration;
    }

    public static Config getDefaultConfig() {
        return new Config(
                30,
                30,
                5,
                20
        );
    }

    public int getMapWidth() { return mapWidth; }
    public int getMapHeight() { return mapHeight; }
    public int getInitialPopulation() { return initialPopulation; }
    public int getSimulationDuration() { return simulationDuration; }
}
