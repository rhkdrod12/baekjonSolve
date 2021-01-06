import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReciveThread extends Thread{

	private Socket m_Socket;
	
	ReciveThread(Socket m_Socket){
		setSocket(m_Socket);
	}
	
	public void run() {
		super.run();		
		
		try {
			
			BufferedReader buf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			
			String reciveMessage;
			
			while(true) {
				
				reciveMessage = buf.readLine();				
				System.out.println(reciveMessage);		
				
			}			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setSocket(Socket m_Socket) {
		this.m_Socket = m_Socket;
	}	
}
