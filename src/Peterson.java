public class Peterson {
    // Flags to see which process wants critical section
    private volatile boolean[] flag = new boolean[2];
    // Target process for which the lock is acquired
    private volatile int target;

    public void lock(int id) {
        // Calculate the id of other process
        int other = 1 - id;
        // Set the flag for the current process
        flag[id] = true;
        // Set the target to the current process
        target = id;
        while (flag[other] && target == id) {
            // Wait
        }
    }

    // Reset flag
    public void unlock(int id) {
        flag[id] = false;
    }
}
