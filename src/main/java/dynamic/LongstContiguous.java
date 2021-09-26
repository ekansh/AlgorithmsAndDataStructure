package dynamic;

import java.util.*;

public class LongstContiguous {
	
	public static void main(String[] args) {
		String url[][]= new String[][]{{"/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"},
		 {"/start", "/pink", "/register", "/orange", "/red", "a"},
		 {"a", "/one", "/two"},
		 {"/pink", "/orange", "/yellow","/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue","/LightGoldenRodYellow", "/BritishRacingGreen"},
		 {"/pink", "/orange","/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red","/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"},
		 {"a"},
		 {"/pink","/orange","/six","/plum","/seven","/tan","/red","/amber"}};
		 int [][]k=null;
		 Arrays.sort(k,(a,b) ->a[0]==b[0]?a[1]-b[1] :a[0] -b[0] );
		for ( int i =0;i<url.length;i++) {
			for(int j =i+1;j<url.length;j++) {
				String find = find(url[i],url[j]);
				System.out.println("user"+i+",user "+j+":"+find);
			}
		}
		
	}

	private static String find(String[] u1, String[] u2) {
		int dp[][] = new int[u1.length+1][u2.length+1];
		int max = 0,start=-1;
		for (int i =u1.length-1;i>=0;i--) {
			for ( int j =u2.length-1;j>=0;j--) {
				if( u1[i]==u2[j]) {
					dp[i][j] = dp[i+1][j+1]+1;
					if( max<dp[i][j]) {
						max = dp[i][j];
						start=i;
						break;
					}
				}
			}
		}
		String str ="";
		if ( start ==-1) return str;
		for ( int i = start ;i<start+max;i++) {
			str+=u1[i];
		}
		return str;
	}
}
