public class ThreadsStudy {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread("Thread Lord");
        myThread.start();

        Runnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();

        System.out.println("\nMy main thread: " + Thread.currentThread().getName());
    }
}

// creating a thread by extending Thread class
class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("\nMy thread: " + getName());
    }

}

// creating a thread by implementing Runnable interface
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("\nMy runnable: " + Thread.currentThread().getName());
    }

}
