package SpaceChallenge;

import java.io.Serializable;

public class U2 extends Rocket implements Serializable {
    public U2() {
        super.weight = 18;
        super.cost = 120;
        super.maxWeight = 29;
    }

    @Override
    public boolean launch() {
        if (super.willItExplode(0.04))
            return false;

        else
            return true;
    }

    @Override
    public boolean land() {
        if (super.willItExplode(0.08))
            return false;
        else
            return true;
    }
}
