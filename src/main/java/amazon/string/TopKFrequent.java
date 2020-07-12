package amazon.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopKFrequent {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Node> freq = new HashMap<>();
		Arrays.stream(words).forEach(e -> {
			Node n = freq.getOrDefault(e, new Node(e, 0));
			n.freq = n.freq + 1;
			freq.put(e, n);
		});

		LinkedHashMap<String, Node> sorted = freq.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		List<String> l = new ArrayList<String>();
		for (String string : sorted.keySet()) {
			l.add(string);
			k--;
			if (k == 0) {
				break;
			}
		}

		return l;
	}

	private static class Node implements Comparable<Node> {
		String word;
		Integer freq;

		Node(String s, Integer w) {
			this.word = s;
			this.freq = w;
		}

		@Override
		public int compareTo(Node o) {
			if (o == null)
				return -1;
			if (this.freq == o.freq) {
				return this.word.compareTo(o.word);
			} else {
				return this.freq > o.freq ? -1 : 1;
			}
		}
	}
}
