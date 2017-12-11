package LAB3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
 
class DijkstraPath {
    public static int n;
    public static int[][] arr;
    static int[] d;
    static int[] p;
    static boolean[] used;
 
    public static int minDistance() {
        int min = Integer.MAX_VALUE, index = 0;
         
        for (int v = 1; v <= n; v++)
            if (!used[v] && d[v] <= min) {
                min = d[v];
                index = v;
            }
 
        return index;
    }
   
    public static void dijkstra(int s) {
        d[s] = 0;
        for (int i = 1; i <= n; i++) {         
            int u = minDistance();
            used[u] = true;
           
            for (int j = 1; j <= n; j++) {
                if(arr[u][j] != -1 && !used[j] && d[u] != Integer.MAX_VALUE && d[u] + arr[u][j] < d[j]) {
                    d[j] = d[u] + arr[u][j];
                    p[j] = u;
                }
            }
        }
       
    }
   
    public static void main(String[] args) {
        int s, f;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        s = in.nextInt();
        f = in.nextInt();
        arr = new int[n+1][n+1];
        d = new int[n+1];
        p = new int[n+1];
        used = new boolean[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                arr[i][j] = in.nextInt();
        }
        in.close();
       
        dijkstra(s);
       
        if(d[f] == Integer.MAX_VALUE) System.out.println(-1);
        else {     
            Vector<Integer> path = new Vector<>();
            for (int v = f; v != s; v = p[v])
                path.add(v);
            path.add(s);
            Collections.reverse(path);
            for(int i = 0; i < path.size(); i++)
                System.out.println(path.elementAt(i));
        }
    }
 
}