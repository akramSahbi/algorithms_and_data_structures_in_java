package main.java.algorithms.divideandconquer;

import main.java.algorithms.divideandconquer.Helper;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] array = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        System.out.println("The array of stock prices contains: ");
        int[] changes = Helper.printStockArray(array);
        System.out.println("\nUsing MaximumSubArray to find the biggest profit days (indexes of the array)");
        System.out.println("***********************************************  RESULT   *********************************");
        printMaximumSubArray(findMaximumSubArray(changes, 0, array.length-1));

    }

    public static Map<Tuplet, Integer> findMaxCrossingSubArray(int[] array, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = -1;


        for (int i = mid; i >= left; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = -1;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        Map<Tuplet, Integer> maxCrossingArray = new HashMap<>();
        maxCrossingArray.put(Tuplet.MAX_LEFT_INDEX, maxLeft);
        maxCrossingArray.put(Tuplet.MAX_RIGHT_INDEX, maxRight);
        maxCrossingArray.put(Tuplet.SUM, leftSum + rightSum);

        return maxCrossingArray;
    }

    public static Map<Tuplet, Integer> findMaximumSubArray(int[] array, int start, int end) {
        Map<Tuplet, Integer> maximumSubArray = new HashMap<>();
        if (start == end) {
            maximumSubArray.put(Tuplet.MAX_LEFT_INDEX, start);
            maximumSubArray.put(Tuplet.MAX_RIGHT_INDEX, end);
            maximumSubArray.put(Tuplet.SUM, array[start]);
            return maximumSubArray;
        } else {
            int mid = (start + end) / 2;
            Map<Tuplet, Integer> leftMaximumSubArray = findMaximumSubArray(array, start, mid);
            Map<Tuplet, Integer> rightMaximumSubArray = findMaximumSubArray(array, mid+1, end);
            Map<Tuplet, Integer> crossMaximumSubArray = findMaxCrossingSubArray(array, start,mid, end);
            if (leftMaximumSubArray.get(Tuplet.SUM) > rightMaximumSubArray.get(Tuplet.SUM) &&
                leftMaximumSubArray.get(Tuplet.SUM) > crossMaximumSubArray.get(Tuplet.SUM)) {
                return leftMaximumSubArray;
            } else if (rightMaximumSubArray.get(Tuplet.SUM) > leftMaximumSubArray.get(Tuplet.SUM) &&
                    rightMaximumSubArray.get(Tuplet.SUM) > crossMaximumSubArray.get(Tuplet.SUM)) {
                return rightMaximumSubArray;
            } else {
                return crossMaximumSubArray;
            }
        }
    }
    private static void printMaximumSubArray(Map<Tuplet, Integer> maximumSubArray) {

        System.out.println("Left index: " + maximumSubArray.get(Tuplet.MAX_LEFT_INDEX));
        System.out.println("Right index: " + maximumSubArray.get(Tuplet.MAX_RIGHT_INDEX));
        System.out.println("SUM: " + maximumSubArray.get(Tuplet.SUM));
    }












    enum Tuplet {
        MAX_LEFT_INDEX,
        MAX_RIGHT_INDEX,
        SUM
    }
}
