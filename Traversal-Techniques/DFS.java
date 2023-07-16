import java.util.*;

public class DFS {
     // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
        // for a directed graph with an edge pointing from u
        // to v, adj.get(u).add(v);
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph, int V) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Initial configuration

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        visited[0] = true;
        dfsRecur(graph, visited, 0, ans);
        return ans;

    }

    static void dfsRecur(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, ArrayList<Integer> ans) {
        ans.add(v);
        visited[v] = true;
        for (int i = 0; i < graph.get(v).size(); i++) {
            int w = graph.get(v).get(i);
            if (!visited[w]) {
                dfsRecur(graph, visited, w, ans);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
 
        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        ArrayList<Integer> ans = dfs(adj, V);
        System.out.println(ans.toString());
    }
    
}
