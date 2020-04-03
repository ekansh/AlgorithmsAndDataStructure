import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {

	static List<Integer> nums =  new ArrayList<Integer>();
	static List<List<Integer>> pairsOf100 = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		for( int i = 0; i< args.length;  i++ ){
			Integer num=  Integer.valueOf(args[i]);
			nums.add(num);
		}
		Collections.sort(nums);
		System.out.println("inital list");
		printNum(nums);
		int outerIndex=0;
		 
		for (; outerIndex<nums.size() ; outerIndex++) {
			int currentSum =0;
			List<Integer> tempSolution = new ArrayList<>();
			System.out.println("trying with "+ nums.get(outerIndex) );
			
			for (int innerIndex=outerIndex+1; innerIndex < nums.size() ; innerIndex++){
				System.out.println("Inner number "+ nums.get(innerIndex) );
				currentSum = nums.get(innerIndex)+nums.get(outerIndex);
				if ( currentSum != 100 ){
					// do nothing
				}
				if (currentSum == 100){
					pairsOf100.add(tempSolution);
					tempSolution.add(nums.get(innerIndex));
					tempSolution.add(nums.get(outerIndex));
					break;
				}
				
			}
			
			
		}
		System.out.println("pairs ");
		for(List<Integer> pairs: pairsOf100){
			printNum(pairs);
		}
		
	}
	public static void printNum(List<Integer> l){
		for (Integer integer : l) {
			System.out.print(" "+integer);
		}
		System.out.println("  ");
	}

}
