package LAB3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class Connected {
	public static int n;
	public static int[][] arr;
	public static int[] p;
	static Vector<Integer> vector = new Vector<>();
	static boolean[] used;
	
	public static void dfs(int v) {
		used[v] = true;
		for (int i = 1; i <= n; i++) 
			if(arr[v][i] == 1 && !used[i]) 
				dfs(i);
		vector.add(v);
	}

	public static void reverse() {
		boolean[][] changed = new boolean[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				if(arr[i][j] == 1 && !changed[j][i]) {
					changed[i][j] = changed[j][i] = true;
					arr[j][i] = 1;
					arr[i][j] = 0;
				}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		p = new int[n+1];
		used = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				arr[i][j] = in.nextInt();
		}
		in.close();
		dfs(1);
		reverse();
		
		Arrays.fill(used, false);
		System.out.println(vector);
		for(int i = vector.size() - 1; i >= 0; i--)
            if (!used[vector.elementAt(i)]) {
                print_dfs(vector.elementAt(i));
                System.out.println();
            }
	}

	private static void print_dfs(int v) {
		used[v] = true;
		System.out.print(v + " ");
		for (int i = n; i > 0; i--) 
			if(arr[v][i] == 1 && !used[i]) print_dfs(i);
	}

}


//5
//0 0 1 1 0
//1 0 0 0 0
//0 1 0 0 0
//0 0 0 0 1
//0 0 0 0 0








