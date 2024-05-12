Please run OperatingSystemSimulation.java

Sample output:
----- Process Scheduling Simulation -----
First Come First Serve:
Process P1 is in state: NEW at time 0
Process P2 is in state: NEW at time 5
Process P3 is in state: NEW at time 8
First Come Last Serve:
Process P3 is in state: TERMINATED at time 3
Process P2 is in state: TERMINATED at time 9
Process P1 is in state: TERMINATED at time 12

Round Robin:
Process P1 is in state: RUNNING at time 0
Process P2 is in state: RUNNING at time 2
Process P3 is in state: RUNNING at time 4
Process P1 is in state: RUNNING at time 6
Process P2 is in state: RUNNING at time 8
Process P3 is in state: RUNNING at time 9
Process P1 is in state: RUNNING at time 11
Process P3 is in state: RUNNING at time 12

Shortest Job First:
Process P2 is in state: TERMINATED at time 1
Process P1 is in state: TERMINATED at time 4
Process P3 is in state: TERMINATED at time 9

Shortest Remaining Time:
Process P1 is in state: RUNNING at time 0
Process P3 is in state: RUNNING at time 0
Process P2 is in state: RUNNING at time 0

----- Memory Allocation Simulation -----
First Fit Memory Allocation:
Memory Allocation:
Memory Block: 20 Process: P1
Memory Block: 30 Process: P2
Memory Block: 15 Process: P3

Next Fit Memory Allocation:
Memory Allocation:
Memory Block: 20 Process: P1
Memory Block: 30 Process: P2
Memory Block: 15 Process: P3

Best Fit Memory Allocation:
Memory Allocation:
Memory Block: 20 Process: P1
Memory Block: 30 Process: P3
Memory Block: 15 Process: P2

Worst Fit Memory Allocation:
Memory Allocation:
Memory Block: 20 Process: P1
Memory Block: 30 Process: P2
Memory Block: 15 Process: P3

----- Dekker's Algorithm Simulation -----
Thread 1 entered critical section

----- Peterson's Algorithm Simulation -----
Thread 2 entered critical section
Thread 1 entered critical section
Thread 2 entered critical section