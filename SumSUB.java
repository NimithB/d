 import java.util.Scanner;
 public class SumSUB {
 static int count = 0;
 static void subset(int cs, int k, int r, int[] x, int[] w, int d) {
 x[k] = 1;
 int n = w.length;
 if (cs + w[k] == d) {
 count++;
 System.out.print("Solution " + count + ": {");
 for (int i = 0; i < n; i++) {
 if (x[i] == 1) System.out.print(w[i] + " ");
 }
 System.out.println("}");
 } else if (cs + w[k] + w[k + 1] <= d) {
 subset(cs + w[k], k + 1, r- w[k], x, w, d);
 }
 if (cs + r- w[k] >= d && cs + w[k + 1] <= d) {
 x[k] = 0;
 subset(cs, k + 1, r- w[k], x, w, d);
 }
 }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("No of elements in the set: ");
 int n = sc.nextInt();
 int[] w = new int[n];
int[] x = new int[n];
 int sum = 0;
 System.out.print("Enter the elements: ");
 for (int i = 0; i < n; i++) {
 w[i] = sc.nextInt();
 sum += w[i];
 }
 System.out.print("Enter the desired sum: ");
 int d = sc.nextInt();
 System.out.println("Sum is: " + sum);
 subset(0, 0, sum, x, w, d);
 }
 }