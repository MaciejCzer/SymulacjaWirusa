package Simulation;

public class Config {
    private final int mapWidth;
    private final int mapHeight;
    private final int initialPopulation;
    private final int simulationDuration;
    private final int infectionRate;
    private final int deathRate;
    private final int immunityDuration;
    private final int initialInfected;
    private final int HospitalsNumber;
    private final int HealingRdius;
    public Config(int mapWidth, int mapHeight, int initialPopulation, int simulationDuration, int infectionRate,
                  int deathRate, int immunityDuration, int initialInfected, int HospitalsNumber, int HealingRdius) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.initialPopulation = initialPopulation;
        this.simulationDuration = simulationDuration;
        this.infectionRate = infectionRate;
        this.deathRate = deathRate;
        this.immunityDuration = immunityDuration;
        this.initialInfected = initialInfected;
        this.HospitalsNumber = HospitalsNumber;
        this.HealingRdius = HealingRdius;
    }

    public static Config getDefaultConfig() {
        return new Config(
                10,
                10,
                10,
                20,
                50,
                10,
                40,
                2,
                2,
                4
        );
    }

    public int getMapWidth() { return mapWidth; }
    public int getMapHeight() { return mapHeight; }
    public int getInitialPopulation() { return initialPopulation; }
    public int getSimulationDuration() { return simulationDuration; }
    public int getInfectionRate() { return infectionRate; }
    public int getDeathRate() { return deathRate; }
    public int getImmunityDuration() { return immunityDuration; }
    public int getInitialInfected() { return initialInfected; }
    public int getHospitalsNumber() { return HospitalsNumber; }
    public int getHealingRdius() { return HealingRdius; }
}
