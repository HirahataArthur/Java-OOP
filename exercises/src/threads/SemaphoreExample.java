package threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreExample {

    private static final class PingPong {
        // Each semaphore is a turn signal: only the thread whose semaphore has a permit may act.
        private final Semaphore pingSemaphore = new Semaphore(0);
        private final Semaphore pongSemaphore = new Semaphore(0);

        private PingPong(int matchLength) {
            // The count is shared, so matchLength is the total number of PING/PONG turns.
            Control counter = new Control(matchLength);
            Ping ping = new Ping(pingSemaphore, pongSemaphore, counter);
            Pong pong = new Pong(pingSemaphore, pongSemaphore, counter);

            new Thread(ping).start();
            new Thread(pong).start();
            // Give PING the first turn; PONG starts waiting until PING signals it.
            pingSemaphore.release();
        }
    }

    private static final class Ping implements Runnable {
        private final Semaphore pingSemaphore;
        private final Semaphore pongSemaphore;
        private final Control counter;

        private Ping(Semaphore pingSemaphore, Semaphore pongSemaphore, Control counter) {
            this.pingSemaphore = pingSemaphore;
            this.pongSemaphore = pongSemaphore;
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Thread A (PING) started");
            try {
                while (true) {
                    // Wait for its turn. This blocks while the semaphore has no permits.
                    pingSemaphore.acquire();
                    if (counter.getControl() <= 0) {
                        // Wake PONG so it can also notice the finished count and exit.
                        pongSemaphore.release();
                        break;
                    }

                    System.out.println("PING => 0");
                    counter.decrement();
                    // Pass the turn to PONG.
                    pongSemaphore.release();
                }
            } catch (InterruptedException e) {
                // Stop the match and wake the other thread so it cannot remain blocked.
                counter.stop();
                pongSemaphore.release();
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread A (PING) finished");
        }
    }

    private static final class Pong implements Runnable {
        private final Semaphore pingSemaphore;
        private final Semaphore pongSemaphore;
        private final Control counter;

        private Pong(Semaphore pingSemaphore, Semaphore pongSemaphore, Control counter) {
            this.pingSemaphore = pingSemaphore;
            this.pongSemaphore = pongSemaphore;
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Thread B (PONG) started");
            try {
                while (true) {
                    // PONG waits until PING releases a permit for it.
                    pongSemaphore.acquire();
                    if (counter.getControl() <= 0) {
                        // Wake PING so it can observe the finished count and exit.
                        pingSemaphore.release();
                        break;
                    }

                    System.out.println("0 <= PONG");
                    counter.decrement();
                    // Pass the turn back to PING.
                    pingSemaphore.release();
                }
            } catch (InterruptedException e) {
                // Stop the match and wake the other thread so it cannot remain blocked.
                counter.stop();
                pingSemaphore.release();
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread B (PONG) finished");
        }
    }

    private static final class Control {
        // AtomicInteger makes shared counter reads and updates thread-safe.
        private final AtomicInteger count;

        private Control(int matchLength) {
            count = new AtomicInteger(matchLength);
        }

        private int getControl() {
            return count.get();
        }

        private void decrement() {
            count.decrementAndGet();
        }

        private void stop() {
            count.set(0);
        }
    }

    public static void main(String[] args) {
        // Start a match with eight total turns, alternating between PING and PONG.
        new PingPong(8);
    }
}
