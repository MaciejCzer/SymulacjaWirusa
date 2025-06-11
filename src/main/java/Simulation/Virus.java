package Simulation;
import java.util.Random;

public class Virus {

    private int deathRate;
    private double infectionrate;
    private Random random;

  public Virus(int deathRate, int infectionrate) {
      this.deathRate = deathRate;
      this.infectionrate = infectionrate;
      this.random = new Random();


  }

    /**
     *Próba zainfekowania gdy 2 osoby znają się obok siebie
     * @return True/False
     */
    public boolean attemptInfection(){
      return random.nextDouble(100) < infectionrate;
    }

    /**
     *Próba śmierci
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
