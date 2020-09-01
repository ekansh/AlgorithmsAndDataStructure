package range_interval_overlap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	}
	public static void main(String[] args) {
		Interval blue[] = null, red= null;
		List<Interval> bl= Arrays.stream(blue).filter(b-> b.end<=red.start || b.start >= red.end).collect(Collectors.toList());
		bl.sort((a,b)->a.start -b.start <=0?-1:1);
		mergeIntervals(bl);
	}
	private static void mergeIntervals(List<Interval> bl) {
		// TODO Auto-generated method stub
		
	}
}
