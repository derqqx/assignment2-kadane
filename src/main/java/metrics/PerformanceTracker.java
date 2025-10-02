package metrics;
//перфомарманс
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons;
    private long updates;
    private long arrayAccesses;
    private long iterations;

    private long startTime;
    private long endTime;

    private long result;
    private int startIndex;
    private int endIndex;

    public void reset() {
        comparisons = 0;
        updates = 0;
        arrayAccesses = 0;
        iterations = 0;
        startTime = 0;
        endTime = 0;
        result = 0;
        startIndex = -1;
        endIndex = -1;
    }

    public void startMeasurement() {
        reset();
        startTime = System.nanoTime();
    }

    public void stopMeasurement() {
        endTime = System.nanoTime();
    }

    public long getExecutionTime() {
        return endTime - startTime;
    }

    public void incComparisons() { comparisons++; }
    public void incArrayAccesses() { arrayAccesses++; }
    public void incIterations() { iterations++; }
    public void incUpdates() { updates++; }

    public void setResult(long result, int startIndex, int endIndex) {
        this.result = result;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getIterations() { return iterations; }
    public long getUpdates() { return updates; }
    public long getResult() { return result; }
    public int getStartIndex() { return startIndex; }
    public int getEndIndex() { return endIndex; }

    public String toCSV() {
        return getExecutionTime() + "," +
                comparisons + "," +
                arrayAccesses + "," +
                iterations + "," +
                updates + "," +
                result + "," +
                startIndex + "," +
                endIndex;
    }

    public static void ensureCsvHeader(File csvFile) throws IOException {
        if (!csvFile.exists()) {
            try (FileWriter fw = new FileWriter(csvFile, false)) {
                fw.write("n,time_ns,comparisons,array_accesses,iterations,updates,result,start,end\n");
            }
        }
    }
}
