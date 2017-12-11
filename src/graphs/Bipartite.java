package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Bipartite {
	public static int n;
	public static int[][] arr;
	static int color[];
	
	static boolean isBipartite(int v) {
        color[v] = 1;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(v);

        while (q.size() != 0) {
            int u = q.poll();
 
            if (arr[u][u] == 1) return false;  
 
            for (int i = 1; i <= n; i++) {
                if (arr[u][i] == 1 && color[i] == -1) {
                	color[i] = 1 - color[u];
                    q.add(i);
                }
 
                else if (arr[u][i] == 1 && color[i] == color[u])
                    return false;
            }
        }
        return true;		
	}
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n+1][n+1];
		color = new int[n+1];
		Arrays.fill(color, -1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				arr[i][j] = in.nextInt();
		}
		in.close();
		System.out.println((isBipartite(1)) ? "BIPARTITE" : "NOPARTITE");
	}

}



//5
//0 1 0 1 0
//1 0 1 0 0
//0 1 0 1 0
//1 0 1 0 1
//0 0 0 1 0

//5
//0 1 1 1 0
//1 0 1 0 0
//1 1 0 1 0
//1 0 1 0 1
//0 0 0 1 0



