package Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class User {

	protected static String userId;
	protected static Socket msocket;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("접속 중..");
			msocket = new Socket("192.168.200.115", 12000);
						
			System.out.println("접속 완료");
			
			System.out.println("메시지 쓰레드 설정");
			
			SendMessage send = new SendMessage(msocket);
			ReciveMessage recv = new ReciveMessage(msocket);
			
			System.out.println("쓰레드 설정 완료");						
			System.out.print("아이디 입력: ");
			userId = sc.nextLine();
						
			System.out.println("아이디 전송");
			send.sendMessage(userId);
			
			System.out.println("메시지 전송 실행");
			send.start();
			recv.start();			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
