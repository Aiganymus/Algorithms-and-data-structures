package LAB3;

import java.util.Scanner;

class Professors {
	public static int n;
	public static int[][] arr;
	static boolean[] used;
	
	public static int min(int a, int b) {
		return (a > b) ? b : a;
	}
	
	public static void floyd() {
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++) 
					if(arr[i][k] != 0 && arr[k][j] != 0)
						if(arr[i][j] == 0 || arr[i][j] > arr[i][k] + arr[k][j])
							arr[i][j] = arr[i][k] + arr[k][j];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		arr = new int[n+1][n+1];
		used = new boolean[n+1];
		int s, e, l;
		for (int i = 0; i < m; i++) {
			s = in.nextInt();
			e = in.nextInt();
			l = in.nextInt();
			arr[s][e] = l;
			arr[e][s] = l;
		}
		in.close();
		floyd();
		int max = 0;
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= n; j++) 
				if(i != j && arr[i][j] > max) max = arr[i][j];
		System.out.println(max);
	}

}
