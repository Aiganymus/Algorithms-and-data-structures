package LAB3;
 
import java.util.Arrays;
import java.util.Scanner;
 
class Dijkstra {
    public static int n;
    public static int[][] arr;
    static int[] d;
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
                if(arr[u][j] != -1 && !used[j] && d[u] != Integer.MAX_VALUE &&
                        d[u] + arr[u][j] < d[j])
                    d[j] = d[u] + arr[u][j];
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
        used = new boolean[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                arr[i][j] = in.nextInt();
        }
        in.close();
       
        dijkstra(s);
       
        System.out.println((d[f] == Integer.MAX_VALUE) ? -1 : d[f]);
    }
 
}