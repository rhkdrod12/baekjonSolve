package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage extends Thread{

	private Socket msocket;
	private BufferedReader tmpbuf;
	private PrintWriter sendWriter;
	private String message;
	
	SendMessage(Socket msocket){
		setMsocket(msocket);
		
		try {			
			tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			sendWriter = new PrintWriter(this.msocket.getOutputStream(), true);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		super.run();
		
		try {	
			while(true) {	
				System.out.print("메시지 입력: ");
				message = tmpbuf.readLine();				
				if(message.equals("exit")) {
					break;
				}				
				sendWriter.printf("[%s]: %s\n",User.userId, message);								
			}						
			sendWriter.close();
			tmpbuf.close();
			msocket.close();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void sendMessage(String message) throws IOException {		
		sendWriter.println(message);				
	}
	
	public void setMsocket(Socket msocket) {
		this.msocket = msocket;
	}	
}
