import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        
        int[] weights = new int[n + 1];
        int[] profits = new int[n + 1];
        
        System.out.println("Enter weight of each item: ");
        for (int i = 1; i <= n; i++) {
            weights[i] = sc.nextInt();
        }
        
        System.out.println("Enter profit of each item: ");
        for (int i = 1; i <= n; i++) {
            profits[i] = sc.nextInt();
        }
        
        System.out.print("Enter the capacity of Knapsack: ");
        int capacity = sc.nextInt();
        
        System.out.println("Entered Knapsack Details are: ");
        displayInfo(n, weights, profits, capacity);
        
        int[][] dpTable = new int[n + 1][capacity + 1];
        knapsackDP(capacity, n, weights, profits, dpTable);
        
        System.out.println("The contents of the knapsack table are: ");
        printKnapsackTable(dpTable, n, capacity);
        
        optimalSolution(capacity, n, weights, profits, dpTable);
    }

    static void displayInfo(int n, int[] weights, int[] profits, int capacity) {
        System.out.println("ITEM\tWEIGHT\tPROFIT");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t" + weights[i] + "\t" + profits[i]);
        }
        System.out.println("Capacity = " + capacity);
    }

    static void knapsackDP(int capacity, int n, int[] weights, int[] profits, int[][] dpTable) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dpTable[i][j] = 0;
                } else if (j < weights[i]) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i - 1][j - weights[i]] + profits[i]);
                }
            }
        }
    }

    static void printKnapsackTable(int[][] dpTable, int n, int capacity) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dpTable[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void optimalSolution(int capacity, int n, int[] weights, int[] profits, int[][] dpTable) {
        int[] selectedItems = new int[n + 1];
        int i = n, j = capacity;
        
        while (i != 0 && j != 0) {
            if (dpTable[i][j] != dpTable[i - 1][j]) {
                selectedItems[i] = 1;
                j -= weights[i];
            }
            i--;
        }
        
        System.out.println("Optimal solution is: " + dpTable[n][capacity]);
        System.out.print("Selected items are: ");
        boolean anyItem = false;
        for (i = 1; i <= n; i++) {
            if (selectedItems[i] == 1) {
                anyItem = true;
                System.out.print(i + " ");
            }
        }
        if (!anyItem) {
            System.out.println("\nSorry, no items can be placed in the knapsack!");
        }
    }
}
