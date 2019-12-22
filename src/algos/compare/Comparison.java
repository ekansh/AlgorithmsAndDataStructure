package algos.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public   class Comparison implements Comparable<Comparison>{
    int low;
    public Comparison(int low ){
        this.low = low;
    }
    @Override
    public int compareTo(Comparison o) {
        if(this.low <= o.low){
            return -1;
        }else{
            return 1;
        }
    }
    @Override
    public String toString() {
    	return low+" ";
    }
	 
    public static void main(String[] args) {
		Comparison c1 = new Comparison(12);
		Comparison c2 = new Comparison(1);
		Comparison c3 = new Comparison(3);
		Comparison c4 = new Comparison(4);
		Comparison c5 = new Comparison(1);
		List<Comparison> clist= new ArrayList<>();
		clist.add(c1);
		clist.add(c2);clist.add(c3);clist.add(c4);clist.add(c5);
		Collections.sort(clist);
		clist.stream().forEach(System.out::print);
	}
    
}