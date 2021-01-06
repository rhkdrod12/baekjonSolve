package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ServerSocket s_socket = new ServerSocket(12000);
			
			System.out.println("立加 措扁 吝...");
			Socket c_socket = s_socket.accept();
			System.out.println(c_socket.getInetAddress()+ "立加");
		
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(c_socket.getInputStream()));			
			BufferedReader inputbuf = new BufferedReader(new InputStreamReader(System.in));				
			PrintWriter sendWriter = new PrintWriter(c_socket.getOutputStream(), true);
			
			String sendMessage;
			String reciveMessage;
								
			sendMessage = "Welcom Server";
			
			sendWriter.println(sendMessage);
			sendWriter.flush();
					
				
			while(true) {
				
				
				reciveMessage = tmpbuf.readLine();
				
				if(reciveMessage == null) {
					break;
				}
				
				System.out.println("recv: "+ reciveMessage);				
			}
			
			
			s_socket.close();
			c_socket.close();			
			
			
			
		}		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
