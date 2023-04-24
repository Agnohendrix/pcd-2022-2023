package pcd.lab04.monitors;

public class TestBoundedBuffer {

	public static void main(String[] args) throws InterruptedException {
		//IBoundedBuffer<Integer> buffer = new BoundedBuffer1<Integer>(4);
		IBoundedBuffer<Integer> buffer = new BoundedBuffer1<Integer>(100);

		int nProducers = 1;
		int nConsumers = 10;

		for (int i = 0; i < nProducers; i++){
			new Producer(buffer).start();
		}
		Thread.sleep(10000);
		for (int i = 0; i < nConsumers; i++){
			new Consumer(buffer).start();
		}
	}	
}
