package range_interval_overlap;

import java.util.*;
/**
 * Assume I have a list of people with their arrival and departure time
 * at an event that happened in the past.
 * My task is to find out the maximum number of people 
 * present in the event at any time? I am not given query time.
 * ai = Arrival time of person i
 * di = Departure time of person i
 * I have a list of pairs like (a1,d1), (a2,d2), (a3,d3).... (an,dn)
 * {@link https://stackoverflow.com/questions/15168837/amazon-interview-maximum-number-of-people-present-at-an-event-at-any-time}
 * @author Ekansh
 *
 */
public class MaximumNumberOfPeopleInEventAtAnyTime {
	public static void main(String[] args) {
		MaximumNumberOfPeopleInEventAtAnyTime  m = new MaximumNumberOfPeopleInEventAtAnyTime();
		int[][] interval = {{2,8}, {3,6},{6,9},{10,12},{10,13},{10,13},{10,13}};
		int max = m.getMaximumNumberOfPeopleInEventAtAnyTime (interval);
		System.out.println(max);
	}
	 public int getMaximumNumberOfPeopleInEventAtAnyTime(int[][] intervals) {
//	        List<int[]>res = new ArrayList<>();
//		        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(a, b) -> a[0] ==b[0]  ?a[1]-b[1]:a[0] - b[0]);
			for (int a[] : intervals) {
				pq.offer(a);
			}
			int count = pq.isEmpty()?0:1, max =0;
			int a[] =pq.peek();
			int [] timeAtWhichMostPeople = pq.peek();
			while (pq.size() > 1) {
				  a  = pq.poll();// take out
				int b[] = pq.poll();//first and second top element
				if ( a[1] > b[0]) { // see if the can be merged   a[0] <= b[1] && b[0] <= a[1]
					int newInterval[] = new int[2];
					newInterval[0] = Math.max(a[0], b[0]);
					newInterval[1] = Math.min(a[1], b[1]);
					pq.offer(newInterval);// put merged element back into pq
					count++;
				} else { // if not then 
					if(max <count) {
						max= count;
						timeAtWhichMostPeople =a;
					}
					count =1;
//					res.add(a);//put the top most element in result
					pq.offer(b); // and second top element back to pq
				}
			}
//			while (!pq.isEmpty()) {
//				res.add(  pq.poll());
//			}
//			int[][] finalResult  = new int[res.size()][2];
//			for (int i=0; i<res.size();i++) {
//				finalResult[i] =res.get(i);
//			}
			if(max <count) {
				max= count;
				timeAtWhichMostPeople =a;
			}
			System.out.println(timeAtWhichMostPeople[0]+","+timeAtWhichMostPeople[1]);
			return  max;
		
	    }
}
