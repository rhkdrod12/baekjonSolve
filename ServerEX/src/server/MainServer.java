package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ServerSocket s_socket = new ServerSocket(12000);
			
			Socket c_socket = s_socket.accept();
						
			//BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(c_socket.getOutputStream());
			
			String sendMessage;
			
			sendMessage = "Welcom Server";
			
			sendWriter.println(sendMessage);
			sendWriter.flush();
			
			
			s_socket.close();
			c_socket.close();			
			
			
			
		}		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
