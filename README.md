OpenDaylight CI Optimization
🚀 Overview
This Java program helps OpenDaylight optimize cloud infrastructure costs by analyzing CI testing jobs. It calculates job costs based on job details and cloud VM prices, then provides optimization recommendations.

🔧 Features
Job Data Parsing: Reads job_data.csv (job name, run count, duration, VM flavor).
Cost Data Parsing: Reads cost_data.csv (cost per VM flavor).
Cost Calculation: Calculates total job cost and provides optimization suggestions.
Report Generation: Outputs optimization_report.csv with recommendations.
📄 Sample Input
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
📊 Sample Output
optimization_report.csv
csv
Copy code
Job Name,VM Flavor,Total Cost,Recommendation
Job1,small,2.00,Optimal
Job2,medium,5.00,Optimal
Job3,large,9.00,Reduce Frequency or VM Size
🛠️ How to Run
Clone or download the project.
Save the code in a file named OpenDaylightCIOptimization.java.
Compile:
bash
Copy code
javac OpenDaylightCIOptimization.java
Run:
bash
Copy code
java OpenDaylightCIOptimization
View the Output: Check optimization_report.csv for recommendations.
⚙️ Requirements
Java 8 or later
CSV input files (job_data.csv, cost_data.csv)
