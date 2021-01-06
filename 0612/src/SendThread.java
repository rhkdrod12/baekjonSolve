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
			
			//송수신 스트림
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			//문자형스트림 -> 문자(유니코드)를 받아서 바이트로 변환
			//InputStreamReader은 데코레이터 패턴이라고 했는데
			//키보드 입력 -> 바이트 스트림-> 바이트 스트림을 -> 문자 스트림으로 변환해야
			//키보드 입력은 바이트형태의 데이터 -> 이걸 문자단위로 받기 위해서 InputStreamReader을 사용하고 
			//InputStreamReader은 다이렉트로 데이터를 받는 형태이므로 버퍼를 거치기 위해서 BufferedReader을 사용한다.
			//이 정도인가
			
			//
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			//문자형스트림 -> 바이트를 받아서 문자(유니코드)로 변환
			
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
