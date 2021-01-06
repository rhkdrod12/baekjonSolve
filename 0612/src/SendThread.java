import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	
	private Socket m_Socket;
	
	SendThread(Socket m_Socket){
		setSocket(m_Socket);
	}
	
	public void run() {
		super.run();
		
		try {
			
			//�ۼ��� ��Ʈ��
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			//��������Ʈ�� -> ����(�����ڵ�)�� �޾Ƽ� ����Ʈ�� ��ȯ
			//InputStreamReader�� ���ڷ����� �����̶�� �ߴµ�
			//Ű���� �Է� -> ����Ʈ ��Ʈ��-> ����Ʈ ��Ʈ���� -> ���� ��Ʈ������ ��ȯ�ؾ�
			//Ű���� �Է��� ����Ʈ������ ������ -> �̰� ���ڴ����� �ޱ� ���ؼ� InputStreamReader�� ����ϰ� 
			//InputStreamReader�� ���̷�Ʈ�� �����͸� �޴� �����̹Ƿ� ���۸� ��ġ�� ���ؼ� BufferedReader�� ����Ѵ�.
			//�� �����ΰ�
			
			//
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			//��������Ʈ�� -> ����Ʈ�� �޾Ƽ� ����(�����ڵ�)�� ��ȯ
			
			String sendMessage;
			
			while(true) {
				
				sendMessage = tmpbuf.readLine();
				
				if(sendMessage.equals("exit")){
					break;
				}
				
				sendWriter.println(sendMessage);
				sendWriter.flush();	
			}
			
			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();			
		}
		catch(Exception e) {		
			e.printStackTrace();
		}		
	}

	public void setSocket(Socket m_Socket) {
		this.m_Socket = m_Socket;
	}	
}
