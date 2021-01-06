package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReciveMessage extends Thread{
	
	private Socket msocket;
	private BufferedReader tmpbuf;
	private String message;
	
	ReciveMessage(Socket msocket){
		
		setMsocket(msocket);
		
		try {			
			tmpbuf = new BufferedReader(new InputStreamReader(this.msocket.getInputStream()));			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		super.run();
		try {		
			while(true) {				
				message = tmpbuf.readLine();
				if(message == null) {
					break;
				}			
				System.out.println(message);
				
			}			
			tmpbuf.close();		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMsocket(Socket msocket) {
		this.msocket = msocket;
	}	
}
