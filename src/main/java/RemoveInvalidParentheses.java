import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {
	public Map<String, String> seen = new HashMap<>();
	public Queue<String> q= new LinkedList<>();
	public Set<String> res = new HashSet<>();
	public static void main(String[] args) {
		boolean validateCombination = new RemoveInvalidParentheses().validateCombination("a()");
		System.out.println(validateCombination);
		List<String> ans = new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()");
		System.out.println("---------------------");
		ans.stream().forEach(System.out::println);
	}

	public List<String> removeInvalidParentheses(String s) {
		if(validateCombination(s)) return Arrays.asList(s);
		
		Integer minCombos=null;
		q.add(s);
		System.out.println("trying combination : "+s);
		while(!q.isEmpty()) {
			String str = q.poll();
			for (int i =0;i<str.length();i++) {
				String combination =str.substring(0,i)+str.substring(i+1,str.length());
				if(!seen.containsKey(combination)) { // ()())() if we have already evaulated .. then do nothing
					System.out.println("trying combination : "+combination);
					seen.put(combination,combination);
					if(validateCombination(combination)) {
						if(minCombos==null ||combination.length()>= minCombos) {
							minCombos=combination.length();
							res.add(combination);
						}
					}else if(minCombos== null || (minCombos!=null && minCombos<combination.length())){// if not a vald combination then we have to try further combos
						q.add(combination);
					}
				}
			}
		}
		return new ArrayList<>(res);
	}
// a , a(a() , (a)
	private boolean validateCombination(String c) {
		 Stack<Character>  stack= new Stack<>();
		 for(int i =0;i<c.length(); i++ ) {
			 if(c.charAt(i)=='(') {
				 stack.push(c.charAt(i));
			 }else if(c.charAt(i)==')') {
				 if(stack.isEmpty()) 
					 	return false;
				 else
					 stack.pop();
			 }
		 }
		 if(stack.isEmpty()) {
			 return true;
		 }else {
			 return false;
		 }
	}
}
