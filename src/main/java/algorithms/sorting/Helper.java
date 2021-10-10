package main.java.algorithms.sorting;

public class Helper {
    public static void printArray(int[] array) {
        System.out.println("*******************************************************************************************");
        for(int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("\n*******************************************************************************************");
    }

    public static int indexOfMin(int[] array, int start) {
        int min = array[start];
        int minIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
