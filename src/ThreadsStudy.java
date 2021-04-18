public class ThreadsStudy {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread("Thread Lord");
        myThread.start();

        Runnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();

        Thread interruptedThread = new Thread(new InterruptedThread());
        interruptedThread.start();
        try {
            Thread.sleep(5000);
            interruptedThread.interrupt();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }

        Thread threadJoin = new Thread(new ThreadJoin());
        threadJoin.start();
        try {
            threadJoin.join();
            // threadJoin.join(10000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

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
        // pausing a thread
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("I have been interrrupted!");
        }
        System.out.println("\nSorry I'm late - My runnable: " + Thread.currentThread().getName());
    }
}

// creating an interruptable thread
class InterruptedThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is mesage #" + i);

            try {
                Thread.sleep(2000);
                continue;
            } catch (InterruptedException e) {
                System.out.println("I'm dead.");
                return;
            }
        }
    }
}

// creating a joinable thread
class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("I'm dead.");
                return;
            }
        }
    }
}
