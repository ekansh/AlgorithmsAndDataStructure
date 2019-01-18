package algos.strings.manipulation;

import java.util.BitSet;
import java.util.Map;

public class CheckIfStringHaveDuplicates {
//	static BitSet [] ascii = new BitSet[256];
	static byte [] ascii = new byte[256];
	public static void main(String[] args) {
	
		String s = "aba";
		
		boolean flag = true;
		int len= s.length();
		for (int i = 0; i < s.length(); i++) 
			if(isDuplicate(s.charAt(i))){
				System.out.println("duplicate");
			}
		}
			
		
	private static boolean isDuplicate(char charAt) {
		int index = charAt;
		boolean dupsFound = false;
		if (ascii[index]== 0){
			ascii[index]=1;
			
		}else {
			dupsFound = true;
		}
		return dupsFound;
				
	}
}
