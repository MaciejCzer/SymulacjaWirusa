package Simulation;
import java.util.Random;

/**
 * Klasa wirusa z zaraźliwością i śmiertelnością
 */
public class Virus {

    private int deathRate;
    private double infectionrate;
    private Random random;

    /**
     * Konstruktor wirusa z zadaną śmiertelnością i zaraźliwością
     * @param deathRate śmiertelność
     * @param infectionrate zaraźliwość
     */
  public Virus(int deathRate, int infectionrate) {
      this.deathRate = deathRate;
      this.infectionrate = infectionrate;
      this.random = new Random();
  }

    /**
     *Próba zainfekowania gdy 2 osoby znają się obok siebie
     * @return True jeżeli udało się zainfekować False jeżeli nie
     */
    public boolean attemptInfection(){
      return random.nextDouble(100) < infectionrate;
    }

    /**
     * Próba śmierci zainfekowanego człowieka
     * @return True jeżeli człowiek umiera False jeżeli nie
     */
    public boolean death(){
      return random.nextDouble(100) < deathRate;
    }
    public int getDeathRate() {
      return deathRate;
    }
    public int getInfectionRate() {
      return (int) infectionrate;
    }

}
