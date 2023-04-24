package pcd.lab04.monitors;


class Consumer extends Thread {

	private IBoundedBuffer<Integer> buffer;
	
	public Consumer(IBoundedBuffer<Integer> buffer){
		this.buffer = buffer;
	}

	public void run(){
		while (!buffer.isEmpty()){
			try {
				Integer item = buffer.get();
				consume(item);
			} catch (InterruptedException ex){
				ex.printStackTrace();
			}
		}
		System.out.println(this.getName() + "Ended buffer");
	}
	
	private void consume(Integer item){
		log("consumed "+item);
	}
	
	private void log(String st){
		synchronized(System.out){
			System.out.println("["+this.getName()+"] "+st);
		}
	}
}
