package main;

/*Машины едут по пяти полосной дороге с разной скоростью. В дороги их скорость замеряется и,
если их скорость превышает разрешённую, они убираются с дороги. Иначе они убирают сами себя через секунду.
Каждые 50 машин в консоль выводится отчёт, содержащий максимальную скорость и количество нарушений.
Каждую машину запускать в отдельном потоке. */

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
