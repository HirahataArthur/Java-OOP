package threads_exercise;

import java.util.concurrent.Semaphore;

public class Company {
    private final Semaphore beltPool; // Handles access to the conveyor belts
    private final int maxProductsToPack; // Maximum number of products to be packed
    private final int packagerPoolSize; // Maximum number of packagers available to form teams
    private final int maxTeams; // Maximum number of teams to be formed

    public Company(int beltCount, int packagerPoolSize, int maxProductsToPack, int maxTeams) {
        if (beltCount < 1 || packagerPoolSize < 2 || maxProductsToPack < 1 || maxTeams < 1) {
            throw new IllegalArgumentException("Invalid arguments in Company constructor");
        }

        this.beltPool = new Semaphore(beltCount);
        this.packagerPoolSize = packagerPoolSize;
        this.maxProductsToPack = maxProductsToPack;
        this.maxTeams = maxTeams;
    }

    public void createTeams(int beltsCount){

    }

    public int fillTeams(int packagerPoolSize){
        return 1; //Placeholder
    }
}
