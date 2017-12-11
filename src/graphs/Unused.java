package graphs;

import java.util.Scanner;

class Unused {
	static int[][] arr;
	static int n;
	static boolean[] used;
	static int edges = 0;
	
	public static void dfs(int v) {
		used[v] = true;
		for (int i = n; i > 0; i--) { 
			if(arr[v][i] == 1 && !used[i]) {
				edges++;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		used = new boolean[n+1];
		int all = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = in.nextInt();
				if(arr[i][j] == 1) all++;
			}
		}
		in.close();
		dfs(1);
		System.out.println(all/2 - edges);
	}

}
