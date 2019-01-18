package algos.recursion;

public class Fibonacci {
	public static void main(String[] args) {
		int n= 8;
		int fibonacci = fibonacci(n);
		System.out.println(fibonacci);
	}

	private static int fibonacci(int n) {
		if (n==1){
//			System.out.print(0 +" ");
			return 0;
		} if ( n== 2){
//			System.out.print(1 +" ");
			return 1;
		}
		int val =fibonacci(n-1)+fibonacci(n-2);
//		System.out.print(val +" ");
		return val;
		
	}
}
