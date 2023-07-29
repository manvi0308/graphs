import java.util.*;

class Node implements Comparator<Node> {
    int v;
    int weight;

    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.weight < n2.weight)
            return -1;
        if (n1.weight > n2.weight)
            return 1;
        return 0;
    }
}

public class DijkstraAlgo {
    static void dijkstra(ArrayList<ArrayList<Node>> adjList, int source, int N) {
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while(pq.size() > 0){
            Node node = pq.poll();
            for(Node it : adjList.get(node.v)){
                if(dist[node.v] + it.weight < dist[node.v]){
                    dist[node.v] = dist[node.v] + it.weight;
                    pq.add(new Node(it.v, it.weight));
                } 
            }
        }
    }
}
