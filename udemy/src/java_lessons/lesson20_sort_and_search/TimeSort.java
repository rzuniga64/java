package java_lessons.lesson20_sort_and_search;


public class TimeSort {
    public static void insertionSort(int [] data) {
        int size = data.length;

        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; --j) {
                if (data[j-1] > data[j]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <  size - i; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp;
        int pivot = arr[(left + right)/2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int size = arr.length;
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        int size = arr.length;
        int[] temp = new int[size];
        for (int i = low; i <= high; ++i) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                ++i;
            } else {
                arr[k] = temp[j];
                ++j;
            }
            ++k;
        }

        while ( i <= middle) {
            arr[k] = temp[i];
            ++k;
            ++i;
        }
    }

    public static void main(String[] args) {
        final int size = 100;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++)
            numbers[i] = (int) (Math.random() * 1000);
        long startTime = System.nanoTime();
        bubbleSort(numbers);
        long stoptime = System.nanoTime();
        long duration = stoptime - startTime;
        System.out.println("Bubble sort took \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        insertionSort(numbers);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Insertion sort  \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        quickSort(numbers, 0, size - 1);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Quick sort took \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        mergeSort(numbers, 0, size - 1);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Merge sort took \t" +  duration + " nanoseconds");
    }
}
