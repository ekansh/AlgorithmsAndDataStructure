package Threading;

import java.util.concurrent.Callable;

/**
 * If you synchronize on a String, lets say name="key"
 * and if each thread is executing a different task of type DBTaskOfProduct
 * only one thread will be able to execute the code. 
 * This is because all the task will have same id of the string object-> name.
 * to over come this you can do new String(key)
 * Check out setName method this.name = new String(name) will not bother threads from performing different tasks
 * this.name = name; will  bother threads from performing different tasks
 * 
 * @author ekansh
 *
 */

public class DBTaskOfProduct implements Callable<Product>{

	private String name ;
	private Object key = new Object (); 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = new String(name);
	}

	@Override
	public Product call() throws Exception {
		System.out.println("Starting crucial work "+name);
		synchronized (name) {
			System.out.println("doing some crucial work "+Thread.currentThread().getName());
			System.out.println("doing some crucial work.. contd "+Thread.currentThread().getName());
		}
		System.out.println("end  crucial work"+name);
		return null;
	}

}
