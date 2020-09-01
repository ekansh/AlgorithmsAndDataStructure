package amazon.string;

import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.*;
import java.util.regex.*;
//popularNFeatures2 is working
class FindMostRequestedFeatures {

	static int numFeatures = 5;
	static int topFeatures = 2;
	static String[] possibleFeatures = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
	static int numFeatureRequests = 3;
	static String featureRequests[] = { "I love anacell Best services provided by anacell in the town",
			"betacellular has great services", "deltacellular provides much better services than betacellular",
			"cetracular is worse than eurocell", "betacellular is better than deltacellular	"

	};

	public static void main(String[] args) {
		FindMostRequestedFeatures solution = new FindMostRequestedFeatures();
		// using default input
		// PREPARE INPUT 1: input1();
		// PREPARE INPUT 2: input2();
		solution.popularNFeatures2(numFeatures, topFeatures, Arrays.asList(possibleFeatures), numFeatureRequests,
				Arrays.asList(featureRequests));
	}

	private static void input2() {
		int numFeatures = 5;
		int topFeatures = 2;
		String[] possibleFeatures = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		int numFeatureRequests = 3;
		String featureRequests[] = { "Best services provided by anacell", "betacellular has great services",
				"anacell provides much better services than all other" };
	}

	private static void input1() {
		int numFeatures = 6;
		int topFeatures = 2;
		String[] possibleFeatures = { "hover", "battery", "storage", "alexa", "waterproof", "solar" };
		int numFeatureRequests = 7;
		String featureRequests[] = { "I wish my Kindle had even more storage!",
				"I wish the battery life on my Kindle lasted 2 years.",
				"I read in the bath and would enjoy a waterproof Kindle",
				"Waterproof and increased battery are my top two requests.",
				"I want to take my Kindle into the shower. Waterproof please waterproof !",
				"It would be neat if my Kindle would hover on my desk when not in use.",
				"How cool would it be if my Kindle charged in the sun via solar power?" };
	}

	// Solution 1: depends on two other function : getMostSoughtFeatures and getStringPresence
	
	public ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> r= new ArrayList<>();
		Map<String,Integer> mp= getMap(possibleFeatures);
		for (String st : featureRequests) {
			for (String string : possibleFeatures) {
				int k=getStringPresence(string,st);
				mp.put(string,mp.get(string)+k);
			}
		}
		r=getMostSoughtFeatures(mp,topFeatures);
		Collections.sort(r);
		r.stream().forEach(System.out::println);
		return r;
	}
	// Solution 2: depends on a class  two other function : getMostSoughtFeatures and getStringPresence
	private class  Pair{
		String s ;
		Integer f;
		Pair(String a, Integer b){
			s=a; f =b;
		}
	}
	public ArrayList<String> popularNFeatures2(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.f==a.f? a.s.compareTo(b.s):b.f-a.f);
		
		ArrayList<String> r= new ArrayList<>();
		Map<String,Integer> mp= getMap(possibleFeatures);
		for (String aFeatureReuested : featureRequests) {
			for (String string : possibleFeatures) {
				int k=getStringPresence(string,aFeatureReuested);
				mp.put(string,mp.get(string)+k);
			}
		}
		for (String k: mp.keySet()) {
			pq.add(new Pair(k,mp.get(k)));
		}
			 
		while ( !pq.isEmpty()&& topFeatures!=0) {
			Pair poll = pq.poll();
			topFeatures--;
			r.add(poll.s);
		}
		r.stream().forEach(System.out::println);
		return r;
	}

	private ArrayList<String> getMostSoughtFeatures(Map<String, Integer> mp, int topFeatures) {
		ArrayList<String> r= new ArrayList<>();
		ArrayList<String> r1= new ArrayList<>();
		mp.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(e -> r.add(e.getKey()));
		for(int i = r.size()-1;i>topFeatures;i--) {
			r1.add(r.get(i));
		}
//		mp.entrySet()
//		  .stream()
//		 .filter(e -> e.getValue() >=topFeatures).forEach(e -> r.add(e.getKey()));
		return r1;
	}

	private int getStringPresence(String regex, String st) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(st);	

        int count = 0;
        while (matcher.find())
            count++;
        return count;
	}

	private Map<String, Integer> getMap(List<String> possibleFeatures) {
		Map<String,Integer> mp=new HashMap<>();
		for (String string : possibleFeatures) {
			mp.put(string.toLowerCase(),0);
		}
		return mp;
	}
	
	
	public ArrayList<String> popularNFeatures3(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> l = new ArrayList<String>();
		Map<String,Integer> possibleFeatureMap = new HashMap<>();
		for (String string : possibleFeatures) {
			possibleFeatureMap.put(string,0);
		}
		Set<String> featureRequestsSet = new HashSet<>(featureRequests);
		Pattern pattern = Pattern.compile("\\w+");
		for (String string : featureRequests) {
			Matcher matcher = pattern.matcher(string);
			while(matcher.matches()) {
				String group = matcher.group();
				if(possibleFeatureMap.get(group)!=null) {
					possibleFeatureMap.put(group,possibleFeatureMap.get(group)+1);
				}
			}
		}
		Map<String, Integer> sortByValue = sortByValue(possibleFeatureMap);
		int i =0;
		for(String s : sortByValue.keySet()) {
			l.add(s);
			i++;
			if (i==topFeatures)break;
		}
		
		
		l.stream().forEach(System.out::println);
		
		
		return l;
	}
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
	////SOLUTION 4 starts/////
	public void popularNFeatures4() {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
	}

	/**
	 * Try making keywords lowercase if it doesnt work
	 */
	private static List<String> solve(int k, String[] keywords, String[] reviews) {
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>(Arrays.asList(keywords));
		Map<String, Integer> map = new HashMap<>();
		for (String r : reviews) {
			String[] strs = r.split("\\W");
			Set<String> added = new HashSet<>();
			for (String s : strs) {
				s = s.toLowerCase();
				if (set.contains(s) && !added.contains(s)) {
					map.put(s, map.getOrDefault(s, 0) + 1);
					added.add(s);
				}
			}
		}
		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,
				b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());
		while (!maxHeap.isEmpty() && k-- > 0) {
			res.add(maxHeap.poll().getKey());
		}
		return res;
	}
	////SOLUTION 4 ends/////
}
