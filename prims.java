
import java.util.Scanner;

public class prims {

    final static int MAX = 20;
    static int n;
    static int[][] cost = new int[MAX][MAX];
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        readMatrix();
        primsAlgorithm();
    }

    static void readMatrix() {
        System.out.println("Enter the number of nodes:");
        n = scan.nextInt();
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {  // Changed to 0-based indexing
            for (int j = 0; j < n; j++) {  // Changed to 0-based indexing
                cost[i][j] = scan.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = 999;  // Using 999 to represent infinity
                }
            }
        }
    }

    static void primsAlgorithm() {
        int[] visited = new int[n];
        int ne = 1;
        int mincost = 0;
        visited[0] = 1;  // Starting with the first node

        while (ne < n) {
            int min = 999;
            int a = -1, b = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (cost[i][j] < min && visited[j] == 0) {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }
            if (a != -1 && b != -1) {
                System.out.println("Edge " + ne++ + ": (" + a + ", " + b + ") cost: " + min);
                mincost += min;
                visited[b] = 1;
                cost[a][b] = cost[b][a] = 999;  // Marking the edge as used
            }
        }
        System.out.println("Minimum cost: " + mincost);
    }
}
