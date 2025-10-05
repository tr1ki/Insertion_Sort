package algorithms;

import metrics.PerformanceTracker;

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
        sort(arr, null);
    }

    /**
     * Sorts the given array in non-decreasing order using insertion sort and optionally tracks metrics.
     * <p>
     * If {@code arr} is {@code null} or has length 0, the method returns immediately.
     * </p>
     *
     * @param arr the array to sort; sorted in place if not {@code null}
     * @param tracker optional performance tracker; may be {@code null}
     */
    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            return;
        }

        boolean anyShift = false; // track if any element was moved (for early exit)
        for (int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++) {
            // read arr[unsortedIndex]
            if (tracker != null) tracker.incArrayAccesses();
            int valueToInsert = arr[unsortedIndex];
            int sortedIndex = unsortedIndex - 1;

            // Optimization: if the current element is already >= previous, it's already in place
            if (sortedIndex >= 0) {
                if (tracker != null) {
                    tracker.incArrayAccesses(); // read arr[sortedIndex]
                    tracker.incComparisons();
                }
                if (arr[sortedIndex] <= valueToInsert) {
                    // already in correct position; no shifts or write needed
                    continue;
                }
            }

            // Shift larger elements of the sorted prefix to the right
            while (sortedIndex >= 0) {
                // compare arr[sortedIndex] with valueToInsert
                if (tracker != null) {
                    tracker.incArrayAccesses(); // reading arr[sortedIndex]
                    tracker.incComparisons();
                }
                if (arr[sortedIndex] > valueToInsert) {
                    // arr[sortedIndex + 1] = arr[sortedIndex]; (one read, one write)
                    if (tracker != null) tracker.incArrayAccesses(2);
                    arr[sortedIndex + 1] = arr[sortedIndex];
                    anyShift = true;
                    sortedIndex--;
                } else {
                    break;
                }
            }

            // Insert the value into its correct position (one write)
            if (tracker != null) tracker.incArrayAccesses();
            if (sortedIndex + 1 != unsortedIndex) anyShift = true;
            arr[sortedIndex + 1] = valueToInsert;
        }

        // Early exit if no elements were moved during the pass (array already sorted)
        if (!anyShift) {
            return;
        }
    }
}


