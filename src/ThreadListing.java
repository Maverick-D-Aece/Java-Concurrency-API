import java.util.Set;

public class ThreadListing {

	public static void main(String[] args) {

		// listing all the threads currently running
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		for (Thread thread : threads) {
			String name = thread.getName();
			Thread.State state = thread.getState();
			int priority = thread.getPriority();
			String type = thread.isDaemon() ? "Daemon" : "User";
			System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type);
		}
	}
}
