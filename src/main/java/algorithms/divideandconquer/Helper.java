package main.java.algorithms.divideandconquer;

public class Helper {

    public static int[] printStockArray(int[] array) {
        main.java.algorithms.sorting.Helper.printArray(array);
        int[] change = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            change[i] = i == 0 ? 0 : array[i] - array[i-1];
            System.out.print(  change[i]+ "\t");
        }
        return change;
    }
}
