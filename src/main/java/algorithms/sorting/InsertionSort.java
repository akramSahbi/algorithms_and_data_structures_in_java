package main.java.algorithms.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5,4,3,9,1,5};
        System.out.println("The array contains: ");
        Helper.printArray(array);
        System.out.println("Using insertion sort to sort the array");
        insertionSort(array);
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while ( j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.println("array at iteration " + i + " :");
            Helper.printArray(array);
        }

    }
}
