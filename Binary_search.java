
import java.util.Scanner;

public class Binary_search {

    static int binary_search(int[] a, int key) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid == key) {
                return 1;
            } else if (mid < key) {
                low = mid + 1;
            } else if (mid > key) {
                high = mid - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int a[] = new int[10];
        int key = 0;
        int n;
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the search key");
        key = sc.nextInt();
        long startTime = System.nanoTime();
        int result = binary_search(a, key);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken (nanoseconds): " + duration);

        if (result == 1) {
            System.out.println("Element present");
        } else {
            System.out.println("Element not present");
        }
    }
}
