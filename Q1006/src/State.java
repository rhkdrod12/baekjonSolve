import java.util.ArrayList;

public class State {
	int val;
	int total;
	int begin;
	
	ArrayList<State> next = new ArrayList<State>();
		
	public State(int val, int total) {
		// TODO Auto-generated constructor stub
		this.val = val;		
		this.total = total;
	}	
	public State(int val, int total, int begin) {
		// TODO Auto-generated constructor stub
		this.val = val;		
		this.total = total;
		this.begin = begin;
	}	
}
