class Graph {
    int[][] matrix;
    int vertices;

    public Graph(int v) {
        vertices = v;
        matrix = new int[v][v];
    }

    void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;        // Remove this line for directed graph
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        g.printGraph();
    }
}



// TC -> O(1)
// SC -> o(V^2)