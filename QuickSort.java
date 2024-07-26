
import java.util.Scanner;

public class QuickSort {

     static void Quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = part(arr, low, high);
            Quicksort(arr, low, pi - 1);
            Quicksort(arr, pi + 1, high);
        }
    }

    static int part(int arr[], int l, int h) {
        int p = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] < p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long s = System.nanoTime();
        Quicksort(a, 0, a.length - 1);
        long e = System.nanoTime();
        long d = e - s;
        System.out.println("Time:" + d);
        System.out.println("The sorted array is");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i]);
        }
    sc.close();}
}
