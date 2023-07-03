package th03;

public class Count implements Runnable {
    private Thread myThread;

    public Count() {
        myThread = new Thread(this, "my runnable thread");
        System.out.println("my thread created" + myThread);
        myThread.start();
    }



    public Thread getMyThread() {
        return myThread;
    }
    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("My life is countdown for " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("My life is over");
    }


}
