package SpaceChallenge;

import java.io.Serializable;
import java.util.Random;

public class Rocket implements SpaceShip, Serializable {
    protected double cost;
    protected double maxWeight;
    protected double weight;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (weight + item.weight <= maxWeight)
            return true;
        else
            return false;
    }

    @Override
    public void carry(Item item) {
        weight += item.weight;
    }

    public boolean willItExplode(double baseProbability) {
        Random r = new Random();
        double randomValue = 100 * r.nextDouble();
        double chanceOfExplosion = baseProbability * (this.weight / this.maxWeight);


        if (randomValue <= chanceOfExplosion)
            return true;
        else
            return false;

    }

}
