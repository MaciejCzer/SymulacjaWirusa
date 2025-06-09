package Simulation;

import java.util.Scanner;


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
    private final int Delay;
    public Config() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Szerokość mapy: ");
        this.mapWidth = scanner.nextInt();

        System.out.print("Wysokość mapy: ");
        this.mapHeight = scanner.nextInt();

        System.out.print("Liczba osób: ");
        this.initialPopulation = scanner.nextInt();

        System.out.print("Długość symulacji : ");
        this.simulationDuration = scanner.nextInt();

        System.out.print("Szansa zarażenia : ");
        this.infectionRate = scanner.nextInt();

        System.out.print("Szansa śmierci : ");
        this.deathRate = scanner.nextInt();

        System.out.print("Długość odporności : ");
        this.immunityDuration = scanner.nextInt();

        System.out.print("Początkowa liczba zarażonych: ");
        this.initialInfected = scanner.nextInt();

        System.out.print("Liczba szpitali: ");
        this.HospitalsNumber = scanner.nextInt();

        System.out.print("Zasięg leczenia szpitala: ");
        this.HealingRdius = scanner.nextInt();

        System.out.println("Czas wyswietlania");
        this.Delay = scanner.nextInt();

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
    public int getDelay() { return Delay; }
}
