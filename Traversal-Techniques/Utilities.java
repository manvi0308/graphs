import java.util.ArrayList;

public class Utilities {
    static ArrayList<ArrayList<Integer>> listToMatrix(ArrayList<ArrayList<Integer>> adjMat, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < V; i++){
            adjLs.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adjMat.get(i).get(j) == 1 && i != j){

                    // adding an edge both from i to j and j to i
                    // since its a bi-directional graph.
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        return adjLs;
    }
}
