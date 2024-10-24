import java.util.Arrays;

public class SortingComparison {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

      
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

    
        while (i < left.length) {
            array[k++] = left[i++];
        }

  
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 10000; 
        int[] array1 = generateRandomArray(size);
        int[] array2 = Arrays.copyOf(array1, array1.length);

      
        long startTime = System.currentTimeMillis();
        mergeSort(array1);
        long endTime = System.currentTimeMillis();
        System.out.println("MergeSort Time: " + (endTime - startTime) + " ms");

       
        startTime = System.currentTimeMillis();
        bubbleSort(array2);
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort Time: " + (endTime - startTime) + " ms");
    }
}
