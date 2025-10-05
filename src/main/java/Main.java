import metrics.PerformanceTracker;

public class Main {
    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();

        tracker.start();

        // Эмулируем сортировку
        for (int i = 0; i < 5; i++) {
            tracker.incComparisons();
            tracker.incSwaps();
            tracker.incArrayAccesses(2);
        }

        tracker.stop();

        tracker.printSummary();
    }
}
