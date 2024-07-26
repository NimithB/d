import java.util.Scanner;
import java.util.Arrays;

public class TSP {

    private static final int INF = Integer.MAX_VALUE / 2; // Prevent overflow

    public static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][(1 << n)];

        // Initialize the DP table with infinite cost
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Base case: start at the first city
        dp[0][1] = 0;

        // Iterate through all possible sets of visited cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) { // If city u is in the set
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) { // If city v is not in the set
                            int newMask = mask | (1 << v);
                            dp[v][newMask] = Math.min(dp[v][newMask], dp[u][mask] + graph[u][v]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to complete the tour
        int minCost = INF;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[i][(1 << n) - 1] + graph[i][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();
        
        int[][] graph = new int[n][n];
        
        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        int result = tsp(graph);
        
        System.out.println("The minimum cost to visit all cities is: " + result);
    }
}
