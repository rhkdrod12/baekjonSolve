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
			
			System.out.println("���� ��..");
			msocket = new Socket("192.168.200.115", 12000);
						
			System.out.println("���� �Ϸ�");
			
			System.out.println("�޽��� ������ ����");
			
			SendMessage send = new SendMessage(msocket);
			ReciveMessage recv = new ReciveMessage(msocket);
			
			System.out.println("������ ���� �Ϸ�");						
			System.out.print("���̵� �Է�: ");
			userId = sc.nextLine();
						
			System.out.println("���̵� ����");
			send.sendMessage(userId);
			
			System.out.println("�޽��� ���� ����");
			send.start();
			recv.start();			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
