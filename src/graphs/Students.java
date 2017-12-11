package graphs;

import java.util.Scanner;
import java.util.Vector;

class Students {
	static int[][] arr;
	static int n;
	static boolean[] used;
	static Vector<Integer> first = new Vector<>();
	static Vector<Integer> second = new Vector<>();
	static boolean team;
	
	static void dfs(int v) {
		for (int i = n; i > 0; i--) { 
			if(arr[v][i] == 1 && !used[i]) {
				used[i] = true;
				if(!team) {
					first.add(i);
					team = true;
				} else {
					second.add(i);
					team = false;
				}
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		used = new boolean[n+1];
		int m = in.nextInt();
		int a, b;
		while(m != 0) {
			a = in.nextInt();
			b = in.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
			m--;
		}
		in.close();
		
		for (int i = 1; i <= n; i++) {
			if(!used[i]) {
				used[i] = true;
				if(!team) {
					first.add(i);
					team = true;
				} else {
					second.add(i);
					team = false;
				}
				dfs(i);
			}
		}	
		System.out.println(first);
		System.out.println(second);
	}
}
