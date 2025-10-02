# Assignment 2 – Kadane’s Algorithm (Maximum Subarray Problem)
# Student: Adilzhan Zhumash
# Group:SE-2422
## Overview

This project implements **Kadane’s Algorithm** for finding the maximum subarray sum with position tracking.
It includes performance tracking, testing, and empirical validation.

## Features

* Clean Java implementation with input validation
* Performance metrics (comparisons, iterations, array accesses, updates, execution time)
* CLI benchmark runner with configurable input sizes
* CSV export of performance data
* Unit tests with edge cases
* JMH micro-benchmarking
* Empirical performance plots

## Project Structure

```
assignment2-kadane/
├── src/main/java/
│   ├── algorithms/Kadane.java
│   ├── metrics/PerformanceTracker.java
│   └── cli/BenchmarkRunner.java
├── src/test/java/
│   └── algorithms/KadaneTest.java
├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
├── README.md
└── pom.xml
```

## Usage

### Run CLI

```bash
mvn clean package
java -cp target/assignment2-kadane-1.0-SNAPSHOT.jar cli.BenchmarkRunner 1000
```

### Run Tests

```bash
mvn test
```

### Run Benchmarks

```bash
java -cp target/assignment2-kadane-1.0-SNAPSHOT.jar cli.BenchmarkRunner 100
java -cp target/assignment2-kadane-1.0-SNAPSHOT.jar cli.BenchmarkRunner 1000
java -cp target/assignment2-kadane-1.0-SNAPSHOT.jar cli.BenchmarkRunner 10000
```

## Complexity Analysis

* **Time Complexity:**

    * Best Case: Θ(n)
    * Worst Case: Θ(n)
    * Average Case: Θ(n)
* **Space Complexity:** O(1) auxiliary space (in-place, memory efficient)

## Deliverables

* Implementation with metrics
* Analysis report (`docs/analysis-report.pdf`)
* Performance plots (`docs/performance-plots/`)
* Full Git commit history
