package main.java.algorithms.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,9,7,1,10};
        System.out.println("The array contains: ");
        Helper.printArray(array);
        System.out.println("Using selection sort to sort the array");
        selectionSort(array);
    }


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = Helper.indexOfMin(array, i);
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

            System.out.println("array at iteration " + i + " :");
            Helper.printArray(array);
        }


    }
}
