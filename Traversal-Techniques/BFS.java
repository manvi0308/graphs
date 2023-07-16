import java.util.*;

public class BFS{
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
    // TC : O (V + 2E)
    static ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        // Initial configuration

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // if its a 0 based indexing graph
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(visited[it] == false){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args){
        // Creating a graph with 5 vertices
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

        ArrayList<Integer> res = bfsTraversal(adj, V);
        System.out.println(res.toString());
    }
}