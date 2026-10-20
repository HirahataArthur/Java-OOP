package threads;
import java.util.concurrent.Semaphore;

public class Exercise00 {
    public static void main(String[] args){
        Counter counter = new Counter();

    }
}

class Counter{
    private volatile int counter = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public void increment(){
        try{
            semaphore.acquire();
            counter++;

        } catch (InterruptedException e ){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        } finally{
            semaphore.release();
        }
        }
    public int getCounter(){
        return counter;
    }
}