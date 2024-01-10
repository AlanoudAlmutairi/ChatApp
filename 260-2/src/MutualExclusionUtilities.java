public class MutualExclusionUtilities {
    /**
     * critical and non-critical sections are simulated by sleeping
     * for a random amount of time between 0 and 3 seconds.
     */
    public static void criticalSection() {

        SleepUtilities.nap(3);
    }

    public static void nonCriticalSection() {

        SleepUtilities.nap(3);
    }

}
