import java.util.Random;

public class pr1 {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
