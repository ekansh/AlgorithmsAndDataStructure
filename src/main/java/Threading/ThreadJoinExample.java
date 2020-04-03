package Threading;
/**
 * 1) all threads run in parallel .
 * 2) Main thread wait until all the thread have completed their work.
 * 
 * @author ekansh
 *
 */
public class ThreadJoinExample {
	
		 
	    public static void main(String[] args) {
	    	Runnable task = new MyRunnable();
	        Thread t1 = new Thread(task, "t1");
	        Thread t2 = new Thread(task, "t2");
	        Thread t3 = new Thread(task, "t3");
	         
	        t1.start();
	         
	        //start second thread after waiting for 2 seconds or if it's dead
//	        try {
//	            t1.join(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
	         
	        t2.start();
	         
	        //start third thread only when first thread is dead
//	        try {
//	            t1.join();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	         
	        t3.start();
	         
	        //let all threads finish execution before finishing main thread
	        try {
	        	System.out.println("Thread  t1.join");
	            t1.join();
	        	System.out.println("Thread  t2.join");
	            t2.join();
	        	System.out.println("Thread  t3.join");
	            t3.join();
	        	System.out.println("Done Joining");

	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         
	        System.out.println("All threads are dead, exiting main thread");
	    }
	 

}


class MyRunnable implements Runnable{
	 
	StringBuilder sb ;

    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        try {
        	Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
     
}