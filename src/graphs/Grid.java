package graphs;

import java.util.Scanner;

public class Grid {
	public static int n, m, x1, y1, x2, y2;
	public static int[][] arr;
	static boolean[][] used;
	
	static void dfs(int x, int y) {
		if(x >= 1 && y >= 1 && x <= n && y <= m) {
			used[x][y] = true;
			if(x-1 > 0 && arr[x-1][y] == 0 && !used[x-1][y]) dfs(x-1, y);
			if(x+1 <= n && arr[x+1][y] == 0 && !used[x+1][y]) dfs(x+1, y);
			if(y-1 > 0 && arr[x][y-1] == 0 && !used[x][y-1]) dfs(x, y-1);
			if(y+1 <= m && arr[x][y+1] == 0 && !used[x][y+1]) dfs(x, y+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n+1][m+1];
		used = new boolean[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) 
				arr[i][j] = in.nextInt();
				
		}
		
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		
		in.close();
		
		dfs(x1, y1);
		
		System.out.println((used[x2][y2]) ? "YES" : "NO");
	}
}


//4 5
//0 1 1 0 0
//0 1 0 0 1
//0 1 0 1 0
//0 0 0 1 1
//3 1
//2 4

//4 5
//0 1 1 0 0
//0 1 0 0 1
//0 1 0 1 0
//0 0 0 1 1
//3 1
//3 5







