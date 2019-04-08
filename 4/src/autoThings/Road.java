package autoThings;

import java.util.*;
import java.util.concurrent.*;

public class Road {

    private final int MAX_SPEED=70;
    private Semaphore semaphore;
    private int numberFine;
    private ConcurrentLinkedQueue<Car> carQueue;
    private int maxSpeedOnRoad;

    public Road(int _numberLanes, int _numberCars) throws ExecutionException, InterruptedException {

        semaphore=new Semaphore(_numberLanes);
        carQueue=new ConcurrentLinkedQueue<Car>();
        numberFine=0;
        for(int i=0; i<_numberCars;++i){
            carQueue.add(new Car(semaphore));
        }
        maxSpeedOnRoad=checkMaxSpeedOnRoad(_numberCars);
    }

    public int getMaxSpeedOnRoad() {
        return maxSpeedOnRoad;
    }

    public int getNumberFine() {
        return numberFine;
    }

    private synchronized void incNumberFine(){
        numberFine++;
    }

    private int checkMaxSpeedOnRoad(int _numberCars) throws ExecutionException, InterruptedException {

        ExecutorService executorService=Executors.newFixedThreadPool(_numberCars);
        List<Future<Integer>> futureList=new ArrayList<Future<Integer>>();
        List<Integer> speedList=new ArrayList<Integer>();

        for (int i=0; i<_numberCars; ++i) {

            Car car=carQueue.poll();
            Future<Integer> future=executorService.submit(car);
            futureList.add(future);
        }

        for(Future<Integer> future: futureList){

            Integer speed=future.get();
            if(speed>MAX_SPEED){
                incNumberFine();
            }
            //exceptions from here
            speedList.add(speed);

        }
        /*System.out.println();
        System.out.println();
        for(Integer speed:speedList){
            System.out.print(speed+ "  ");
        }
        System.out.println();
        System.out.println();*/

        executorService.shutdown();
        return Collections.max(speedList);
    }
}
