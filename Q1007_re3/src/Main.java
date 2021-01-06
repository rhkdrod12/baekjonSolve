import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		quest qu = new quest();
		
		qu.input();
		
	}
}


class quest{
	
	int testCase;
	int dotNum;
	int dotX[];
	int dotY[];
	
	double x, y;
	double sumX, sumY;
	double vect, temp = 0;
	
	int testNumber = 0;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		//�׽�Ʈ���̽� �Է�
		testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test++) {
			
			sumX = 0;
			sumY = 0;
			vect = Double.POSITIVE_INFINITY;
			temp = 0;
			x = 0;					
			y = 0;
			
			//���� ���� �Է�(¦���� �����ϵ���)
			dotNum = sc.nextInt();
			
			dotX = new int[dotNum];		
			dotY = new int[dotNum];
			
			//�� ��ǥ �Է�
			for(int i = 0; i < dotNum ; i++) {
				//x, y�� �Է�
				dotX[i] = sc.nextInt();
				dotY[i] = sc.nextInt();
				
				//x�� �� ��, y�� �� ��
				//������ ������ dotNum/2�� ��ŭ �������� �����ϰ� �ǰ� �̸� ��� ���ϴ� ���̱� ������
				//sumX - ������ = �������� �� �� ����
				sumX += dotX[i];
				sumY += dotY[i];
			}
			
			//�Է¿Ϸ�, ���
			solve();
		}		
		sc.close();
	}
	
	public void solve() {
		
		
		System.out.printf("sumX: %.1f sumY: %.1f\n\n", sumX, sumY);
		
		if(dotNum > 2)
			for(int i = 0 ; i < dotNum - 1 ; i++) {
				search2(i+1 , dotNum/2 - 1, dotX[i], dotY[i], printNum(i));
			}	
		else{
			for(int i = 0 ; i< dotNum ; i++) {
				search2(0, 0, dotX[i], dotY[i], printNum(i));
			}
		}
		System.out.printf("%.6f",vect);
	
	}
	
	public void search2(int begin, int loop, int preX, int preY, int num) {
				
		if(loop >= 1) {
			for(int i = begin ; i < dotNum ; i++) {							
				search2(i+1, loop - 1, preX + dotX[i], preY + dotY[i], printNum(num + i));			
			}
			
		}		
		else{
			
			System.out.printf("%0"+dotNum/2+"d", num/10);	
			
			double tempX = preX;
			double tempY = preY;
							
			temp = vectLength(2*tempX-sumX, 2*tempY-sumY);							
			System.out.printf(" x: %5.1f y: %5.1f temp: %03.12f\n", tempX, tempY, temp);
							
			vect = Math.min(vect, temp);
			
			tempX = 0;
			tempY = 0;		
			
		}
	}
	public int printNum(int num) {		
		return num*10;
	}
	
	public double vectLength(double x, double y) {		
		return Math.sqrt(x*x + y*y);		
	}
	
}





