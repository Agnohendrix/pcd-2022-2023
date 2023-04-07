package pcd.lab04.monitors.barrier;

public class RealBarrier implements Barrier {
    private int nSoFar;
    private int nTotal;
    public RealBarrier(int nTotal){
        this.nTotal = nTotal;
        this.nSoFar = 0;
    }
    @Override
    public synchronized void hitAndWaitAll() throws InterruptedException {
        this.nSoFar++;
        while(nSoFar < nTotal)
            wait();
        notifyAll();
    }
}
