import java.util.*;

public class RandomQ2 {
	public static void main(String[] args) {
		RandomQ2 r= new RandomQ2(); 
		String k = new StringBuilder(12).toString();
		System.out.println(k);

		String[][] badge_times = { { "Paul", "1355" }, { "Jennifer", "1910" }, { "John", "830" }, { "Paul", "1315" },
				{ "John", "1615" }, { "John", "1640" }, { "John", "835" }, { "Paul", "1405" }, { "John", "855" },
				{ "John", "930" }, { "John", "915" }, { "John", "730" }, { "Jennifer", "1335" }, { "Jennifer", "730" },
				{ "John", "1630" }, };

//		Map<String, List<Integer>> badgeTimes = badgeTimes(badge_times);
		// System.out.println(badge_times);
		r.subdomainVisits(new String[]{"10 y.z.com","40 y.z.com" , "90 z.com" });
		System.out.println();
	}

	public List<String> subdomainVisits(String[] cpdomains) {
		List<String> ls = new ArrayList<>();
		Node root = new Node();
		for (String str : cpdomains) {
			Node cur = root, prev = root;
			String info[] = str.split("\\s+");
			int count = Integer.parseInt(info[0]);
			String[] frags = info[1].split("\\.");

			for (int i = frags.length - 1; i >= 0; i--) {
				prev = cur;
				cur = cur.nodes.get(frags[i]);
				if (cur == null) {
					cur = new Node();
					cur.domain = frags[i];
					cur.count = 0;
					prev.nodes.put(frags[i], cur);
				}
				cur.count += count;
			}
		}
		//dfs(root);
		dfs(ls, root, "");
		return ls;
	}

	public int dfs(Node cur) {
		if (cur == null) {
			return 0;
		}

		int sum = cur.count;
		for (String s : cur.nodes.keySet()) {
			int n = dfs( cur.nodes.get(s));
			sum += n;
		}
		cur.count = sum;
		return sum;
	}

	public void dfs(List<String> ls, Node cur, String domain) {
		if (cur == null) {
			return;
		}
		for (String aDomainName : cur.nodes.keySet()) {
			Node theDomain = cur.nodes.get(aDomainName);
			ls.add(theDomain.count + " " + theDomain.domain + domain);
			dfs(ls, theDomain, "." + theDomain.domain + domain);
		}
	}

	static Map<String, List<Integer>> badgeTimes(String[][] input) {

		Map<String, TreeSet<Integer>> map = new HashMap<>();
		Map<String, List<Integer>> res = new HashMap<>();
		for (String[] s : input) {
			String name = s[0];
			int time = Integer.parseInt(s[1]);
			map.putIfAbsent(name, new TreeSet<>());
			map.get(name).add(time);

			if (map.get(name).size() >= 3 && !res.containsKey(name)) {
				NavigableSet<Integer> nav = map.get(name).subSet(time - 100, true, time, true);
				if (nav.size() >= 3) {
					res.put(name, new ArrayList<>(nav));
				}
			}

		}

		return res;
	}
}

class Node {
	String domain="";
	int count=0;
	Map<String,Node> nodes = new HashMap<>();
}
