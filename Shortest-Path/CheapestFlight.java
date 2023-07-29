import java.util.*;
class Pair{
    int stop;    
    int cost;

    Pair(int stop, int cost){
        this.stop = stop;
        this.cost = cost;
    }
}

class Tuple{
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
public class CheapestFlight {
    static int cheapestFlight(int[][] flights, int N, int source, int dest, int K){

        // Initial Configuration
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adjList.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0; i < m; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }


        Queue<Tuple> queue = new LinkedList<>();
        // travelling from source to source will be a 0 stop and 0 cost trip.
        queue.add(new Tuple(0, source, 0));

        int[] dist = new int[N];

        for(int i = 0; i < N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;
        // Initial configuration completed.

        while(!queue.isEmpty()){
            Tuple it = queue.peek();
            queue.remove();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            if(stops > K)
            continue;

            for(Pair iter : adjList.get(node)){
                int adjNode = iter.stop;
                int adjCost = iter.cost;

                if(cost + adjCost < dist[adjNode] &&stops <= K){
                    dist[adjNode] = cost + adjCost;
                    queue.add(new Tuple(stops + 1, adjNode, cost + adjCost));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE)
            return -1;
        return dist[dest];

    }
}
