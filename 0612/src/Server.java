import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//소켓 통신 방식
		//1.socket create
		//2.bind
		//3.accept			<- 자바에서는 위 부분은 create하게 되면 포트만 지정하면 자동생성 
		//4.listen
		//5.send/recv
		//6.close
		
		//서버 소켓은 자기 자신이므로 IP는 필요없고, 프로세서를 구분할 포트만 지정하면 됨
		//소켓 통신은 소켓을 주고 받는 형태
		
		//클라이언트가 보낸 소켓을 받을 곳이 필요함 
		ServerSocket s_Socket;
		Socket c_Socket;
		
		try {
			
			s_Socket = new ServerSocket(12000);
			
			//s_Socket.accept() -> 서버를 접속 대기 상태로 만드는 것!
			//클라이언트가 접속을 요청하게 되면 해당 클라이언트의 소켓정보를 받아 c_Socket에 저장함
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
