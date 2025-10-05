package cli;

import algorithms.InsertionSort;

public class MainCheck {
    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 5, 2, 4};
        InsertionSort.sort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
