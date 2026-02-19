import java.util.ArrayList;

class Pair {
    int node;
    int weight;

    Pair (int n, int w) {
        node = n;
        weight = w;
    }
}

class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        vertices = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);       // Remove for directed graph
    }

    // void addEdge(int u, int v, int weight) {
    //     adj.get(u).add(new Pair(v, weight));
    //     adj.get(v).add(new Pair(u, weight));       // Remove for directed graph
    // }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyList {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.printGraph();
    }
}



// TC -> O(1)
// SC -> O(V+E)