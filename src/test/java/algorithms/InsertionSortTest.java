package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    @DisplayName("handles empty array")
    void emptyArray() {
        int[] arr = new int[0];
        InsertionSort.sort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    @DisplayName("handles single element array")
    void singleElement() {
        int[] arr = {42};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    @DisplayName("already sorted array remains unchanged")
    void alreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("reversely sorted array becomes ascending")
    void reverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("array with duplicates is sorted and duplicates preserved")
    void withDuplicates() {
        int[] arr = {3, 1, 2, 3, 2, 1, 3};
        int[] expected = {1, 1, 2, 2, 3, 3, 3};
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("random array sorted same as Arrays.sort")
    void randomArrayMatchesJdkSort() {
        Random rnd = new Random(1234567L);
        for (int n = 0; n < 10; n++) {
            int size = 100;
            int[] arr = rnd.ints(size, -1000, 1000).toArray();
            int[] copy = Arrays.copyOf(arr, arr.length);

            InsertionSort.sort(arr);
            Arrays.sort(copy);

            assertArrayEquals(copy, arr);
        }
    }
}


