import java.util.*;
public class BellmanFord {
    //? find the shortest distance of all vertices
    //? from source vertex S.
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> adjLs, int s){
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        for(int i = 0; i < V - 1; i++){
            for(ArrayList<Integer> it : adjLs){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);

                if(dist[u] != Integer.MAX_VALUE 
                && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        for(ArrayList<Integer> it : adjLs){
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);

            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                // this means after N - 1 iterations, further relaxation is possible
                // so return -1
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;

    }

}
