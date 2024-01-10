public class Semaphore {
    private int value;

    public Semaphore(int value) {
        this.value = value;
    }
    public synchronized void acquire() {
        String mode = User.mode ;
        if (mode.equalsIgnoreCase("reader")) {
            if (MSG_Queue.state.equalsIgnoreCase("write")) {
                while (value <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) { }
                }

                value--;} }  }
    public synchronized void release() {
        ++value;
        notify(); }
}
