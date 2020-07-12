package algos.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MyPow {

	public static void main(String[] args) {
		myPow(2,10);
	}

	    public static  double myPow(double x, int n) {
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        double ans = 1;
	        double current_product = x;
	        for (long i = N; i > 0; i /= 2) {
	            if ((i % 2) == 1) {
	                ans = ans * current_product;
	            }
	            current_product = current_product * current_product;
	        }
	        return ans;
	    }
}
