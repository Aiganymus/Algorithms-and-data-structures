package graphs;

import java.util.Scanner;

class Griyadki {
	public static int n, m, x1, y1, x2, y2;
	public static int[][] arr;
	static boolean[][] used;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int sz = 8;
	
	static boolean ok(int x, int y) {
		return (x >= 1 && x <= n && y >= 1 && y <= m && arr[x][y] == 1);
	}
	
	static void dfs(int x, int y) {
		used[x][y] = true;
		for (int i = 0; i < sz; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (ok(nextX, nextY) && used[nextX][nextY] == false) {
				dfs(nextX, nextY);
			}
		}
	}
	
	public static int find() {
    	int count = 0;
    	for(int i = 1; i <= n; i++) {
     		for(int j = 1; j <= m; j++) {
     			if(arr[i][j] == 1 && used[i][j] == false) {
     				dfs(i, j);
     				count++;
     			}
     		}
     	}
    	return count;     
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n+1][m+1];
		used = new boolean[n+1][m+1];
		String s;
		for (int i = 1; i <= n; i++) {
			s = in.nextLine();
			for(int k = 0; k < s.length(); k++) {
				if(s.charAt(k) =='.') arr[i][k+1] = 0;
				else arr[i][k+1] = 1;
			}
		}
		System.out.println(find());
		in.close();
	}

}
