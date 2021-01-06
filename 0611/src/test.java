
public class test extends Thread{

	private int loofCounter = 1000;
	
	char c;
	
	test(char c){
		this.c = c;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		for(int i = 1; i<=loofCounter ;i++)
		{
			System.out.print(c);
			if(i%50 == 0) {
				System.out.println("");
			}
		}
		
		super.run();
	}	
}
