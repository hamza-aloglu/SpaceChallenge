package SpaceChallenge;

import java.io.Serializable;

public class U1 extends Rocket implements Serializable {

    public U1() {
        super.weight = 10;
        super.cost = 10;
        super.maxWeight = 18;
    }

    @Override
    public boolean launch() {
        if (super.willItExplode(0.05))
            return false;

        else
            return true;
    }

    @Override
    public boolean land() {
        if (super.willItExplode(0.01))
            return false;
        else
            return true;
    }

}
