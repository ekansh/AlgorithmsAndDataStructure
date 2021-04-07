package graph;

import java.util.*;

/**
 * Q) There are N different packages. the ith package is of X[i] days and the price of that package is Y[i]. There are M customers. the jth customer wants the package of at least A[j] days and he doesn't want to spend more than B[j] for any package. One package can accommodate at most one customer and a customer can buy at most one package. You have to find the maximum number of packages, you can sell.
I am unable to think of an approach which will result in an optimal answer for all cases. What can that be ?
https://leetcode.com/discuss/interview-question/785229/google-phone-interview-question
 * @author Ekansh
 *
 */
public class VacationPackageAssignmentMatching {
	public static void main(String[] args) {
		List<Customer> custs = Arrays.asList(new Customer(5,8),new Customer(1,7));
		List<Vacation> vacs = Arrays.asList(new Vacation(5,8),new Vacation(6,5));
		VacationPackageAssignmentMatching vc = new VacationPackageAssignmentMatching();
		vc.getMaxPackagesThatCanBeSold(custs, vacs);
	}
	public int getMaxPackagesThatCanBeSold(List<Customer> custs, List<Vacation> vacs){
		Collections.sort(custs, (a,b)->a.days == b.days ? a.price-b.price:a.days-b.days);
		Collections.sort(vacs, (a,b)->a.days == b.days ? a.price-b.price:a.days-b.days);
		PriorityQueue<Customer> pq = new PriorityQueue<>((a,b)->a.v.size() -b.v.size());
		for (Customer cust: custs) {
			for (Vacation aPackage : vacs) {
				if(cust.days<=aPackage.days && cust.price>=aPackage.price ) {
					cust.v.add(aPackage);
				}
			}
			pq.add(cust);
		}
		Set<Vacation> assigned = new HashSet<>();
		while(pq.size()>0) {
			Customer aCust = pq.poll();
			Vacation allocated = null;
			for(Vacation aPackage : aCust.v) {
				if(assigned.contains(aPackage)) continue;
				assigned.add(aPackage);
				allocated = aPackage;
				break;
			}
			aCust.v.clear();
			aCust.v.add(allocated);
		}
		for (Customer cust: custs) {
			System.out.print ("Customer "+cust.days+":"+cust.price);
			for (Vacation aPackage : cust.v) {
				System.out.println(" :: Vacation "+aPackage.days+":"+aPackage.price);
			}
			System.out.println();
		}
		return assigned.size();
	}
	private static class Customer{
		int days, price;
		Customer(int d, int p){
			days=d;
			price=p;
		}
		List<Vacation> v= new LinkedList<>();
		@Override
		public String toString() { return days+":"+price;}
	}
	private static class Vacation{
		int days, price;
		Vacation(int d, int p){
			days=d;
			price=p;
		}
		@Override
		public String toString() { return days+":"+price;}
	}
}

