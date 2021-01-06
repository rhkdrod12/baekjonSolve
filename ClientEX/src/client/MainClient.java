package client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
						
			Socket m_socket = new Socket("192.168.200.115", 12000);
			
			
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			
			BufferedReader inputbuf = new BufferedReader(new InputStreamReader(System.in));			
			PrintWriter sendWriter = new PrintWriter(m_socket.getOutputStream() , true);
						
//			BufferedWriter sendWriter = new BufferedWriter(new OutputStreamWriter(m_socket.getOutputStream()))
			
			String sendMessage;
			String reciveMessage;
			
			reciveMessage = tmpbuf.readLine();			
			System.out.println(reciveMessage);				
			
			sendWriter.println("Ŭ���̾�Ʈ ����");
			sendWriter.flush();
			
			while(true)
			{
				System.out.print("�޽��� �Է�: ");
				sendMessage = inputbuf.readLine();
				
				if(sendMessage.equals("exit")) {
					sendWriter.println("Ŭ���̾�Ʈ ��������");
					sendWriter.println("exit");
					break;
				}
				
				
				System.out.print(sendMessage);
				
				sendWriter.printf("%s\n",sendMessage);
				
			}
			
			System.out.println("���� ����");
			
			tmpbuf.close();
			inputbuf.close();
			sendWriter.close();
			m_socket.close();
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}
}