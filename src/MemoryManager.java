import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// MemoryManager class to have different memory allocation algorithms
public class MemoryManager {
    // List to hold memory blocks
    private List<MemoryBlock> memory;

    // Constructor to initialize memory with holes
    public MemoryManager() {
        memory = new ArrayList<>();
        memory.add(new MemoryBlock(null, 20));
        memory.add(new MemoryBlock(null, 30));
        memory.add(new MemoryBlock(null, 15));
    }

    // Function to simulate First Fit memory allocation
    public void runFirstFit(List<Process> processes) {
        for (Process process : processes) {
            boolean allocated = false;
            // Go through memory blocks
            for (MemoryBlock block : memory) {
                // Check if a block big enough and is a hole
                if (block.size >= process.executionTime && block.process == null) {
                    // Allocate process to block and update its state
                    block.process = process;
                    allocated = true;
                    process.state = ProcessState.RUNNING;
                    break;
                }
            }
            if (!allocated) {
                System.out.println("Error allocating memory for " + process.name);
                process.state = ProcessState.TERMINATED;
            }
        }
        displayMemoryAllocation();
    }

    // Function to simulate Next Fit memory allocation
    public void runNextFit(List<Process> processes) {
        // Index to see where last allocation was
        int index = 0;

        for (Process process : processes) {
            boolean allocated = false;
            // Go through memory blocks starting with the last allocation index
            for (int i = index; i < memory.size(); i++) {
                MemoryBlock block = memory.get(i);
                // Check if a block big enough and is a hole
                if (block.size >= process.executionTime && block.process == null) {
                    // Allocate process to block and update its state and store the index
                    block.process = process;
                    allocated = true;
                    process.state = ProcessState.RUNNING;
                    index = i;
                    break;
                }
            }
            if (!allocated) {
                System.out.println("Error allocating memory for " + process.name);
                process.state = ProcessState.TERMINATED;
            }
        }
        displayMemoryAllocation();
    }

    public void runBestFit(List<Process> processes) {
        // Create a copy of the memory list
        List<MemoryBlock> originalMemory = new ArrayList<>(memory);
        
        // Sort processes by size
        Collections.sort(processes, (p1, p2) -> Integer.compare(p1.executionTime, p2.executionTime));
        
        // Sort memory blocks by size
        Collections.sort(memory, (b1, b2) -> Integer.compare(b1.size, b2.size));
        
        for (Process process : processes) {
            MemoryBlock bestFit = null;
            
            // Iterate through memory blocks
            for (MemoryBlock block : memory) {
                // Check if the block is a hole and its size is sufficient for the process
                if (block.size >= process.executionTime && block.process == null) {
                    bestFit = block; 
                    break; 
                }
            }
            
            if (bestFit != null) {
                // Allocate process to the best fit block
                bestFit.process = process;
                process.state = ProcessState.RUNNING;
            } else {
                System.out.println("Error allocating memory for " + process.name);
                process.state = ProcessState.TERMINATED;
            }
        }
        
        // Restore original sequence of memory blocks
        memory = originalMemory;
        
        displayMemoryAllocation();
    }

    public void runWorstFit(List<Process> processes) {
        // Create a copy of the memory list
        List<MemoryBlock> originalMemory = new ArrayList<>(memory);
    
        // Sort processes by size in descending order
        Collections.sort(processes, Comparator.comparingInt(p -> p.executionTime));
    
        for (Process process : processes) {
            MemoryBlock worstFit = null;
    
            // Go through memory
            for (MemoryBlock block : originalMemory) {
                // Check if the block is a hole and its size is sufficient for the process
                if (block.size >= process.executionTime && (worstFit == null || block.size > worstFit.size) && block.process == null) {
                    worstFit = block;
                }
            }
    
            if (worstFit != null) {
                worstFit.process = process;
                process.state = ProcessState.RUNNING;
            } else {
                Collections.sort(originalMemory, Comparator.comparingInt(b -> b.size));
                for (MemoryBlock block : originalMemory) {
                    if (block.size >= process.executionTime && block.process == null) {
                        worstFit = block;
                        worstFit.process = process;
                        process.state = ProcessState.RUNNING;
                        break;
                    }
                }
                if (worstFit == null) {
                    System.out.println("Error allocating memory for " + process.name);
                    process.state = ProcessState.TERMINATED;
                }
            }
        }
    
        displayMemoryAllocation();
    }

    private void displayMemoryAllocation() {
        System.out.println("Memory Allocation:");
        for (MemoryBlock block : memory) {
            if (block.process != null) {
                System.out.println("Memory Block: " + block.size + " Process: " + block.process.name);
            } else {
                System.out.println("Memory Block: " + block.size + " Process: Hole");
            }
        }
    }
}