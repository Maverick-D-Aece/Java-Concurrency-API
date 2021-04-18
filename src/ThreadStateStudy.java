public class ThreadStateStudy {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(
				() -> System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState()));
		System.out.println(thread.getName() + " is " + thread.getState());
		thread.start();
		thread.join();
		if (thread.getState() == Thread.State.TERMINATED) {
			System.out.println(thread.getName() + " is " + thread.getState());
		}
	}
}