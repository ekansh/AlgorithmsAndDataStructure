package graph;

import java.util.*;

public class CurrencyConversion {
	char currency[][] = new char[][] { { 'A', 'B' }, { 'A', 'D' }, { 'D', 'B' }, { 'B', 'C' }, { 'D', 'C' } };
	int prices[] = new int[] { 5, 2, 1, 1, 7 };
	Map<Character, Map<Character, Integer>> map = new HashMap<>();
	Map<Character, Pair> adj = new HashMap<>();
	Map<Character, Info> memo = new HashMap<>();
	LinkedList<Character> path = new LinkedList<>();
	int best = Integer.MAX_VALUE;

	// A: b, ; c, ;d, ;
	public static void main(String[] args) {
		CurrencyConversion cc = new CurrencyConversion();
		cc.findBestSol();
		System.out.println();
	}

	private void findBestSol() {
		createGraph();
//		System.out.println(" Each dfs will output the best ");
//		Info inf = dfs('A', 'D');
//		inf.l.forEach(e -> System.out.print(e + ":"));
//		System.out.println(inf.d);
//
//		System.out.println(" Each dfs will carry on the state");
//		dfs('A', 'D', 0, new LinkedList<Character>());
//		System.out.println(best);
//		path.addFirst('A');
//		path.forEach(e -> System.out.print(e + ":"));

		dijkstra('A', 'D');
	}

	

	private void dijkstra(char s, char d) {
		Pair p = new Pair();
		p.d = 0;
		adj.put(s, p);
		Queue<Character> q = new LinkedList<>(); // this should be PQ on the weight
		q.add(s);
		Set<Character> visited = new HashSet<>();

		while (!q.isEmpty()) {
			int b = q.size();
			for (int i = 0; i < b; i++) {
				char ele = q.poll();
				if (visited.contains(ele))
					continue;
				visited.add(ele);
				Map<Character, Integer> neighbours = map.get(ele);
				if (neighbours == null)
					continue;
				Pair currentPair = adj.get(ele);
				int currentWeight = currentPair.d;
				for (char node : neighbours.keySet()) {
					int weight = neighbours.get(node);
					if (currentWeight + weight < adj.get(node).d) {
						Pair tp = new Pair();
						tp.d = currentWeight + weight;
						tp.source = ele;
						adj.put(node, tp);
					}
					if (!visited.contains(node))
						q.add(node);
				}
			}
		}
		System.out.println(adj.get(d));
	}

	public void createGraph() {
		for (int i = 0; i < currency.length; i++) {
			char[] cs = currency[i];
			map.putIfAbsent(cs[0], new HashMap<>());
			Map<Character, Integer> dest = map.get(cs[0]); // correspondingPrices
			dest.put(cs[1], prices[i]);
			adj.putIfAbsent(cs[0], new Pair());
			adj.putIfAbsent(cs[1], new Pair());
		}
	}

	public Info dfs(char s, char t) {
		Info inf = new Info();
		if (s == t) {
			inf.l.addFirst(t);
			return inf;
		}
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		Map<Character, Integer> exchanges = map.get(s);
		int p = Integer.MAX_VALUE;
		for (char aCur : exchanges.keySet()) {
			int currentExchangePrice = exchanges.containsKey(aCur) ? exchanges.get(aCur) : 0;
			Info temp = dfs(aCur, t);
			if (p > currentExchangePrice + temp.d) {
				p = currentExchangePrice + temp.d;
				inf.d = currentExchangePrice + temp.d;
				inf.l = new LinkedList<Character>(temp.l);
			}
		}
		inf.l.addFirst(s);
		memo.put(s, inf);
		return inf;
	}

	public void dfs(char s, char t, int val, LinkedList<Character> tl) {
		if (s == t) {
			if (best > val) {
				path = new LinkedList<>(tl);
				best = val;
			}
			return;
		}
		Map<Character, Integer> exchanges = map.get(s);
		for (char aCur : exchanges.keySet()) {
			int currentExchangePrice = exchanges.containsKey(aCur) ? exchanges.get(aCur) : 0;
			tl.add(aCur);
			dfs(aCur, t, val + currentExchangePrice, tl);
			tl.removeLast();
		}
	}

	public int dfs_itterative(char src, char target) {
		Stack<Character> st = new Stack<>();
		Set<Character> seen = new HashSet<>();
		st.push(src);
		int total = 0;
		while (!st.isEmpty()) {
			int size = st.size();
			char prevSource = src;
			int bestSoFar;
			for (int i = 0; i < size; i++) {
				char ele = st.pop();
				if (seen.contains(ele))
					continue;
				if (ele != target)
					seen.add(ele);

				Map<Character, Integer> exchange = map.get(prevSource);
				int priceFromPrevSourceToEle = exchange.containsKey(ele) ? exchange.get(ele) : 0;
				for (Character p : exchange.keySet()) {
					if (!seen.contains(p)) {
						st.add(p);
					}
				}
				prevSource = ele;
			}
		}
		return 0;

	}

	private static class Info {
		int d = 0;
		LinkedList<Character> l = new LinkedList<>();
	}

	private static class Pair {
		int d = Integer.MAX_VALUE;
		char source = ' ';

		@Override
		public String toString() {
			return source + ":" + d;
		}
	}

}
