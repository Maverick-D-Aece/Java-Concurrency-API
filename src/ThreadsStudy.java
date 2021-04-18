public class ThreadsStudy {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("\nMy main thread: " + Thread.currentThread().getName());
    }
}

// creating a thread by extending Thread class
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("My thread: " + getName());
    }

}
