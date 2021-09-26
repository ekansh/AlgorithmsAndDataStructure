package algos.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TextJustify {
	// CALL : List<String> fullJustify = sol.fullJustify(words, 16); 
	 // fullJustify.forEach(e->System.out.println(e));
	public   List<String> fullJustify(String[] words, int maxWidth) {
		List<String> l = new ArrayList<>();
		int cur_len = 0, start = 0;
		for (int i = 0; i < words.length; i++) {
			cur_len += words[i].length() + 1;
			if (cur_len - 1 > maxWidth) {
				// then there is an extra space in the end
				// sentence starts from start and ends at prev_index
				String j = justified(cur_len - 1 -(words[i].length()+1), start, i - 1, words, maxWidth);
				l.add(j);
				// basically i points to word that I wont be using so decrement i as for loop
				// increment i in the end
				// start will start from 'i' ;
				start = i;
				i--;
				cur_len = 0;
			} else if (cur_len - 1 == maxWidth) {
				// then there is An extra space in the end
				// sentence starts from start and ends at i
				String j = justified(cur_len - 1, start, i, words, maxWidth);
				l.add(j);
				start = i + 1;
				cur_len = 0;
			}
		}
		if (cur_len != 0) {
			if(words.length - 1 == start) {
                StringBuilder sb = new StringBuilder(words[start]);
                StringBuilder spaces = new StringBuilder( );
                IntStream.range(0, maxWidth -sb.length()).forEach(e -> spaces.append(" "));
				l.add(sb.append(spaces).toString());
			}else {
				String j = justified(cur_len - 1, start, words.length - 1, words, maxWidth);
				l.add(j);
			}
		}
		// once loop ends and start doesnt point words.length then simply add that
		// string in result
		return l;
	}

	// cur_len should have len of all words from [start-end]+ 1 space between each
	// word
	// also no space in the end
	public   String justified(int cur_len, int start, int end, String[] words, int maxWidth) {

		// len =13, 4 ab abd abd ab , 16.. extra = 1 /(3-1)= 2 ; 01
		// ab abd abd
		int div  = end == start?1: end-start;
		int extraSapce = (maxWidth - cur_len) / div;
		StringBuilder spaces = new StringBuilder();
		IntStream.range(0, extraSapce).forEach(e -> spaces.append(" "));
		int modulo = (maxWidth - cur_len) % div; // add one of them in each
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			sb.append(words[i] + " ");
			if (modulo > 0) {
				sb.append(" ");
				modulo--;
			}
			sb.append(spaces);
		}
		return sb.substring(0,maxWidth);

	}
}
