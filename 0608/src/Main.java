import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sd sd = new Sd("����", 100, 85, 95);
		
		Students st = new Students();
		
		st.register("����", 100, 85, 95);
		st.register("�輱��", 98, 85, 100);
		st.register("����", 45, 90, 100);
		st.register("�̼���", 50, 100, 45);
		st.register("�ټ���", 10, 50, 20);
		
		
		st.display();
		
		
	}

}

class student{
	
	private String name;
	private int score[] = new int [3];
	
	private int sum = 0;
	private float avr = 0;	
	
	private static int totalScore[] = new int [3];
	private static int totalSum = 0;
	private static float totalAvr= 0;
	
	student(String name, int algorism, int ai, int math){
		
		this.name = name;	
		
		this.score[0] = algorism;
		this.score[1] = ai;
		this.score[2] = math;
		
		for(int i = 0; i<score.length;i++) {			
			sum+=score[i];
			this.totalScore[i] += score[i];
		}
		
		avr = (float)sum/score.length;		
		
		totalSum +=sum;
		totalAvr +=avr;
	}
	
}
class Students{
	
	ArrayList<Sd> studentList = new ArrayList<Sd>();
	
	private static int totalScore[] = new int [3];
	private static float totalScoreArr[] = new float [3];
	private static int totalSum = 0;
	private static int totalSumAvr = 0;
	private static float totalAvr= 0;
	
	void register(String name, int algorism, int ai, int math) {
		
		Sd temp = new Sd(name, algorism, ai, math);
		studentList.add(temp);
		
		for(int i = 0; i<totalScore.length;i++) {
			totalScore[i] += temp.getScore()[i];
		}		
		
		for(int i = 0; i<totalScore.length;i++) {
			totalScoreArr[i] = totalScore[i] / studentList.size();
		}	
		
		totalSum += temp.getSum();
		totalAvr = totalSum / studentList.size();
		
	}
	
	void display() {
		
		System.out.printf("�̸�\t�˰���\tAI\t����\t����\t���\n");
		for(int i =0; i< studentList.size();i++) {
			studentList.get(i).display();
		}				
		
		System.out.print("���\t");
		for(int i =0; i< totalScore.length;i++) {
			System.out.printf("%.2f\t",totalScoreArr[i]);
		}
		System.out.printf("%d\t", totalSum);
		System.out.printf("%.2f\n", totalAvr);
		
	}	
}

class Sd{
	
	private String name;
	private int score[] = new int[3];
	
	private int sum = 0;
	private float avr = 0;
	
	Sd(String name, int algorism, int ai, int math){
		
		this.name = name;	
		
		this.score[0] = algorism;
		this.score[1] = ai;
		this.score[2] = math;
		
		for(int i = 0; i<score.length;i++) {			
			sum+=score[i];
		}	
		
		avr = (float)sum/score.length;				
		
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int[] getScore() {
		return score;
	}

	void setScore(int[] score) {
		this.score = score;
	}

	int getSum() {
		return sum;
	}

	void setSum(int sum) {
		this.sum = sum;
	}

	float getAvr() {
		return avr;
	}

	void setAvr(float avr) {
		this.avr = avr;
	}
	
	void display() {
		System.out.printf("%s\t", name);
		System.out.printf("%d\t", score[0]);
		System.out.printf("%d\t", score[1]);
		System.out.printf("%d\t", score[2]);
		System.out.printf("%d\t", sum);
		System.out.printf("%.2f\n", avr);		
	}
	
}