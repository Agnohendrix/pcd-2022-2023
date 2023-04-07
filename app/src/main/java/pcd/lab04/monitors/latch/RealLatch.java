package pcd.lab04.monitors.latch;

public class RealLatch implements Latch{
    private int counter;

    public RealLatch(int counter){
        this.counter = counter;
    }
    @Override
    public synchronized void countDown() {
        counter--;
        System.out.println("Counter: " + counter);
        if( counter == 0)
            notifyAll();
    }

    @Override
    public synchronized void await() throws InterruptedException {
        while (counter > 0)
            wait();
    }
}
