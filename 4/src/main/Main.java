package main;

import autoThings.Road;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Creating of the road");
        int numberCars=50;
        int numberLanes=5;


        Road road= null;
        try {
            road = new Road(numberLanes, numberCars);


            System.out.println("\n\nNumber of fines: "+road.getNumberFine() +" from "+numberCars+" cars.");

            System.out.println("Maximum speed on a road: "+road.getMaxSpeedOnRoad()+".");

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}
