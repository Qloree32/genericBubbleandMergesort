import java.util.Arrays;

public class GenericSort {

    // Bubble Sort with Generics
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort with Generics
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            T[] left = Arrays.copyOfRange(array, 0, mid);
            T[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
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

    // Test both sorting algorithms
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 1, 2, 7};

        System.out.println("Original Array: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("Bubble Sorted: " + Arrays.toString(numbers));

        Integer[] moreNumbers = {5, 3, 8, 1, 2, 7};

        System.out.println("Original Array: " + Arrays.toString(moreNumbers));
        mergeSort(moreNumbers);
        System.out.println("Merge Sorted: " + Arrays.toString(moreNumbers));
    }
}
