package cli;

import algorithms.Kadane;
import metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = 1000;
        int trials = 1;
        String outCsv = "results.csv";

        if (args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) {}
        }
        if (args.length > 1) {
            try { trials = Integer.parseInt(args[1]); } catch (NumberFormatException ignored) {}
        }
        if (args.length > 2) {
            outCsv = args[2];
        }

        File csvFile = new File(outCsv);
        try {
            PerformanceTracker.ensureCsvHeader(csvFile);
        } catch (IOException e) {
            System.err.println("Cannot ensure CSV header: " + e.getMessage());
        }

        for (int t = 0; t < trials; t++) {
            int[] arr = generateRandomArray(n);

            Kadane kadane = new Kadane();
            long result = kadane.kadane(arr);

            PerformanceTracker tracker = kadane.getTracker();

            System.out.println("Run " + (t+1) + "/" + trials + " — n=" + n);
            System.out.println("Kadane result: " + result);
            System.out.println("Execution time (ns): " + tracker.getExecutionTime());
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Array Accesses: " + tracker.getArrayAccesses());
            System.out.println("Iterations: " + tracker.getIterations());
            System.out.println("Updates: " + tracker.getUpdates());
            System.out.println("Start index: " + tracker.getStartIndex() +
                    " End index: " + tracker.getEndIndex());
            System.out.println("----------------------------------------");

            // CSV append: n + tracker.toCSV()
            try (FileWriter writer = new FileWriter(csvFile, true)) {
                writer.write(n + "," + tracker.toCSV() + "\n");
            } catch (IOException e) {
                System.err.println("Failed to write CSV: " + e.getMessage());
            }
        }
    }
//бенч
    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(2001) - 1000; // диапазон [-1000,1000]
        }
        return arr;
    }
}
