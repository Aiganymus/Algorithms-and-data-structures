package LAB3;

import java.util.Arrays;
import java.util.Scanner;

class Cycle {
	public static int n;
	public static int[][] arr;
	public static int[] p;
	static boolean[] rec;
	static boolean[] used;
	
	public static void dfs(int v) {
		used[v] = true;
		rec[v] = true;
		for (int i = n; i > 0; i--) { 
			if(arr[v][i] == 1) {
				if(!used[i]) {
					p[i] = v;
					dfs(i);
				}
				if(rec[i]) {
					System.out.println(Arrays.toString(p));
					System.out.println("CYCLE");
					System.exit(0);
				}
			}				
		}
		rec[v] = false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		p = new int[n+1];
		rec = new boolean[n+1];
		used = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				arr[i][j] = in.nextInt();
		}
		in.close();
		dfs(1);
		System.out.println("NO CYCLE");
	}

}

//4
//0 1 1 0
//0 0 1 0
//1 0 1 0
//0 0 0 1












