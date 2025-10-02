package algorithms;

import metrics.PerformanceTracker;

public class Kadane {
    private final PerformanceTracker tracker = new PerformanceTracker();

    public PerformanceTracker getTracker() {
        return tracker;
    }
    //кадане
    //второй кадане
    public long kadane(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        tracker.startMeasurement();

        tracker.incArrayAccesses();
        long maxSoFar = arr[0];
        long maxEndingHere = arr[0];
        int start = 0, end = 0, tempStart = 0;

        tracker.incUpdates();

        for (int i = 1; i < arr.length; i++) {
            tracker.incIterations();
            tracker.incArrayAccesses(); // читать arr[i]
            tracker.incComparisons();  // сравнение ниже

            long candidate = maxEndingHere + arr[i];

            if (arr[i] > candidate) {
                maxEndingHere = arr[i];
                tempStart = i;
                tracker.incUpdates();
            } else {
                maxEndingHere = candidate;
                tracker.incUpdates();
            }

            tracker.incComparisons();
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
                tracker.incUpdates();
            }
        }

        tracker.setResult(maxSoFar, start, end);
        tracker.stopMeasurement();
        return maxSoFar;
    }
}
