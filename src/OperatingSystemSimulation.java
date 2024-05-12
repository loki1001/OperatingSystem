import java.util.ArrayList;
import java.util.List;

public class OperatingSystemSimulation {
    public static void main(String[] args) {
        // Simulate process scheduling
        System.out.println("----- Process Scheduling Simulation -----");
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 5, 10));
        processes.add(new Process("P2", 1, 3, 8));
        processes.add(new Process("P3", 3, 6, 12));
        
        // First Come First Serve
        System.out.println("First Come First Serve:");
        Scheduler.runFCFS(new ArrayList<>(processes));

        // Last Come First Serve
        System.out.println("First Come Last Serve:");
        Scheduler.runLCFS(new ArrayList<>(processes));
        
        // Round Robin with quantum = 2
        System.out.println("\nRound Robin:");
        Scheduler.runRoundRobin(new ArrayList<>(processes), 2);
        
        // Shortest Process Next
        System.out.println("\nShortest Job First:");
        Scheduler.runSPN(new ArrayList<>(processes));

        // Shortest Remaining Time
        System.out.println("\nShortest Remaining Time:");
        Scheduler.runSRT(new ArrayList<>(processes));
        
        // Simulate memory allocation
        System.out.println("\n----- Memory Allocation Simulation -----");
        List<Process> memoryProcesses = new ArrayList<>();
        memoryProcesses.add(new Process("P1", 5, 5, 10));
        memoryProcesses.add(new Process("P2", 1, 3, 8));
        memoryProcesses.add(new Process("P3", 3, 6, 12));

        MemoryManager memoryManager;
        
        // First Fit
        System.out.println("First Fit Memory Allocation:");
        memoryManager = new MemoryManager();
        memoryManager.runFirstFit(new ArrayList<>(memoryProcesses));

        // Next Fit
        System.out.println("\nNext Fit Memory Allocation:");
        memoryManager = new MemoryManager();
        memoryManager.runNextFit(new ArrayList<>(memoryProcesses));
        
        // Best Fit
        System.out.println("\nBest Fit Memory Allocation:");
        memoryManager = new MemoryManager();
        memoryManager.runBestFit(new ArrayList<>(memoryProcesses));
        
        // Worst Fit
        System.out.println("\nWorst Fit Memory Allocation:");
        memoryManager = new MemoryManager();
        memoryManager.runWorstFit(new ArrayList<>(memoryProcesses));
        
        
        // Simulate mutual exclusion using Dekker's algorithm
        System.out.println("\n----- Dekker's Algorithm Simulation -----");
        Decker decker = new Decker();
        new Thread(() -> {
            decker.lock(0);
            // Critical section
            System.out.println("Thread 1 entered critical section");
            decker.unlock(0);
        }).start();
        
        new Thread(() -> {
            decker.lock(1);
            // Critical section
            System.out.println("Thread 2 entered critical section");
            decker.unlock(1);
        }).start();
        
        // Simulate mutual exclusion using Peterson's algorithm
        System.out.println("\n----- Peterson's Algorithm Simulation -----");
        Peterson peterson = new Peterson();
        new Thread(() -> {
            peterson.lock(0);
            // Critical section
            System.out.println("Thread 1 entered critical section");
            peterson.unlock(0);
        }).start();
        
        new Thread(() -> {
            peterson.lock(1);
            // Critical section
            System.out.println("Thread 2 entered critical section");
            peterson.unlock(1);
        }).start();
    }
}
