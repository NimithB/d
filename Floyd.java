 import java.util.*;
 class Flyod {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter the number of vertices: ");
 int n = sc.nextInt();
 System.out.println("Enter the adj matrix:(enter 999 for infinity) ");
 int adj[][] = new int[10][10];
 for (int i = 1; i <= n; i++) {
 for (int j = 1; j <= n; j++) {
 adj[i][j] = sc.nextInt();
 }
 }
 flyod(adj, n);
 System.out.println("the all pair shortest path is: ");
 for (int i = 1; i <= n; i++) {
 for (int j = 1; j <= n; j++) {
 System.out.print(adj[i][j] + " ");
 }
 System.out.println();
 }
 }
 static void flyod(int arr[][], int n) {
 for (int k = 1; k <= n; k++) {
 for (int i = 1; i <= n; i++) {
 for (int j = 1; j <= n; j++) {
 arr[i][j] = min(arr[i][j], (arr[i][k] + arr[k][j]));
 }
 }
 }
 }
 static int min(int a, int b) {
 if (a < b) {
 return a;
 }
 return b;
 }
 }