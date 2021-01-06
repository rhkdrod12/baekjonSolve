package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Manager extends Thread {

	private Socket m_socket;
	private String userID = null;
	
	Manager(Socket m_socket){		
		this.m_socket = m_socket;		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			BufferedReader tmpbuffer = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			String message;							
			
//			System.out.println(m_socket.getInetAddress() + "�� �����Ͽ����ϴ�.");
//			for(PrintWriter pw: Server.outputList) {
//				pw.println(m_socket.getInetAddress() + "�� �����Ͽ����ϴ�.");
//			}
			
			
			while(true) {
				
				message = tmpbuffer.readLine();
				
				if(userID == null) {
					userID = message;
					
					System.out.println("["+userID +"]"+ "�� �����Ͽ����ϴ�.");
					for(PrintWriter pw: Server.outputList) {
						pw.println("["+userID +"]" + "�� �����Ͽ����ϴ�.");
					}
				}
				
				if(message == null) {
					System.out.println("["+userID +"]" + "��(��) �������ϴ�.");
					
					for(PrintWriter pw: Server.outputList) {
						pw.println("["+userID +"]" + "��(��) �������ϴ�.");
					}
					break;
				}		
				
				for(PrintWriter pw: Server.outputList) {
					
					if(pw.toString().equals((new PrintWriter(m_socket.getOutputStream())).toString()))  {
						System.out.println("test");
						continue;
					}				
					
					pw.println(message);		
					pw.flush();
				}			
				
			}
			
			Server.outputList.remove(new PrintWriter(m_socket.getOutputStream()));
			m_socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	
	
}
