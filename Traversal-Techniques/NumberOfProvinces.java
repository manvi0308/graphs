import java.util.*;

public class NumberOfProvinces {
    // Question is to count group of directly or indirectly
    // connected cities.

    static int numProvinces(ArrayList<ArrayList<Integer>> adjMat, int V) {
        // This is simple traversal problem, however here adjacency matrix will be
        // given, the key concept is to convert adj matrix to adj list.
        ArrayList<ArrayList<Integer>> adjLs = Utilities.listToMatrix(adjMat, V);

        // Initial configuration of DFS
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int count = 0;

        // this step can be avoided, however as we are using the already created method
        // which has this parameter, otherwise we are just concerned with count of provinces
        // and not the order in which cities are connected. 
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                count++;
                DFS.dfsRecur(adjLs, visited, i, res);
            }
        }
        return count;
    }
}
