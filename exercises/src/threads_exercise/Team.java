package threads_exercise;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Team extends Thread{
    private final int no_members;
    private CountDownLatch latch;
    private final Semaphore beltPool;
    private final ArrayList < Packer > packers;


    Team (String name, int nr_members, Semaphore beltPool){
            this.setName(name);
            this.no_members = nr_members;
            this.beltPool = beltPool;
            this.packers = new ArrayList< Packer>();
            preparePackers();
    }

    public void releaseTape(){

    }

    public void releaseUnecessaryTapes(int nr_locks_released){

    }

    public int getPackages(){
        return 1;
    }

    public int getNOmembers(){
        return no_members;
    }

    public void preparePackers(){

    }

    public boolean toPack(int nr_products){
        return false;
    }

    public boolean block(){
        return false;
    }

    public void report(){
    }

    public void run(){

    }


}
