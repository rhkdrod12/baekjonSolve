import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���� ��� ���
		//1.socket create
		//2.bind
		//3.accept			<- �ڹٿ����� �� �κ��� create�ϰ� �Ǹ� ��Ʈ�� �����ϸ� �ڵ����� 
		//4.listen
		//5.send/recv
		//6.close
		
		//���� ������ �ڱ� �ڽ��̹Ƿ� IP�� �ʿ����, ���μ����� ������ ��Ʈ�� �����ϸ� ��
		//���� ����� ������ �ְ� �޴� ����
		
		//Ŭ���̾�Ʈ�� ���� ������ ���� ���� �ʿ��� 
		ServerSocket s_Socket;
		Socket c_Socket;
		
		try {
			
			s_Socket = new ServerSocket(12000);
			
			//s_Socket.accept() -> ������ ���� ��� ���·� ����� ��!
			//Ŭ���̾�Ʈ�� ������ ��û�ϰ� �Ǹ� �ش� Ŭ���̾�Ʈ�� ���������� �޾� c_Socket�� ������
			c_Socket = s_Socket.accept();
			
			//SendThread send = new SendThread(c_Socket);
			
			ReciveThread recive = new ReciveThread(c_Socket);
			SendThread send = new SendThread(c_Socket);
			
						
			while(true) {				
							
				
				
			}				
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
