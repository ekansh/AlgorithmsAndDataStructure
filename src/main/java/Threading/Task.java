package Threading;
/**
 * Old way of doing
 * Forgot the joining operation. 
 * @author ekansh
 *
 */

public class Task implements Runnable {

	private String name = "";

	@Override
	public void run() {

		System.out.println(name);

	}

	public static void main(String[] args) {
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		task1.name = "th1";
		task2.name = "th2";
		task3.name = "th3";

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		System.out.println("Task.main()");
		t1.start();
		t2.start();
		t3.start();
	
		System.out.println("Task.main().end ");
	}
}
