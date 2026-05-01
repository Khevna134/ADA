import java.util.Random;

public class pr5 {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        quickSort(arr, 0, n - 1);

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int
