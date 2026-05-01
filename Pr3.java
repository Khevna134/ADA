import java.util.Random;

public class pr3 {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr
