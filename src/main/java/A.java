import java.util.*;

public class A {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>(); 
		ll.add(1);ll.add(2);ll.add(3);ll.add(4);
		ListIterator<Integer> node = ll.listIterator(0);
		Map<String, Integer> map = new HashMap<String, Integer>() {
			{
				put("A", 10);
				put("B", 20);
				put("C", 30);
			}
		};
		Map<Integer, String> lb = new HashMap<>();
		int cap = 0;
		for (String s : map.keySet()) {
			lb.put( cap+1, s);
			cap =cap+ map.get(s);
			lb.put( cap, s);
		}
		for (Integer val   : lb.keySet()) {
			System.out.println(val +"="+lb.get( val));
		}
		int r  = new Random().nextInt(cap);
		int max=cap, min =0;
		for (Integer val   : lb.keySet()) {
			if( r<=val && val<=max ) {
				max = val;
			}else if( r>=val && val>=min ) {
				min = r;
			}
		}
	
		System.out.println(r+","+min+","+max);
		System.out.println(lb.get(max));
		
	}
}
