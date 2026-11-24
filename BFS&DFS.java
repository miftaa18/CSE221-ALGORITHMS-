import java.io.*;
import java.util.*;
public class taskF{
    static ArrayList<Integer>[]adj;
    static boolean visited[];
    static int comp[];
    public static void dfs(int node,int id){
        visited[node]= true;
        comp[node] = id;
        for (int i=0;i<adj[node].size();i++){
            int next = adj[node].get(i);
        
            if (!visited[next]){
                dfs(next,id );
                    
                }
            }
        
    }
    public static void main (String[]args)throws Exception{
        BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter (System.out);
        StringTokenizer st= new StringTokenizer (br.readLine());
        int n= Integer.parseInt (st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int p= Integer.parseInt(st.nextToken());
      adj = new ArrayList[n+1];
      visited= new boolean[n+1];
      comp= new int[n+1];

        for (int i=1;i<=n;i++){
            adj[i]= new ArrayList<>();
        }
        for (int i=0;i<m;i++){
            st= new StringTokenizer (br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            adj[u] .add(v);
            adj[v].add(u);
          
        }
      int id=0;

       for (int i=1; i<=n;i++){
        if (!visited[i]){
          id++;
          dfs(i,id);
                
            }
       
        }
        for (int i=0;i<p;i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            if(comp[x]==comp[y]){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }
      
        pw.flush();
    }
    }

