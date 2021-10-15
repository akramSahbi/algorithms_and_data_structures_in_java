package main.java.algorithms.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {20,14,7,6,5,9,4,1,10, 2};
        System.out.println("The array contains: ");
        Helper.printArray(array);
        System.out.println("Using merge sort to sort the array");
        mergeSort(array, 0, array.length-1);
        System.out.println("***********************************************  RESULT   *********************************");
        Helper.printArray(array);
    }


    public static void mergeSort(int[] array, int start, int end) {
        if (start >= 0 && end < array.length) {
            if ( start >= end ) {
                // do nothing
            } else {
                int lEnd = (end + start) / 2;
                int rStart = lEnd + 1;
                mergeSort(array, start, lEnd);
                mergeSort(array, rStart, end);
                merge(array, start, rStart, end);
            }
        }
    }

    private static void merge(int[] array, int start, int rStart, int end) {
        int[] l = new int[rStart - start];
        int[] r = new int[end - rStart + 1];
        for (int i = 0; i < l.length; i++) {
            l[i] = array[start + i];
        }


        for (int i = 0; i < r.length; i++) {
            r[i] = array[rStart + i];
        }


        System.out.println("Merging tables:");
        System.out.println("left:");
        Helper.printArray(l);
        System.out.println("right:");
        Helper.printArray(r);

        for (int i = 0, j = 0, k = start; k <= end && k < array.length && i < array.length && j < array.length; k++) {
            if (j >= r.length) {
                array[k] = l[i++];
                continue;
            }
            if (i >= l.length) {
                array[k] = r[j++];
                continue;
            }
            if (l[i] < r[j]) {
                array[k] = l[i++];
            } else {
                array[k] = r[j++];
            }
        }
    }

}
