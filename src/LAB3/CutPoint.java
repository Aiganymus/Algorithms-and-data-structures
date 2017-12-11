package LAB3;

import java.util.Scanner;

class CutPoint {
	static int[][] arr;
	static int[] tin, fup;
	static int n, timer = 0;
	static boolean[] used;
	
	public static int min(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static void dfs(int v, int p) {
		used[v] = true;
		tin[v] = fup[v] = timer++;
		int children = 0;
		for (int i = 1; i <= n; i++) {
			if (i == p) continue;
			if(arr[v][i] == 1) {
				if (used[i]) fup[v] = min(fup[v], tin[i]);
				else {
					dfs (i, v);
					fup[v] = min(fup[v], fup[i]);
					if (fup[i] >= tin[v] && p != -1)
						System.out.println(v);
					++children;
				}
			}
		}
		if (p == -1 && children > 1) System.out.println(v);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		tin = new int[n+1];
		fup = new int[n+1];
		used = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				arr[i][j] = in.nextInt();
		}
		in.close();
		dfs(2, -1);
	}
}


//0 1 0 0
//1 0 1 0
//0 1 0 1
//0 0 1 0

//0 1 1 1 0
//1 0 1 0 0
//1 1 0 0 0 
//1 0 0 0 1
//0 0 0 1 0













