package graphs.three;

import java.util.Scanner;

class Problem3 {
	static int[][] arr = new int[101][101];
	static int u, n;
	static boolean[] used = new boolean[100];
	static int[] p;
	
	public static void dfs(int v) {
		used[v] = true;
		for (int i = 1; i <= n; i++) { 
			if(arr[v][i] == 1 && !used[i]) {
				p[i] = v;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		p = new int[n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				arr[i][j] = in.nextInt();
		}
		int v;
		v = in.nextInt();
		u = in.nextInt();
		in.close();
		dfs(v);
		System.out.println(used[u] ? "POLTOS" : "DAUREN");	
//		System.out.println(Arrays.toString(p));
		
		if(used[u]) {
			while(v != u) {
				v++;
				System.out.println(p[v] + " " + v );
			}	
		}
	}

}

//5          
//0 1 1 0 0
//1 0 0 0 1
//1 0 0 1 0
//0 0 1 0 0
//0 1 0 0 0
//1 4

//5          
//0 0 1 0 0
//0 0 0 0 1
//1 0 0 1 0
//0 0 1 0 0
//0 1 0 0 0 
//2 3   












