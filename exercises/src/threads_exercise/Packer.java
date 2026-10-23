package threads_exercise;

public class Packer {
    private String name;

    public Packer(String name) throws InterruptedException{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid arguments in Packer constructor");
        } else {
            this.name = name;
        }
    }
    public void listIdThreads(){

    }

    public void listPackages(){

    }

    public void run(){

    }




}
