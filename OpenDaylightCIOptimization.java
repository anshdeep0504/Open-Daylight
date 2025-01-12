import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OpenDaylightCIOptimization {

    public static void main(String[] args) {
        // Input file paths
        String jobDataFile = "src/main/resources/job_data.csv";
        String costDataFile = "src/main/resources/cost_data.csv";
        String outputFile = "src/main/output/optimization_report.csv";

        try {
            // Step 1: Parse Job Data
            List<Job> jobs = parseJobData(jobDataFile);

            // Step 2: Parse Cost Data
            Map<String, Double> costData = parseCostData(costDataFile);

            // Step 3: Optimize Jobs
            List<OptimizedJob> optimizedJobs = optimizeJobs(jobs, costData);

            // Step 4: Write Output
            writeOptimizationReport(optimizedJobs, outputFile);

            System.out.println("Optimization complete! Report generated: " + outputFile);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Parse job data from CSV
    private static List<Job> parseJobData(String filePath) throws IOException {
        List<Job> jobs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                jobs.add(new Job(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]));
            }
        }
        return jobs;
    }

    // Parse cost data from CSV
    private static Map<String, Double> parseCostData(String filePath) throws IOException {
        Map<String, Double> costData = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                costData.put(parts[0], Double.parseDouble(parts[1]));
            }
        }
        return costData;
    }

    // Optimize job configurations
    private static List<OptimizedJob> optimizeJobs(List<Job> jobs, Map<String, Double> costData) {
        return jobs.stream()
            .map(job -> {
                double costPerRun = costData.getOrDefault(job.getVmFlavor(), 0.0);
                double totalCost = costPerRun * job.getRunCount() * job.getDuration();
                String recommendation = (totalCost > 5000) ? "Reduce Frequency or VM Size" : "Optimal";
                return new OptimizedJob(job.getName(), job.getVmFlavor(), totalCost, recommendation);
            })
            .collect(Collectors.toList());
    }

    // Write optimization report to CSV
    private static void writeOptimizationReport(List<OptimizedJob> optimizedJobs, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Job Name,VM Flavor,Total Cost,Recommendation\n");
            for (OptimizedJob job : optimizedJobs) {
                writer.write(String.format("%s,%s,%.2f,%s\n", job.getName(), job.getVmFlavor(), job.getTotalCost(), job.getRecommendation()));
            }
        }
    }

    // Inner class to represent a Job
    static class Job {
        private final String name;
        private final int runCount;
        private final int duration;
        private final String vmFlavor;

        public Job(String name, int runCount, int duration, String vmFlavor) {
            this.name = name;
            this.runCount = runCount;
            this.duration = duration;
            this.vmFlavor = vmFlavor;
        }

        public String getName() { return name; }
        public int getRunCount() { return runCount; }
        public int getDuration() { return duration; }
        public String getVmFlavor() { return vmFlavor; }
    }

    // Inner class to represent an Optimized Job
    static class OptimizedJob {
        private final String name;
        private final String vmFlavor;
        private final double totalCost;
        private final String recommendation;

        public OptimizedJob(String name, String vmFlavor, double totalCost, String recommendation) {
            this.name = name;
            this.vmFlavor = vmFlavor;
            this.totalCost = totalCost;
            this.recommendation = recommendation;
        }

        public String getName() { return name; }
        public String getVmFlavor() { return vmFlavor; }
        public double getTotalCost() { return totalCost; }
        public String getRecommendation() { return recommendation; }
    }
}
