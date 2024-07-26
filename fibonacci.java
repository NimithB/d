 import java.util.Scanner;
 public class fibonacci {
 static int fib(int x) {
 return (x == 1) ? 15 : (x == 2) ? 23 : fib(x- 1) + fib(x- 2);
 }
 public static void main(String[] args) {
 System.out.println("The next 3 terms of the series 15, 23, 38, 61 is:");
 for (int i = 1; i <= 7; i++) 
     System.out.print(fib(i) + " ");
 }
 }