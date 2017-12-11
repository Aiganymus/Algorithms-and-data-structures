package LAB3;

import java.util.Scanner;

class Floyd {
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
					arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		used = new boolean[n+1];
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= n; j++) 
				arr[i][j] = in.nextInt();
		in.close();
		floyd();
		int max = 0;
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= n; j++) 
				if(arr[i][j] > max) max = arr[i][j];
		System.out.println(max);
	}

}
