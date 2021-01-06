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
		
		//테스트케이스 입력
		testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test++) {
			
			sumX = 0;
			sumY = 0;
			vect = Double.POSITIVE_INFINITY;

			//점의 개수 입력(짝수만 가능하도록)
			dotNum = sc.nextInt();
			
			dotX = new int[dotNum];		
			dotY = new int[dotNum];
			
			//점 좌표 입력
			for(int i = 0; i < dotNum ; i++) {
				//x, y값 입력
				dotX[i] = sc.nextInt();
				dotY[i] = sc.nextInt();
				
				//x축 총 합, y축 총 합
				//어차피 값들이 dotNum/2수 만큼 종점으로 선택하게 되고 이를 모두 더하는 식이기 때문에
				//sumX - 종점합 = 시작점합 이 될 것임
				sumX += dotX[i];
				sumY += dotY[i];
			}
			
			Combination(0, 0, 0, 0);
			System.out.println(vect);
			
			//입력완료, 계산
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






