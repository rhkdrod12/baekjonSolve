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
	int dotX[], dotY[];	
	int sumX, sumY;
	
	double vect;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		//�׽�Ʈ���̽� �Է�
		testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test++) {
			
			sumX = 0;
			sumY = 0;
			vect = Double.POSITIVE_INFINITY;

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
			
			Combination(0, 0, 0, 0);
			System.out.println(vect);
			
			//�Է¿Ϸ�, ���
		}		
		sc.close();
	}
	
	public void Combination(int begin, int level, int ex, int ey) {
		
		if(level < dotNum / 2) {
			for(int i = begin ; i < dotNum ; i++ ) {
				Combination(i+1, level+1, ex + dotX[i], ey + dotY[i]);		
			}			
		}
		else {
			vect = Math.min(vect, vectLength(2*ex - sumX, 2*ey - sumY));				
		}			
	}

	public double vectLength(double x, double y) {		
		return Math.sqrt(x*x + y*y);		
	}
	
}






