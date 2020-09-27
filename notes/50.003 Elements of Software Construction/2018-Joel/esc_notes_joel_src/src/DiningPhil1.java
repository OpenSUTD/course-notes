import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


// Locking policy: Each Fork1 object has a reentrant lock that
// abstracts the availability of the lock. Since deadlock can only happen
// if each Philosopher is holding on to one fork and waiting for a held Fork1,
// if all 5 Philosophers hold on to forks on the same hand, e.g. left,
// no forks would be left. If they try to get a Fork on the right,
// then they would fail and release the left one. This solution prevents
// deadlock and can be implemented either on the left or right hands.

public class DiningPhil1 {

	private static int N = 5;

	public static void main (String[] args) throws Exception {	
		Philosopher1[] phils = new Philosopher1[N];
		Fork1[] forks = new Fork1[N];

		for (int i = 0; i < N; i++) {
			forks[i] = new Fork1(i);
		}

		for (int i = 0; i < N; i++) {
			phils[i] = new Philosopher1 (i, forks[i], forks[(i+N-1)%N]);
			phils[i].start();
		}
	}
}

class Philosopher1 extends Thread {
	private final int index;
	private final Fork1 left;
	private final Fork1 right;
	
	public Philosopher1 (int index, Fork1 left, Fork1 right) {
		this.index = index;
		this.left = left;
		this.right = right;
	}
	
	public void run() {
		Random randomGenerator = new Random();
		try {
			while (true) {
				// Lock left, then tryLock right.
				Thread.sleep(randomGenerator.nextInt(100)); //not sleeping but thinking
				System.out.println("Phil " + index + " finishes thinking.");
				left.lock.lock();
				System.out.println("Phil " + index + " locks left.");
				left.pickup();				
				System.out.println("Phil " + index + " picks up left Fork1.");
				System.out.println("Phil " + index + " tries to lock right.");
				boolean lockRight;
				if (lockRight = right.lock.tryLock()) {
					System.out.println("Phil " + index + " locks right.");
					right.pickup();
					System.out.println("Phil " + index + " picks up right Fork1.");
				}
				Thread.sleep(randomGenerator.nextInt(100)); //eating
				System.out.println("Phil " + index + " finishes eating.");
				left.putdown();
				System.out.println("Phil " + index + " puts down left Fork1.");
				left.lock.unlock();
				System.out.println("Phil " + index + " unlocks left.");
				if (lockRight) {
					right.putdown();
					System.out.println("Phil " + index + " puts down right Fork1.");
					right.lock.unlock();
					System.out.println("Phil " + index + " unlocks right.");
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Don't disturb me while I am sleeping, well, thinking.");
		} 
	}
}

class Fork1 {
	private final int index;
	private boolean isAvailable = true;
	public ReentrantLock lock = new ReentrantLock();
	
	public Fork1 (int index) {
		this.index = index;
	}
	
	public synchronized void pickup () throws InterruptedException {
		while (!isAvailable) {
			wait();
		}
		
		isAvailable = false;
		notifyAll();
	}
	
	public synchronized void putdown() throws InterruptedException {
		while (isAvailable) {
			wait();
		}

		isAvailable = true;
		notifyAll();
	}
	
	public String toString () {
		if (isAvailable) {
			return "Fork " + index + " is available.";
		}
		else {
			return "Fork " + index + " is NOT available.";
		}
	}
}