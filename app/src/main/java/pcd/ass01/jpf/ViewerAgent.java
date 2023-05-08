package pcd.ass01.jpf;

public class ViewerAgent extends BasicAgent {

	private SourceLocMap map;
	private View view;
	private Flag done;
	
	protected ViewerAgent(SourceLocMap map, View view, Flag done) {
		super("viewer");
		this.map = map;
		this.view = view;
		this.done = done;
	}

	public void run() {
		while (!done.isSet()) {
			try {
				view.update(map.getSnaptshot());
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		view.update(map.getSnaptshot());
	}
}
