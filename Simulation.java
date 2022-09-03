package SpaceChallenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Simulation implements Serializable {

    void saveItems(FileOutputStream FPout, ArrayList<Item> items) {
        try {
            ObjectOutputStream OFPout = new ObjectOutputStream(FPout);
            for (Item item : items) {
                OFPout.writeObject(item);
            }
            OFPout.writeObject(new EOFindicator());
            OFPout.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    ArrayList<Item> loadItems(FileInputStream FPin) {
        ArrayList<Item> items = new ArrayList<>();

        try {
            ObjectInputStream OFPin = new ObjectInputStream(FPin);
            Object item = OFPin.readObject();
            while (!(item instanceof EOFindicator)) {
                items.add((Item) item);
                item = OFPin.readObject();
            }
            OFPin.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> rocketU1s = new ArrayList<>();

        U1 rocket = new U1();
        for (int i = 0; i < items.size(); i++) {
            if (rocket.canCarry(items.get(i))) {
                rocket.carry(items.get(i));
            } else {
                rocketU1s.add(rocket);
                rocket = new U1();
                rocket.carry(items.get(i));
            }
        }

        return rocketU1s;
    }

    ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> rocketU2s = new ArrayList<>();

        U2 rocket = new U2();
        for (int i = 0; i < items.size(); i++) {
            if (rocket.canCarry(items.get(i))) {
                rocket.carry(items.get(i));
            } else {
                rocketU2s.add(rocket);
                rocket = new U2();
                rocket.carry(items.get(i));
            }
        }

        return rocketU2s;
    }

    double runSimulation(ArrayList<Rocket> rockets) {
        double requiredBudget = 0.0;
        int crashedNumber = 0;
        int successNumber = 0;

        for (Rocket rocket : rockets) {
            boolean isLaunched = rocket.launch();
            boolean isLanded = rocket.land();
            requiredBudget += rocket.cost;
            while (!isLaunched || !isLanded) {
                crashedNumber++;
                isLaunched = rocket.launch();
                isLanded = rocket.land();
                requiredBudget += rocket.cost;
            }
            successNumber++;
        }

        System.out.println(crashedNumber + " rockets crashed ");
        System.out.println(successNumber + " rockets landed");
        return requiredBudget;
    }

}
