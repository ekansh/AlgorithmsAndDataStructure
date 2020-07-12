package amazon.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * array represents houses which compete by flipping their state
 * THeir state flipping rule  is something like this : 
 * if adjacent house are not competing  OR adjacent house are competing 
 * don't participate
 * otherwise do and flip your state from 1 to 0 or 0 to 1
 * need to find out what will be house's state after n Days
 */
public class StateOfCompetingHouseAfterNDays {
	
	public static void main(String[] args) {
		int []k ={1,1,1,0,1,1,1,1};
		List<Integer> cellCompete = new StateOfCompetingHouseAfterNDays().cellCompete(k, 2);
		cellCompete.stream().forEach(System.out::println);
	}

	public List<Integer> cellCompete(int[] states, int days) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(0);
		List<Integer> lf= new ArrayList<>();
		for (int i = 0; i < states.length; i++) {
			l1.add(states[i]);
		}
		l1.add(0);
		for( int p=0;p<days;p++) {
			lf  =flip(l1);
			boolean removeAll = l1.removeAll(l1);
			l1.add(0);
			for (int i = 0; i < lf.size(); i++) {
				l1.add(lf.get(i));
			}
			l1.add(0);
			
			
		}
		return lf;
	}

	private List<Integer> flip(List<Integer> l1) {
		List<Integer> lf = new ArrayList<Integer>();
		for (int i = 0; i < l1.size(); i++) {
			if(i==0 ) {
				 continue;
			}
			if(i==l1.size()-1 ) {
				break; 
			}
			if( (l1.get(i-1) ==0 && l1.get(i+1) ==0) || (l1.get(i-1) ==1 && l1.get(i+1) ==1) ) {
				lf.add(0);
			}else {
				Integer flipValue = flipValue(l1.get(i));
				lf.add(1);
			}
		}
		return lf;
	}

	private Integer flipValue(Integer integer) {
		if (integer ==1 ) {
			return 0;
		}if (integer ==0 ) {
			return 1;
		}
		return -1;
	}
}