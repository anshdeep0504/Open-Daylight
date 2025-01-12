OpenDaylight CI Optimization
Overview
Java program to optimize cloud infrastructure costs by analyzing CI job data and VM costs, generating cost-saving recommendations.

Features
Parse job data (job_data.csv)
Parse VM cost data (cost_data.csv)
Calculate job costs and generate optimization suggestions
Output: optimization_report.csv with recommendations
Sample Input
job_data.csv
csv
Copy code
Job Name,Run Count,Duration (hours),VM Flavor
Job1,50,2,small
Job2,100,1,medium
Job3,30,3,large
cost_data.csv
csv
Copy code
VM Flavor,Cost Per Hour
small,0.02
medium,0.05
large,0.1
Sample Output
optimization_report.csv
csv
Copy code
Job Name,VM Flavor,Total Cost,Recommendation
Job1,small,2.00,Optimal
Job2,medium,5.00,Optimal
Job3,large,9.00,Reduce Frequency or VM Size
How to Run
Save as OpenDaylightCIOptimization.java
Compile:
bash
Copy code
javac OpenDaylightCIOptimization.java
Run:
bash
Copy code
java OpenDaylightCIOptimization
Check Output: optimization_report.csv
Requirements
Java 8+
CSV input files
License
MIT License

