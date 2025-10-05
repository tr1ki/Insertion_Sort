package algorithms;

/**
 * Basic in-place insertion sort implementation for integer arrays.
 * <p>
 * The algorithm builds the sorted portion of the array one element at a time
 * by inserting each element into its correct position relative to the already
 * sorted prefix.
 * </p>
 *
 * <p>
 * Complexity:
 * <ul>
 *   <li>Time (worst/average): O(n^2)</li>
 *   <li>Time (best, already sorted): O(n)</li>
 *   <li>Space: O(1) extra space (in-place)</li>
 * </ul>
 * </p>
 */
public class InsertionSort {

    /**
     * Sorts the given array in non-decreasing order using insertion sort.
     * <p>
     * If {@code arr} is {@code null} or has length 0, the method returns immediately.
     * </p>
     *
     * @param arr the array to sort; sorted in place if not {@code null}
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++) {
            int valueToInsert = arr[unsortedIndex];
            int sortedIndex = unsortedIndex - 1;

            // Shift larger elements of the sorted prefix to the right
            while (sortedIndex >= 0 && arr[sortedIndex] > valueToInsert) {
                arr[sortedIndex + 1] = arr[sortedIndex];
                sortedIndex--;
            }

            // Insert the value into its correct position
            arr[sortedIndex + 1] = valueToInsert;
        }
    }
}


