package autoThings;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Car implements Callable<Integer> {

    private final int MAX_SPEED=70;
    private int speed;
    private Semaphore sem;

    public Car(Semaphore semaphore){

        speed=0;
        sem=semaphore;
    }

    public void go(){
        Random random=new Random();

        speed=random.nextInt(140)+1;
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Start thread: " + Thread.currentThread().getName());
        try {
            sem.acquire();
            System.out.println("Thread: "+Thread.currentThread().getName()+" got permission");

            go();

            if(speed>MAX_SPEED){
                System.out.println("ENDED: "+Thread.currentThread().getName());
                sem.release();
                return speed;
            }
            Thread.sleep(1000);
            System.out.println("ENDED: "+Thread.currentThread().getName());
            sem.release();
            return speed;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
