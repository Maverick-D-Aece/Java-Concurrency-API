public class DaemonThreadStudy {
	public static void main(String[] args) {

		// a normal (user) thread
		Thread userThread = new Thread(() -> {
			int x = 5;
			while (x > 0) {
				System.out.println("User thread #" + x--);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		userThread.start();

		// a daemon thread
		Thread daemonThread = new Thread(() -> {
			while (true) {
				System.out.println("Daemon Thread's still breathing...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		// we need to enable the daemon flag to let the JVM know that this is a daemon
		daemonThread.setDaemon(true);
		// you will see that the JVM does not give a damn if the daemon thread is still
		// running or not - quite disheartening if you ask me
		daemonThread.start();
	}
}