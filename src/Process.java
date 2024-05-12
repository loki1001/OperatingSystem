// Process class to represent a process
public class Process {
    // Name of process
    String name;
    // Time of arrival
    int arrivalTime;
    // Total time to execute
    int executionTime;
    // Remaining time to execute completely
    int remainingexecutionTime;
    // Size of memory occupied
    int memorySize;
    // State of the process
    ProcessState state;

    // COnstructor
    public Process(String name, int arrivalTime, int executionTime, int memorySize) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.remainingexecutionTime = executionTime;
        this.memorySize = memorySize;
        this.state = ProcessState.NEW;
    }
}