package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	
	static ArrayList<PrintWriter> outputList;
	
	static ArrayList<Socket> socketList;
	
	public static void main(String[] args) {
		
		ServerSocket s_socket;
		Socket c_socket;	
		
		outputList = new ArrayList<PrintWriter>();
						
		try {
			System.out.println("서버 실행");
			s_socket = new ServerSocket(12000);					
					
			while(true) {				
				
				c_socket = s_socket.accept();
								
//				socketList.add(c_socket);
				outputList.add(new PrintWriter(c_socket.getOutputStream()));
				
				Manager client = new Manager(c_socket);	
				client.start();
				
			}
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		
	}	
}
