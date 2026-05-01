import java.util.Random;

public class pr2 {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
