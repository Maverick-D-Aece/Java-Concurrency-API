public class ThreadGroupStudy {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("My Threads");

		for (int i = 0; i < 5; i++) {
			new MyMemberThread(threadGroup, "Thread #" + i).start();
		}

		Thread.sleep(5000);
		threadGroup.interrupt();
	}
}

class MyMemberThread extends Thread {

	public MyMemberThread(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println(getName() + " is running");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				isRunning = false;
				System.out.println(getName() + " was interrupted and has now terminated - touchy bastard!");
			}
		}
	}
}
