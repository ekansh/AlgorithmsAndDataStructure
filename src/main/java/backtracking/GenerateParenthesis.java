package backtracking;

import java.util.*;

public class GenerateParenthesis {
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> gen = gp.gen(2*2);
		List<String> r = new ArrayList<String>();
		for(String str : gen) {
			if(gp.validate(str)) {r.add(str);}
		}
		for(String str : r) {
			System.out.println(str);
		}
	}
	private boolean validate(String str) {
		int cl =0, op =0;
		for ( int i =0;i<str.length(); i++) {
			char ch = str.charAt(i);
			if ( ch ==')') {
				op--;
			}
			else if( ch=='(') {
				op++;
			}
			if(op<0) {
				return false;
			}
		}
		return op==0 && cl==0;
	}
	List<String> def = new ArrayList<String>() {{add("");}};
	Map<Integer,List<String>> memo = new HashMap<Integer,List<String>>() {{put(0,def);}};
	public List<String> gen(int n) {
		if(memo.containsKey(n)) return memo.get(n);
		List<String> l=gen(n-1);
		List<String> res = new ArrayList<>();
		for(String str : l) {
			res.add("("+str);
			res.add(")"+str);
		}
		memo.put(n, res);
		return res;
	}
}
