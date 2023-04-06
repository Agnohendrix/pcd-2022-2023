package pcd.lab03.liveness;

/**
 * Deadlock example 
 * 
 * @author aricci
 *
 */
public class TestDeadlockedResource {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors() + " cores");
		Resource res = new Resource();
		new ThreadA(res).start();
		new ThreadB(res).start();
	}

}
