package pcd.lab04.monitors;

import java.util.*;

class Producer extends Thread {

	private IBoundedBuffer<Integer> buffer;
	private Random gen;
	
	public Producer(IBoundedBuffer<Integer> buffer){
		gen = new Random();
		this.buffer = buffer;
	}

	public void run(){
		int i = 100;
		while ( i > 0){
			Integer item = produce();
			try {
				buffer.put(item);
				log("produced "+item);
				i--;
				System.out.println("i " + i);
			} catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		System.out.println("Ended generating");
	}
	
	private Integer produce(){
		int v = gen.nextInt(100);
		return v;
	}
	
	private void log(String st){
		synchronized(System.out){
			System.out.println("["+this.getName()+"] "+st);
		}
	}
}
