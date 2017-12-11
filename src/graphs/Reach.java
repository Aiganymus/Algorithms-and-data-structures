package graphs;

import java.util.Scanner;

class Reach {
	static int[][] arr;
	static int n;
	static boolean[] used;
	
	public static void dfs(int v) {
		used[v] = true;
		for (int i = n; i > 0; i--) { 
			if(arr[v][i] == 1 && !used[i]) {
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
			m--;
		}
		in.close();
		dfs(1);
		for (int i = n; i > 0; i--) {
			if(!used[i]) {
				System.out.println("NO");
				System.exit(1);
			}
		}
		System.out.println("YES");		
	}

}


//6 7 
//1 2
//2 4
//4 6
//6 5
//5 3
//3 6
//3 2
