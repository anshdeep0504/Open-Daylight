OpenDaylight CI Optimization
This project is designed to help OpenDaylight reduce cloud infrastructure costs by analyzing and optimizing their continuous integration (CI) testing jobs using a data-driven approach. The program reads job details and cloud costs from CSV files, calculates the total cost for each job, and generates an optimization report with recommendations.

Features:
Job Data Parsing: Reads job details (name, run count, duration, and VM flavor) from job_data.csv.
Cost Data Parsing: Reads cloud cost data (cost per VM flavor) from cost_data.csv.
Optimization Logic: Calculates the total cost of each job and provides optimization recommendations based on cost thresholds.
Output Report: Saves the results in an optimization report (optimization_report.csv), which includes job names, VM flavors, total costs, and recommendations.
Sample Input Data:
job_data.csv:
csv
Copy code
Job Name,Run Count,Duration (hours),VM Flavor
Job1,50,2,small
Job2,100,1,medium
Job3,30,3,large
cost_data.csv:
csv
Copy code
VM Flavor,Cost Per Hour
small,0.02
medium,0.05
large,0.1
Sample Output:
optimization_report.csv:
csv
Copy code
Job Name,VM Flavor,Total Cost,Recommendation
Job1,small,2.00,Optimal
Job2,medium,5.00,Optimal
Job3,large,9.00,Reduce Frequency or VM Size
Steps to Run the Project:
Clone or download the project into your directory.

Save the following code into a file named OpenDaylightCIOptimization.java in your project directory.

Compile the Java program:

bash
Copy code
javac OpenDaylightCIOptimization.java
Run the program:

bash
Copy code
java OpenDaylightCIOptimization
Check the Output: After running the program, check the optimization_report.csv file for the optimization recommendations.

Requirements:
Java Development Kit (JDK) 8 or later.
CSV files with job and cost data (example files provided).
Recommendations:
The optimization_report.csv will contain optimization recommendations such as "Optimal" (no action needed) or "Reduce Frequency or VM Size" for jobs that can be optimized to save costs.
License:
This project is open-source and free to use under the MIT License.
