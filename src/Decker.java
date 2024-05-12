// Decker class to store Decker algorithm
public class Decker {
    // Flags to see which process wants critical section
    private volatile boolean[] flag = new boolean[2];
    // Determine turn
    private volatile int turn = 0; 

    // Lock critical section
    public void lock(int id) {
        // Get the id of the other process
        int other = 1 - id;
        // Set flag to true, want crtical section
        flag[id] = true;
        // While the other process wants
        while (flag[other]) {
            // If it is the other process turn
            if (turn == other) {
                // Set own flag to false
                flag[id] = false; 
                while (turn == other) {
                    // Wait until this process's turn
                }
                flag[id] = true; // Own process's turn again, set flag to true
            }
        }
    }

    // Unlock critical section with id
    public void unlock(int id) {
        flag[id] = false; 
        turn = 1 - id;
    }
}
