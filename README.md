# OpenDaylight CI Optimization

## Overview
Java program to optimize cloud infrastructure costs by analyzing CI job data and VM costs, generating cost-saving recommendations.

## Features
- Parse job data (`job_data.csv`)
- Parse VM cost data (`cost_data.csv`)
- Calculate job costs and generate optimization suggestions
- Output: `optimization_report.csv` with recommendations

## Sample Input

### `job_data.csv`
```csv
Job Name,Run Count,Duration (hours),VM Flavor
Job1,50,2,small
Job2,100,1,medium
Job3,30,3,large
