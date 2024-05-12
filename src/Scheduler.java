import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scheduler {
    // First Come First Serve scheduling
    public static void runFCFS(List<Process> processes) {
        // Sort processes based on arrival
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        for (Process process : processes) {
            if (currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime;
            }
            System.out.println("Process " + process.name + " is in state: " + process.state + " at time " + currentTime);
            process.state = ProcessState.READY;
            currentTime += process.executionTime;
            process.state = ProcessState.TERMINATED;
        }
    }

    // Last Come First Serve scheduling
    public static void runLCFS(List<Process> processes) {
        // Sort processes based on arrival time in descending order
        processes.sort((p1, p2) -> Integer.compare(p2.arrivalTime, p1.arrivalTime));
        
        int currentTime = 0;
        for (Process process : processes) {
            if (currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime;
            }
            System.out.println("Process " + process.name + " is in state: " + process.state + " at time " + currentTime);
            process.state = ProcessState.READY;
            currentTime += process.executionTime;
            process.state = ProcessState.TERMINATED;
        }
    }

    // Round Robin scheduling
    public static void runRoundRobin(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            currentProcess.state = ProcessState.RUNNING;
            System.out.println("Process " + currentProcess.name + " is in state: " + currentProcess.state + " at time " + currentTime);
            currentTime += Math.min(currentProcess.remainingexecutionTime, quantum);
            currentProcess.remainingexecutionTime -= Math.min(currentProcess.remainingexecutionTime, quantum);

            if (currentProcess.remainingexecutionTime > 0) {
                currentProcess.state = ProcessState.READY;
                queue.offer(currentProcess);
            } else {
                currentProcess.state = ProcessState.TERMINATED;
            }
        }
    }

    // Shortest Process Next scheduling
    public static void runSPN(List<Process> processes) {
        // Sort processes based on shortest execution time
        processes.sort(Comparator.comparingInt(p -> p.executionTime));

        int currentTime = 0;
        for (Process process : processes) {
            if (currentTime < process.arrivalTime)
                currentTime = process.arrivalTime;
            System.out.println("Process " + process.name + " is in state: " + process.state + " at time " + currentTime);
            process.state = ProcessState.READY;
            currentTime += process.executionTime;
            process.state = ProcessState.TERMINATED;
        }
    }

    // Shortest Remaining Time (SRT) scheduling
    public static void runSRT(List<Process> processes) {
        PriorityQueue<Process> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.remainingexecutionTime));
        queue.addAll(processes);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            currentProcess.state = ProcessState.RUNNING;
            System.out.println("Process " + currentProcess.name + " is in state: " + currentProcess.state + " at time " + currentTime);
            currentTime += currentProcess.remainingexecutionTime;
            currentProcess.remainingexecutionTime = 0;
            currentProcess.state = ProcessState.TERMINATED;
        }
    }
}
