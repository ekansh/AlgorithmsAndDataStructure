package Threading;

/**
 * if an object is locked by Thread T1 then of course 
 * Thread T2 has to wait for T1 to get lock on the same object
 * Now, If another thread modifies the same object ( outside the synchornized block) 
 * Can T2 get access to the synchronized block ? NO 
 * @author Ekansh
 *
 */
public class LockedObjectUpdatedOutsideSynchronizedBlock {
	
	public static void main(String[] args) throws InterruptedException {
		X x = new X();
		x.y=1; // Object that will be used as a lock 
		TaskA a = new TaskA(x);
		TaskA b = new TaskA(x);
		Thread A = new Thread(a);
		Thread B = new Thread(b);
		A.start(); // Thread A gets the lock 
		B.start(); // Thread B waits on A.
		Thread.currentThread().sleep(10000);
		System.out.println("start");
		x.y=2;  //  Main thread modifies the value of the lock .  
		//Thread B still has to wait for Thread A to give up the lock
		System.out.println("end");
	}
}
class TaskA implements Runnable {
	X x ;
	TaskA(X k){
		x=k;
	}
	
	@Override
	public void run() {
		synchronized(x) {
			System.out.println(Thread.currentThread().getName() + "Attempt1:value  :"+x.y);
			System.out.println(Thread.currentThread().getName() + "Attempt2:value  :"+x.y);
		}
	}
	
}
class X{
	Integer y;
	
}