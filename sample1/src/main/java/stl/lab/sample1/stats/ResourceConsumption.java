package stl.lab.sample1.stats;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResourceConsumption {
	/**
     * Returns used memory in MB
     */
    public static double usedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return usedMemory(runtime);
    }

    /**
     * Returns max memory available MB
     */
    public static double maxMemory() {
        Runtime runtime = Runtime.getRuntime();
        return maxMemory(runtime);
    }
    
    static double usedMemory(Runtime runtime) {
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        double usedMemory = (double)(totalMemory - freeMemory) / (double)(1024 * 1024);
        return usedMemory;
    }

    static double freeMemory(Runtime runtime) {
        long freeMemory = runtime.freeMemory();
        return (double)freeMemory / (double)(1024 * 1024);
        
    }
    
    static double totalMemory(Runtime runtime) {
        long total = runtime.totalMemory();
        return (double)total / (double)(1024 * 1024);
        
    }
    
    static double maxMemory(Runtime runtime) {
        long maxMemory = runtime.maxMemory();
        double memory = (double)maxMemory / (double)(1024 * 1024);
        return memory;
    }

    public static String printResourceReport() {
        return getMemoryInfo().toString();
    }

    public static StringBuffer getMemoryInfo() {
        StringBuffer buffer = new StringBuffer();
        
        runGC();

        Runtime runtime = Runtime.getRuntime();
        double totalMemory = totalMemory(runtime);
        double usedMemory = usedMemory(runtime);
        double maxMemory = maxMemory(runtime);
        double freeMemory = freeMemory(runtime);
        
        NumberFormat f = new DecimalFormat("###,##0.0");
        
        String lineSeparator = System.getProperty("line.separator");
        buffer.append("Available Processors: " + Runtime.getRuntime().availableProcessors()).append(lineSeparator);
        buffer.append("Max memory: " + f.format(maxMemory) + "MB").append(lineSeparator);
        buffer.append("Total memory: " + f.format(totalMemory) + "MB").append(lineSeparator);
        buffer.append("Used memory: " + f.format(usedMemory) + "MB").append(lineSeparator);
        buffer.append("Free memory: " + f.format(freeMemory) + "MB").append(lineSeparator);
        return buffer;
    }

    public static void runGC() {
        System.gc();
        System.runFinalization();
    }
}
