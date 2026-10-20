package threads;

public class MonitorExample {

    private final Example example = new Example();

    // This method locks the example object while it prints.
    public void printExample() {
        // A synchronized block locks only the specified object's monitor.
        synchronized (example) {
            // Calls print() while holding the same monitor used by other synchronized blocks on example.
            example.print();
        }
    }

    private static final class Example {
        private void print() {
            System.out.println("Printing while holding the example object's monitor.");
        }
    }

    private static final class Control {
        private int counter;

        private Control(int counter) {
            this.counter = counter;
        }

        // A synchronized instance method locks this Control object.
        private synchronized void decrement() {
            counter--;
        }

        // Synchronizing reads as well ensures visibility of the latest counter value.
        private synchronized int getControl() {
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Control control = new Control(6);
        MonitorExample monitorExample = new MonitorExample();

        Runnable task = () -> {
            // Both threads update the same counter; its synchronized method prevents conflicting updates.
            for (int i = 0; i < 3; i++) {
                control.decrement();
            }
            monitorExample.printExample();
        };

        Thread firstThread = new Thread(task);
        Thread secondThread = new Thread(task);
        firstThread.start();
        secondThread.start();

        // Wait for both workers before reading and printing the final counter value.
        firstThread.join();
        secondThread.join();
        System.out.println("Final counter value: " + control.getControl());
    }
}
