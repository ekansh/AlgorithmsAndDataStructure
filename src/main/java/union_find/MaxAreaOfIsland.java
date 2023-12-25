package union_find;

public class MaxAreaOfIsland {
	public static void main(String[] args) {
		int[][] input = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int maxAreaOfIsland = getMaxAreaOfIsland(input);
		System.out.println(maxAreaOfIsland);
	}

	public static class UnionFind {
		private int[] rank, root;

		public UnionFind(int n) {
			rank = new int[n];
			root = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		public int Find(int i) {
			if (i == root[i])
				return i;
			return root[i] = Find(root[i]); // this helps in path compression. Otherwise, `return Find(root[i]);`
		}

		public int Union(int x, int y) {
			int rootX = Find(x);
			int rootY = Find(y);
			if (rootX != rootY) {
				if (rank[rootX] >= rank[rootY]) {//use union by size so tree doesn't become deep. Otherwise, use `root[rootY] = rootX;` OR `root[rootX] = rootY;` 
					root[rootY] = rootX;
					rank[rootX] += rank[rootY];
					return rank[rootX];
				} else if (rank[rootY] > rank[rootX]) {
					root[rootX] = rootY;
					rank[rootY] += rank[rootX];
					return rank[rootY];
				}
			}
			return rank[rootX];
		}
	}

	public static int getMaxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    if(i + 1 < m && grid[i + 1][j] == 1)
                        max = Math.max(max, uf.Union((i * n) + j, ((i + 1) * n) + j));
                    if(j + 1 < n && grid[i][j + 1] == 1)
                        max = Math.max(max, uf.Union((i * n) + j, (i * n) + j + 1));
                    else
                        max = Math.max(max, 1);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}