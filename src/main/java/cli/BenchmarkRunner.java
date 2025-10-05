package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.util.Random;

/**
 * Simple CLI to benchmark InsertionSort and print metrics as CSV.
 */
public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = new int[]{100, 1000, 10000, 100000};
        Random random = new Random(12345L);

        PerformanceTracker tracker = new PerformanceTracker();

        // CSV header
        System.out.println("size,comparisons,swaps,arrayAccesses,elapsedTimeNs");

        for (int size : sizes) {
            int[] arr = random.ints(size, -1_000_000, 1_000_000).toArray();

            tracker.reset();
            tracker.setInputSize(size);
            tracker.start();
            InsertionSort.sort(arr, tracker);
            tracker.stop();

            System.out.println(size + "," +
                    tracker.getComparisons() + "," +
                    tracker.getSwaps() + "," +
                    tracker.getArrayAccesses() + "," +
                    tracker.getElapsedTimeNs());

            // also persist to CSV file
            tracker.exportToCSV("benchmark_results.csv");
        }
    }
}


