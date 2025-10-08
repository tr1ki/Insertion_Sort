## Assignment 2 — Design and Analysis of Algorithms
### Pair 1 — Insertion Sort (Student A)

#### Overview
This repository contains a clean, instrumented implementation of Insertion Sort, together with a small CLI for benchmarking and a test suite. The goals are to:
- Implement a correct and stable Insertion Sort
- Add lightweight optimizations (e.g., early stop in the inner loop)
- Measure and report key performance metrics: comparisons, element moves, array accesses, runtime
- Compare theory with empirical results on different input shapes

---

### Project Layout
```
assignment2-insertion-sort/
├── src/main/java/
│   ├── algorithms/
│   │   └── InsertionSort.java
│   ├── metrics/
│   │   └── PerformanceTracker.java
│   └── cli/
│       ├── BenchmarkRunner.java
│       └── MainCheck.java
├── src/test/java/
│   └── algorithms/
│       └── InsertionSortTest.java
├── docs/
│   ├── analysis-report.md
│   └── performance-plots/
│       ├── comparisons_plot.png
│       └── elapsed_time_plot.png
├── benchmark_results.csv
├── plot_benchmark.py
├── pom.xml
└── README.md (this file)
```

---

### Algorithm Intuition
Insertion Sort builds a sorted prefix on the left by repeatedly taking the next element and inserting it into its correct place, shifting larger elements one position to the right.

```text
for i = 1 to n - 1
  key = arr[i]
  j = i - 1
  while j >= 0 and arr[j] > key   // stop early as soon as arr[j] <= key
    arr[j + 1] = arr[j]           // shift right
    j = j - 1
  arr[j + 1] = key
```

Properties:
- Stable (preserves relative order of equal elements)
- In-place (O(1) extra space)
- Works particularly well on nearly sorted data

---

### Complexity at a Glance
| Case              | Comparisons (≈)     | Moves/Shifts (≈) | Time      | Notes                               |
| ----------------- | ------------------- | ---------------- | --------- | ------------------------------------ |
| Best (Ω)          | n − 1               | O(1)             | Ω(n)      | Already sorted; inner loop breaks fast |
| Average (Θ)       | n²/4 … n²/2         | Θ(n²)            | Θ(n²)     | Random data                          |
| Worst (O)         | n²/2                | n²/2             | O(n²)     | Reverse-sorted                       |

- Array accesses are dominated by shifts in average/worst cases.
- Early termination improves constants on nearly sorted inputs but not the asymptotic rate.

---

### What We Measure
The `metrics/PerformanceTracker.java` collects and exposes:
- Comparisons: number of `arr[j] > key` checks
- Moves/Shifts: element writes during insertion
- Array accesses: total reads + writes
- Runtime: nanosecond resolution for the sort call

Metrics are printed by the CLI and can be exported to CSV for plotting.

---

### Build & Run
Prerequisites: Java 17+ and Maven, Python 3 (optional, for plotting).

Build the project (skipping tests):
```bash
mvn clean package -DskipTests
```

Run the benchmark CLI (from the repo root):
```bash
java -cp target/assignment2-insertion-sort-1.0.0-SNAPSHOT.jar cli.BenchmarkRunner
```

Quick sanity check program:
```bash
java -cp target/assignment2-insertion-sort-1.0.0-SNAPSHOT.jar cli.MainCheck
```

Run tests:
```bash
mvn test
```

---

### Benchmarking & Results
`cli/BenchmarkRunner.java` executes multiple runs across array sizes and input types (e.g., sorted, reverse, random). Results are appended to `benchmark_results.csv` with the tracked metrics. A sample plotting script is provided:

```bash
python plot_benchmark.py
```

Generated figures are saved under `docs/performance-plots/` (e.g., `comparisons_plot.png`, `elapsed_time_plot.png`).

---

### Testing Scope
Unit tests cover core scenarios:

```
✅ Empty array            → returns empty
✅ Single element         → unchanged
✅ Already sorted         → near-linear due to early stop
✅ Reverse sorted         → worst-case comparisons/moves
✅ Duplicates             → stability preserved
✅ Negative numbers       → correctly sorted
✅ Random array           → matches Arrays.sort()
✅ Null input             → IllegalArgumentException
```

---

### Key Takeaways
- Insertion Sort is simple, stable, and in-place with excellent behavior on nearly sorted inputs.
- Although the worst-case remains quadratic, locality of reference and small constants make it competitive for small arrays or partially ordered data.
- Instrumentation clarifies where time is spent: element moves and array accesses dominate in practice.

---

### Running on Windows
If you are using PowerShell, the commands are the same. Ensure you execute them from the project root and that `java`, `mvn`, and (optionally) `python` are on your PATH.


