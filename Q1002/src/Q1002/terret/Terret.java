package Q1002.terret;

import java.util.Scanner;


public class Terret {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�׽�Ʈ ���̽� �� �Է�: ");
		int testCase = sc.nextInt();
		
		int x1 = 0;
		int y1 = 0;			
		int r1 = 0;
		
		int x2 = 0;
		int y2 = 0;
		int r2 = 0;
		
		int count[] = {0, 0, 0};
		
		for(int i = 0; i < testCase ; i++) {
			
			boolean flag = false;
			
			while(flag == false) {
				
				System.out.print("x1, y1, r1, x2, y2, r2 �Է�: ");
				
				x1 = sc.nextInt();
				y1 = sc.nextInt();			
				r1 = sc.nextInt();
				
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				r2 = sc.nextInt();
							
				if(compareValue(x1, -10000, 10000) &&
				compareValue(y1, -10000, 10000) &&
				compareValue(x2, -10000, 10000) &&
				compareValue(y2, -10000, 10000) &&
				compareValue(r1, 1, 10000) &&
				compareValue(r2, 1, 10000)) 
				{
					break;					
				}
				System.out.println("�߸��� ���� �Է�!, �ٽ� �Է�!");			
			}			
			
			/*
			 * �� ��ǥ�� ���� ���� �� �ִ� ��� -> ��ǥ���� ��Ÿ���ŭ ������ �׷��� �� �� ���� ���� ������ ��츸 �ش�
			 * ����� ���� �� ������ ���� ���, �� ������ ���� ���, ��ġ�� ���, �ȸ����� ��� 4������ �з� ��
			 * 
			 * �� ���� ��� : ������ ���� 1
			 * �� ���� ��� : ������ ���� 2
			 * ��ġ�� ��� : ���Ѵ�
			 * �ȸ����� ���: 0
			 * 
			 * �� ��ǥ���� �Ÿ��� d��� ���� �� 
			 * 
			 * ���� �ۿ��� �� ������ ���							: d>0, r1+r2 < d
			 * �������·� �� ���� ���� �� ������ ���� �� 					: d>0, r1+r2 = d 			
			 * �� ������ ������ ��� 								: d>0, r1-r2 < d < r1+r2 			  
			 * �������·� �� ���� ���� �� ������ ���� ��(r1 > r2 �� ���)	: d>0, r1-r2 = d	
			 * ���� �ȿ��� �� ������ ���							: d>=0, r1-r2 > d
			 * ��ġ�� ��� 										: d = 0, r1-r2 = 0 (r1 = d = r2)
			 * 
			 */
			
			
			double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));						
			
			if(r1 < r2) {
				int temp = r2;
				r2 = r1;
				r1 = temp;
			}			
			
			int min = r1 - r2;
			int max = r1 + r2;			
			
			if(compareValue(d, 0) == 1) {				
															//���� �ۿ��� ������ ��� (����)
				
				if(compareValue(d, max) == 0) {				//���� �����ϴ� ���
					count[i] = 1;
				}
				else if(compareValue(d, max) == -1){		//���� �ȿ��� ������ ���						
					if(compareValue(d, min) == 1) {			//�ȿ��� �����µ� �� ������ ������ ���
						count[i] = 2;
					}
					else if(compareValue(d, min) == 0) {	//�ȿ��� �����µ� �� ������ ������ ���
						count[i] = 1;
					}					
					// 										//���� �ȿ��� �ȸ����� ���(����)
				}				
			}
			else {
															//���� �ȿ��� �ȸ����� ���2(����)				
				if(compareValue(d, min) == 0){				//���� ��ġ�� ���
					count[i] = -1;
				}
			}				
			System.out.println("��ġ�� ��ǥ ��: "+count[i]);			
		}			
		sc.close();
	}
	
	private static boolean compareValue(int value, int start, int end) {
		
		if(value >= start && value <= end) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	private static int compareValue(double value, double value2) {
		return Double.compare(value, value2);		
	}
}
