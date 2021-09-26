import java.util.*;
import java.util.stream.IntStream;

public class RandomQ3 {
	public static void main(String[] args) {
		RandomQ3 r = new RandomQ3();
		int[] nums1 = { 1, 2, 3, 2, 1 }, nums2 = { 3, 2, 1, 4, 7 };
//		r.findLength(nums1,nums2);
//		r.transpose(new int[][] { { 10, 6, 3, 5 }, { 10, 2, 4, 8 }, { 3, 8, 3, 10 }, { 7, 8, 8, 6 } });
//		test();
		r.crs =new int [][]{{5,5},{2,6},{6,9}};
		r.fx( 
			0,0);
		//	{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}}
//		});
		String s = "h z a ll o";
//		r.text = s.split(" ");
//		r.len =5;
//		r.balancedWrapLines(0,0);
//		System.out.println(r.min);
	}
	String[]  text;
	int min =111110;
	int len;
	public void balancedWrapLines(int pos,  int total) {
		
		int sum =0,curLen=0,diff=0;
		if (pos == text.length) {
			
			min = Math.min(min, total);
			System.out.println("---"+min);
			return;
		}
		for ( int i =pos; i< text.length ;i++) {
			if ( i == pos) {
				curLen = curLen+text[i].length();
				diff  = len - curLen ;
				sum = diff * diff;
			}else if( len -( curLen+text[i].length()+1 ) >0){
				curLen = curLen+text[i].length()+1;
				diff  = len - curLen ;
				sum = diff * diff;
			}
			System.out.println("line "+pos+" length "+sum);
			balancedWrapLines(i+1,sum+total); 
		}
	}
	 

	public int[][] transpose(int[][] matrix) {

		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		if (m != n) {
			return transposee(matrix);
		}
		for (int j = 0; j <= n; j++) {
			int r1 = n - j, r2 = 0, c1 = 0, c2 = n - j, k = (r1 + 1) / 2;
			for (int i = 0; i < k; i++) {
				swap(matrix, r1, c1, r2, c2);
				r1--;
				c1++;
				r2++;
				c2--;
			}
		}

		for (int j = 1; j <= n; j++) {
			int r1 = n, r2 = j, c1 = j, c2 = n, k = ((n - j + 1)) / 2;
			for (int i = 0; i < k; i++) {
				swap(matrix, r1, c1, r2, c2);
				r1--;
				c1++;
				r2++;
				c2--;
			}
		}
		return matrix;

	}

	public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
		int temp = matrix[r1][c1];
		matrix[r1][c1] = matrix[r2][c2];
		matrix[r2][c2] = temp;
	}

	public int[][] transposee(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		int mat[][] = new int[n][m];
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				mat[j][i] = matrix[i][j];
			}
		}
		return mat;
	}

	public int findLength(int[] A, int[] B) {
		int ans = 0;
		int[][] memo = new int[A.length + 1][B.length + 1];
		for (int i = A.length - 1; i >= 0; --i) {
			for (int j = B.length - 1; j >= 0; --j) {
				if (A[i] == B[j]) {
					memo[i][j] = memo[i + 1][j + 1] + 1;
					if (ans < memo[i][j])
						ans = memo[i][j];
				}
			}
		}
		return ans;
	}

	private static void findRectangle(int[][] image) {
		List<Integer> start_end = new ArrayList<>();
		int row = image.length, col = image[0].length;
		int i = 0, j = 0;
		for (; i < row; i++) {
			for (j = 0; j < col; j++) {
				if (image[i][j] == 0) {
					start_end.add(i);
					start_end.add(j);
					break;
				}
			}
			if (start_end.size() > 0) {
				break;
			}
		}

		for (; j < col; j++) {
			if (image[i][j] == 1) {
				break;
			}
		}
		// j== col implies we hit the end of row which implies j-1 was 0;
		// j<col implies we hit the cell where i,j == 1
		// either way answer is at j-1
		j = j - 1;
		for (; i < row; i++) {
			if (image[i][j] == 1) {
				break;
			}
		}
		// i== row implies we hit the end of col which implies i-1 was 0;
		// i<row implies we hit the cell where i,j == 1
		// either way answer is at i-1
		i = i - 1;
		start_end.add(i);
		start_end.add(j);
		System.out.println(
				start_end.get(0) + ":" + start_end.get(1) + ":" + start_end.get(2) + ":" + start_end.get(3) + ":");
	}

	public static void test() {
		int[][] image1 = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
		int[][] image2 = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0 } };
		int[][] image3 = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 0, 0 } };
		int[][] image4 = { { 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
		int[][] image5 = { { 0 } };
		findRectangle(image2);
		findRectangle(image3);
		findRectangle(image4);
		findRectangle(image5);
	}


	public int scheduleCourse(int[][] courses) {
        if ( courses.length ==0 ) return max;
        Arrays.sort( courses, (a,b) -> a[1] -b[1]);
        Arrays.stream(courses).forEach(e-> System.out.print(e[0]+","+e[1]+", "));
        System.out.println("");
            helper(0,0,0,courses) ;
        return max;
    }
    int max =0;
    public void helper(int day, int pos,int num,int[][] courses) {
        
    	 if (  pos  == courses.length || day+ courses[pos][0] >courses[pos][1] ){
            max = Math.max( max, num);
            return;
        }
        for ( int i =pos;i<courses.length; i++){
            if ( day+ courses[i][0] <=courses[i][1]){
                IntStream.range(0,pos).forEach(e->System.out.print(" "));
                System.out.println(day+"->"+courses[i][0]+","+courses[i][1]);
                helper(day+courses[i][0],i+1,num+1,courses);    
            }
            
        }
    }
    int crs[][] = null;
    public int fx( int day, int pos){
        if(  pos  == crs.length){
            return 0;
        }
       
        int max =0,k= 0;
        for ( int i =pos;i<crs.length; i++){
            if( day+crs[i][0] <= crs[i][1]){
                k = 1+fx( day+crs[i][0], i+1);
            }
        }
        max = Math.max( max, k);
        return max;
    }


}
