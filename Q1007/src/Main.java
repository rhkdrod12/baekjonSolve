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
		
		//테스트케이스 입력
		testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test++) {
			
			sumX = 0;
			sumY = 0;
			vect = Double.POSITIVE_INFINITY - 1;
			temp = 0;
			x = 0;					
			y = 0;
			
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
			
			//입력완료, 계산
			solve();
		}		
		sc.close();
	}
	
	public void solve() {
		
		
		System.out.printf("sumX: %.1f sumY: %.1f\n\n", sumX, sumY);
		
		if(dotNum >= 4) {
			for(int i = 0 ; i < dotNum -1 ; i++) {
				System.out.print(i);
				
				search2(i+1 , dotNum/2 - 1, dotX[i], dotY[i]);
				System.out.println();
			}
		}
		else {
			search2(0, 1, dotX[0], dotY[0]);
		}
				
		System.out.printf("%.12f",vect);
	
	}
	
	public void search2(int begin, int loop, int preX, int preY) {
		
		
		System.out.print(begin);
		for(int i = begin ; i < dotNum ; i++) {
			
			if(i > begin) {
				System.out.print("\n");
				for(int j = 0 ; j < dotNum/2  - loop ; j++) System.out.print(" ");
				System.out.print(i);
			}
						
			if(loop > 1 && i < dotNum - 1) {
				
				search2(i+1, loop - 1, preX + dotX[i], preY + dotY[i]);
			}
			
			else if(loop <= 1){
				
				double tempX = preX + dotX[i];
				double tempY = preY + dotY[i];
								
				temp = vectLength(2*tempX-sumX, 2*tempY-sumY);	
				System.out.printf(" x: %5.1f y: %5.1f temp: %03.12f", tempX, tempY, temp);
								
				if(Double.compare(vect, temp) == 1) vect = temp;
				
				tempX = 0;
				tempY = 0;		
				
			}
		}
		System.out.println();
		for(int j = 0 ; j < dotNum/2 - 1 - loop ; j++) System.out.print(" ");
	}
	
	public double vectLength(double x, double y) {		
		return Math.sqrt(Math.pow(x, 2) + (Math.pow(y, 2)));		
	}
	
}





