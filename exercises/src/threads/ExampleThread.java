package threads;

public class ExampleThread {

    public static void main(String[] args) {
        System.out.println("1. [Conection] The main program has started.");

        // Create a background task (a separate thread)
        Runnable backgroundTask = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("   [Thread 2] Started downloading the large file...");
                    // Simulate a task that takes 3 seconds
                    Thread.sleep(3000);
                    System.out.println("   [Thread 2] File downloaded successfully!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        };

        // Start the thread by passing the task to it
        Thread newThread = new Thread(backgroundTask);
        newThread.start(); // .start() launches parallel execution!
        // The main program continues immediately without waiting for the download to finish
        System.out.println("2. [Conection] The main program continues doing other things...");
        System.out.println("3. [Conection] The user can keep clicking on the application screen!");
    }
}
