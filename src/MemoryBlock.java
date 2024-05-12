// MemoryBlock class for block of memory
class MemoryBlock {
    // Reference associated process
    Process process;
    // Size of memory block
    int size;

    // Constructor
    public MemoryBlock(Process process, int size) {
        this.process = process;
        this.size = size;
    }
}