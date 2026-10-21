package threads;

public class JoinExample {
    public static void main(String[] args) {
        String mainName = Thread.currentThread().getName();
        System.out.println("1. [" + mainName + "] The program has started.");

        Thread heavyTask = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("   [" + threadName + "] Started processing data...");
                    Thread.sleep(3000); // Simulando 3 segundos de trabalho
                    System.out.println("   [" + threadName + "] Processing finished!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        heavyTask.start();

        try {
            System.out.println("2. [" + mainName + "] Waiting for the heavy task to finish...");
            heavyTask.join(); // A main trava aqui por 3 segundos exatos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Essa linha SÓ vai aparecer após os 3 segundos da heavyTask
        System.out.println("3. [" + mainName + "] All tasks completed. Program ended.");
    }
}