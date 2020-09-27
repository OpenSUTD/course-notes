import java.util.concurrent.CountDownLatch;

public class CDLDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();
    }
}

class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}

class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());

            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// output:
// 2
// 1
// 0
// Waiter Released