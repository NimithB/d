
import java.util.Scanner;

public class selection_sort {

    static void Sort(int[] a) {
        int n = a.length;
        int min = 0;

        for (int i = 0; i < n-1; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[min] < a[j]) {
                    min = j;
                }
                if (min != i) {
                    int t = a[i];
                    a[i] = a[min];
                    a[min] = t;

                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Sort(arr);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}

