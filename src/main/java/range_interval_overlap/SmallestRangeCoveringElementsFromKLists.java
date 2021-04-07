package range_interval_overlap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
	public static void main(String[] args) {
		List<List<Integer>> lists = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(1,2,3),
				Arrays.asList(1,2,3)
		);	
		SmallestRangeCoveringElementsFromKLists sol = new SmallestRangeCoveringElementsFromKLists();
		int range[]=sol.smallestRangeV2(lists);
		System.out.println(range[0]+":"+range[1]);
	}
	public int[] smallestRangeV2(List<List<Integer>> lists) {
		//(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]
		PriorityQueue<int[]> minQ = new PriorityQueue<int[]>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
		PriorityQueue<int[]> maxQ = new PriorityQueue<int[]>((a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
		for ( int i =0; i<lists.size(); i++){
			minQ.offer(new int[] { lists.get(i).get(0),i,0});
			maxQ.offer(new int[] {lists.get(i).get(0),i,0});
		}
		int min =minQ.peek()[0], max =maxQ.peek()[0];
		Integer range = max-min;
		
		while(!minQ.isEmpty() && !maxQ.isEmpty()) {
			int[] minEle = minQ.poll();
			int listNum = minEle[1];
			int index = minEle[2];
			if(index+1 == lists.get(listNum).size())
				break;
			index++;
			int nextInList = lists.get(listNum).get(index);
			minQ.add(new int[] {nextInList,listNum,index});
			maxQ.add(new int[] {nextInList,listNum,index});
			int t_max  = maxQ.peek()[0], t_min= minQ.peek()[0];
			if(range == null || t_max-t_min<range) {
				min =t_min; max =t_max ;range = t_max -t_min;
			}
		}
		return new int[]{min, max}           ;
	}
	public int[] smallestRange(List<List<Integer>> lists) {
        int min =lists.get(0).get(0) , max   =lists.get(0).get(0), ptr=0;
        int[] it = new int[lists.size()];
        Integer minRange = null;
        while(true){
            int t_min =lists.get(ptr).get(it[ptr]) , t_max   =lists.get(ptr).get(it[ptr]),
            		tempRange =t_max-t_min;
            for ( int i =0; i<lists.size(); i++){
                if(t_min>lists.get(i).get(it[i])){
                    t_min =lists.get(i).get(it[i]);
                    ptr =i;
                }
                t_max=Math.max(t_max,lists.get(i).get(it[i]));		 
            }
            tempRange = t_max-t_min;
            if (minRange==null|| tempRange <minRange ){
                min =t_min;
                max=t_max;
                minRange = tempRange;
            }
            it[ptr]++;
            if(it[ptr] == lists.get(ptr).size())
            	break;
        }
        return new int[]{min, max}                               ;
    }
}
