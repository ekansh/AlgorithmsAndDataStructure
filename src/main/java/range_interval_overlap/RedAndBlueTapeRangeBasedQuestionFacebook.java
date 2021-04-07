package range_interval_overlap;

import java.util.*;

/**
 * 1. Given a red tape and a set of blue tapes. Tape is represented by interval.
 * We paste red tape on the line first and paste blue tapes onto the line later.
 * If blue tapes have overlap with red tape, the overlapping part will be
 * covered by blue tapes. You need to return a boolean to indicate whether red
 * tape is visible at the end.
 * 
 * 
 * Ex:  blue = [-6 -1] [0 2] [3 8]
 * Ex:  blue = [-6 -1] [0 7] [3 8]
 * Ex:  blue = [-6 -1] [0,4] [4 7]
 * Ex:  blue = [-6 -1] [5 7] [3 8] 
 * Red  = [4 6]
 * 
 * Blue ~~~~~~~~~~~~~~~~~~~~~~~~~ [12 21] Red ===============================
 * [-1,6] |-----|-----|-----|-----|-----|-----|-----|-----|-----| 0 1 2 3 4 5 6
 * 7 8 9
 * 
 * 
 * @author Ekansh
 *
 */
public class RedAndBlueTapeRangeBasedQuestionFacebook {
	private static class Interval{
		double start, end;
		Interval(){}
		Interval(double s, double e){ start=s; end =e;}
	}
	public static void main(String[] args) {
		List<Interval> bl = new ArrayList<>();
		bl.add(new Interval(1 ,2 ));bl.add(new Interval(2,5));
		bl.add(new Interval( 7,18));bl.add(new Interval( 19,200));
		bl.add(new Interval( 2,12));bl.add(new Interval( -1,15));
		bl.add(new Interval( 7,18));bl.add(new Interval( 19,22));
		Interval red =new Interval(10,20);
		System.out.println(mergeIntervals(bl,red));
	}
	private static boolean mergeIntervals(List<Interval> bl, Interval red) {
		double min = bl.get(0).start, max = bl.get(0).end;
		
		for(Interval interval : bl){
			min = Math.min(interval.start, min);
			max = Math.max(interval.end,max);
		}
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(
				 (a,b)->Double.compare(a.start, b.start) ==0 ? 
						 Double.compare(a.end,b.end): 
							 Double.compare(a.start, b.start)
					);
		for (Interval interval : bl) {
			if( interval.start>=red.end  || interval.end<=red.start)
				continue;
			pq.offer(interval);
		}
		if(pq.isEmpty()) {
			return true;
		}
		while( pq.size()>1){
			Interval first = pq.poll();
			Interval second = pq.poll();
			if(first.end>=second.start){ // merge them into one
				Interval merged = new Interval();
				merged.start = Math.min(first.start,second.start) ;// first.start will always be lesser
				merged.end = Math.max(first.end,second.end) ;
				pq.offer(merged);
			}else{
				return true;
			}
		}
		System.out.println(pq.size());
		// if you have reached here then there would be exactly one item in the pq ( unless input was empty) 
		Interval first = pq.poll();
		if( first.start>red.start || first.end < red.end) {
			return true;
		}
		return false;
	}
}
