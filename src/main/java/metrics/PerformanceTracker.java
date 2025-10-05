package metrics;

import java.io.PrintStream;

/**
 * Tracks basic performance metrics for sorting algorithms.
 * <p>
 * Metrics:
 * <ul>
 *   <li>comparisons: number of value-to-value comparisons</li>
 *   <li>swaps: number of element swaps performed</li>
 *   <li>arrayAccesses: number of array read/write operations</li>
 *   <li>elapsedTime: total elapsed time in nanoseconds</li>
 * </ul>
 * </p>
 */
public class PerformanceTracker {

    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long startTimeNs;
    private long elapsedTimeNs;

    /** Starts the timer (in nanoseconds). */
    public void start() {
        startTimeNs = System.nanoTime();
    }

    /** Stops the timer and records the elapsed time in nanoseconds. */
    public void stop() {
        elapsedTimeNs = System.nanoTime() - startTimeNs;
    }

    /** Resets all metrics to zero. */
    public void reset() {
        comparisons = 0L;
        swaps = 0L;
        arrayAccesses = 0L;
        startTimeNs = 0L;
        elapsedTimeNs = 0L;
    }

    /** Increments the comparison counter by one. */
    public void incComparisons() { incComparisons(1L); }

    /** Increments the comparison counter by the specified delta. */
    public void incComparisons(long delta) { comparisons += delta; }

    /** Increments the swap counter by one. */
    public void incSwaps() { incSwaps(1L); }

    /** Increments the swap counter by the specified delta. */
    public void incSwaps(long delta) { swaps += delta; }

    /** Increments the array access counter by one. */
    public void incArrayAccesses() { incArrayAccesses(1L); }

    /** Increments the array access counter by the specified delta. */
    public void incArrayAccesses(long delta) { arrayAccesses += delta; }

    /** @return the number of comparisons performed */
    public long getComparisons() { return comparisons; }

    /** @return the number of swaps performed */
    public long getSwaps() { return swaps; }

    /** @return the number of array read/write operations */
    public long getArrayAccesses() { return arrayAccesses; }

    /** @return the elapsed time in nanoseconds */
    public long getElapsedTimeNs() { return elapsedTimeNs; }

    /** Prints a human-readable summary to {@link System#out}. */
    public void printSummary() {
        printSummary(System.out);
    }

    /**
     * Prints a human-readable summary to the provided {@link PrintStream}.
     *
     * @param out the destination stream
     */
    public void printSummary(PrintStream out) {
        out.println("Performance Summary:");
        out.println("  comparisons   : " + comparisons);
        out.println("  swaps         : " + swaps);
        out.println("  arrayAccesses : " + arrayAccesses);
        out.println("  elapsedTimeNs : " + elapsedTimeNs);
    }
}


