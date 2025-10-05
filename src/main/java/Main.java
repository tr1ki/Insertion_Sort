import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};   // Исходный массив
        PerformanceTracker tracker = new PerformanceTracker();

        tracker.start();                   // Начинаем замер
        InsertionSort.sort(arr, tracker);  // Сортировка с трекером
        tracker.stop();                    // Останавливаем таймер

        System.out.println("Sorted array: " + Arrays.toString(arr)); // 👈 вот эта строка
        tracker.printSummary();            // Печать метрик
    }
}
