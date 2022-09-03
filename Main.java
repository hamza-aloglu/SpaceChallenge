package SpaceChallenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random r = new Random();
        System.out.println(100 * r.nextDouble());


        Simulation simulation = new Simulation();
        FileOutputStream fileOut;

        // Making phase 1's items into a ArrayList.
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item("BuildingTools", 2000);
        items.add(item);
        items.add(item);
        items.add(item);

        item = new Item("BuildingTools", 5000);
        items.add(item);
        items.add(item);

        item = new Item("BuildingTools", 2000);
        items.add(item);

        item = new Item("BuildingTools", 1000);
        items.add(item);

        item = new Item("BuildingTools", 5000);
        items.add(item);

        item = new Item("BuildingTools", 6000);
        items.add(item);

        item = new Item("ShelterEquipment", 5000);
        items.add(item);

        item = new Item("ConstructionEquipment", 5000);
        items.add(item);

        item = new Item("Plants", 1000);
        items.add(item);

        item = new Item("Steel", 8000);
        items.add(item);

        item = new Item("Books", 1000);
        items.add(item);

        item = new Item("Water", 5000);
        items.add(item);

        // Saving these items into a file.

        String filePath = "C:/SpaceChallengeFiles/Phase1.txt/";

        try {

            System.out.println("-----U-1 phase------");

            fileOut = new FileOutputStream(filePath);
            simulation.saveItems(fileOut, items);
            FileInputStream fileIn = new FileInputStream(filePath);
            
            items = simulation.loadItems(fileIn);
            ArrayList<U1> u1s = simulation.loadU1(items);

            ArrayList<Rocket> rocketU1s = new ArrayList<>();
            for (U1 u1 : u1s) {
                rocketU1s.add(u1);
            }

            double costU1 = simulation.runSimulation(rocketU1s);
            System.out.println("THE COST for u1's: " + costU1 + "(million)$");


            System.out.println("-----U-2 phase------");
        

            ArrayList<U2> u2s = simulation.loadU2(items);
            ArrayList<Rocket> rocketU2s = new ArrayList<>();
            for (U2 u2 : u2s) {
                rocketU2s.add(u2);
            }

            double costU2 = simulation.runSimulation(rocketU2s);
            System.out.println("THE COST FOR u2's: " + (int)costU2 + "(million)$");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("successfully terminated");
    }
}
