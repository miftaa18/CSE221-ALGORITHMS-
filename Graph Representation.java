
//Adjacency Matrix Representation
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] mat = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            
            int src = Integer.parseInt(st2.nextToken());
            int dest = Integer.parseInt(st2.nextToken());
            int wgt = Integer.parseInt(st2.nextToken());

            mat[src - 1][dest - 1] = wgt;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(mat[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}


// Adjacency List Representation

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_Solution {
    static class Edge {
        int dest, wgt;
        Edge(int dt, int wt) {
            dest = dt;
            wgt = wt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int src[] = new int[m];
        int dest[] = new int[m];
        int wgt[] = new int[m];

        // Input
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            src[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dest[i] = Integer.parseInt(st3.nextToken());
        }
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            wgt[i] = Integer.parseInt(st4.nextToken());
        }

        // Graph
        ArrayList<Edge> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            graph[src[i]].add(new Edge(dest[i], wgt[i]));
        }

        // Output
        for (int i = 1; i <= n; i++)  {
            pw.print(i + ": ");
            for (Edge edge: graph[i]) {
                pw.print("(" + edge.dest + "," + edge.wgt + ") ");
            }
            pw.println();
        }
        pw.flush(); 
    }
}




//Graph Metamorphosis

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int mat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            
            int k = Integer.parseInt(st1.nextToken());
            for (int j = 0; j < k; j++) {
                int dest = Integer.parseInt(st1.nextToken());
                mat[i][dest] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(mat[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}



//The Seven Bridges of Königsberg
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int degree[] = new int[n + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            degree[Integer.parseInt(st2.nextToken())]++;
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            degree[Integer.parseInt(st3.nextToken())]++;
        }

        int oddDegree = 0;
        for (int i = 1; i <= n; i++) {
            if ((degree[i] & 1) == 1) oddDegree++;
        }

        if (oddDegree == 0 || oddDegree == 2) {
            pw.print("YES");
        }
        else {
            pw.print("NO");
        }
        pw.flush();
    }
}



//Edge Queries
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken()); 

        int diff[] = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)     {
            int a = Integer.parseInt(st2.nextToken()); 
            diff[a - 1]--;
        }
 
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st3.nextToken()); 
            diff[a - 1]++;
        }

        for (int i = 0 ; i < n; i++) {
            pw.print(diff[i] + " ");
        }
        pw.flush(); 
    }
}




//The King of Königsberg
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());

        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1,  0, 1};
        ArrayList<int[]> moves = new ArrayList<>();
        int count = 0; 

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx > 0 && nx <= n) && (ny > 0 && ny <= n)) {
                count++;
                moves.add(new int[]{nx, ny}); 
            }
        }

        pw.println(count);
        for (int[] p: moves) {
            pw.println(p[0] + " " + p[1]);
        }
        pw.flush(); 
    }
}




//The Knights of Königsberg

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        int knights[][] = new int[k][2];
        boolean board[][] = new boolean[n + 1][m + 1]; 

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            board[x][y] = true;
            knights[i][0] = x;
            knights[i][1] = y;
        }

        int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < k; i++) {
            int x = knights[i][0];
            int y = knights[i][1];
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if ((nx > 0 && nx <= n) && (ny > 0 && ny <= m)) {
                    if (board[nx][ny]) {
                        pw.println("YES");
                        pw.flush();
                        return;
                    }
                }
            }
        }
        pw.println("NO");
        pw.flush();
    }
}



//Coprime Graph
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class H_Solution {
    public static int gcd (int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> adj[]= new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && (gcd(i, j) == 1)) {
                    adj[i].add(j);
                }
            }
        }

        while (q-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            if (k > adj[x].size()) {
                pw.println(-1);
            }
            else {
                pw.println(adj[x].get(k - 1));
            }
        }
        pw.flush();
    }
}

