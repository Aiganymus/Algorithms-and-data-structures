package LAB3;

import java.util.Scanner;

class Edges {	
	static int[][] arr;
	static int n;
	static boolean[] used;
	static boolean[][] checked;
	static int bridges = 0;
	
	public static void dfs(int v) {
		used[v] = true;
		for (int i = 1; i <= n; i++) 
			if(arr[v][i] == 1 && !used[i]) 
				dfs(i);
	}
	
	public static void isBridge(int i, int j) {
		arr[i][j] = arr[j][i] = 0;
		dfs(j);
		for (int k = 1; k <= n; k++) {
			if(!used[k] && !checked[i][j] && !checked[j][i]) {
				checked[i][j] = checked[j][i] = true;
				bridges++;
			}
			else used[k] = false;
		}
		arr[i][j] = arr[j][i] = 1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		used = new boolean[n+1];
		checked = new boolean[n+1][n+1];
		int e = in.nextInt();
		int m = e;
		int v, u;
		while(e > 0) {
			v = in.nextInt();
			u = in.nextInt();
			arr[v][u] = 1;	
			arr[u][v] = 1;
			e--;
		}
		in.close();
		
		for (int i = 1; i <= n; i++) 
			for (int j = i + 1; j <= n; j++) 
				if(arr[i][j] == 1) 
					isBridge(i, j);

		System.out.println(m - bridges);
	}
}

//5 5       
//1 2    
//3 1    
//3 2    
//4 3    
//5 2   

//8 10 
//1 2  
//3 2  
//1 3  
//1 4  
//4 5  
//5 6  
//7 4  
//7 6  
//6 4  
//8 7

//5 4
//1 2
//1 3
//4 3
//5 3 





