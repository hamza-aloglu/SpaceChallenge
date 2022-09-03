package SpaceChallenge;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
