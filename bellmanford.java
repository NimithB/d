import java.util.*;

class Graph {
    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    int numVertices, numEdges;
    Edge[] edges;

    Graph(int v, int e) {
        numVertices = v;
        numEdges = e;
        edges = new Edge[e];
    }

    void bellmanFord(int src) {
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < numVertices; ++i) {
            for (int j = 0; j < numEdges; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < numEdges; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printDistances(dist);
    }

    void printDistances(int[] dist) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < numVertices; ++i) {
            System.out.println(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "Infinity" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();

        Graph graph = new Graph(V, E);

        for (int i = 0; i < E; i++) {
            System.out.print("Enter source, destination, and weight for edge " + (i + 1) + ": ");
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.edges[i] = new Edge(src, dest, weight);
        }

        System.out.print("Enter the source vertex for Bellman-Ford algorithm: ");
        int source = scanner.nextInt();
        graph.bellmanFord(source);

        scanner.close();
    }
}
