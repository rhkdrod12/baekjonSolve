import java.util.ArrayList;
import java.util.Scanner;

public class Quest implements Cloneable {
	
	int testCase;
	
	int area;
	int areaEnemy[][];
		
	int speicalForce;		
	
	int max = 0;
	public void input2() {
		Scanner	sc;		
		
		sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		area = sc.nextInt();
		speicalForce = sc.nextInt();
				
		areaEnemy = new int[2][area];
		
		for(int i = 0; i<2 ; i++) {
			
			for(int j = 0; j<area ; j++) {
				areaEnemy[i][j] = sc.nextInt();
			}			
		}
		
		System.out.println(testCase);
		System.out.println(area + " " + speicalForce);
		
		for(int i = 0; i<2 ; i++) {
			for(int j = 0; j<area ; j++) {
				System.out.print(areaEnemy[i][j] + " ");
			}			
			System.out.println(" ");
		}				
		System.out.println();
		sc.close();		
		//입력 완료	
	}
	public void input() {
		
		Scanner	sc;		
		
		sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		area = sc.nextInt();
		speicalForce = sc.nextInt();
				
		areaEnemy = new int[2][area];
		
		for(int i = 0; i<2 ; i++) {
			
			for(int j = 0; j<area ; j++) {
				areaEnemy[i][j] = sc.nextInt();
			}			
		}
		
		System.out.println(testCase);
		System.out.println(area + " " + speicalForce);
		
		for(int i = 0; i<2 ; i++) {
			for(int j = 0; j<area ; j++) {
				System.out.print(areaEnemy[i][j] + " ");
			}			
			System.out.println(" ");
		}				
		System.out.println();
		sc.close();		
		//입력 완료	
		
		ArrayList<ArrayList<State>> tmps = new ArrayList<ArrayList<State>>();		
		ArrayList<State> stList = new ArrayList<State>();
		State st;
		
		for(int i = 0; i < area; i++) {
			int j = i+1;
			if(j == area) j = 0;
			
			//2 구역 선택 가능한 경우 반환
			ArrayList<State> tmp = stateCal(areaEnemy[0][i], areaEnemy[0][j], areaEnemy[1][j], areaEnemy[1][i], speicalForce);
			tmps.add(tmp);
			
			System.out.printf("[%d 단계]\n", i);
			
//			System.out.print("stVal 0 : ");
//			for(State sts : stList) {
//				if(sts.begin == 0)
//					System.out.print( sts.val + " ");				
//			}
//			System.out.println();
//			System.out.print("stVal 3 : ");
//			for(State sts : stList) {
//				if(sts.begin == 3)
//					System.out.print( sts.val + " ");				
//			}
//			System.out.println();
//			System.out.print("stVal 4 : ");
//			for(State sts : stList) {
//				if(sts.begin == 4)
//					System.out.print( sts.val + " ");				
//			}
//			System.out.println();
//			System.out.println();
			
			// 처음 시작은 연결안된 노드로 생성
			if(i == 0) {
				st = new State(0, 0);
				st.next = dpCal(st, tmp);	//dpCal 이 현재 값을 기준으로 선택 가능한 경로 찾기
				
				for(State stTmp: st.next) {
					stTmp.begin = stTmp.val;
				}
				
				stList.addAll(st.next);	
				continue;
			}
			// 두 번 째부터 시작
			else {
				ArrayList<State> stTmpList = new ArrayList<State>();
								
				for(State stTmp : stList) {
					if(i == (area - 1)) {		
											
						if(stTmp.begin == 1) {
							removeVal(tmp, new int[]{1,2,5,6});
						}
						else if(stTmp.begin == 3) {
							removeVal(tmp, new int[]{2,3,5,6});
						}						
						else if(stTmp.begin == 4 || stTmp.begin == 5 || stTmp.begin == 6) {
							removeVal(tmp, new int[]{1,2,3,5,6});
						}						
						ArrayList<State> sTmps = dpCal(stTmp, tmp);						
						stTmpList.addAll(sTmps);
												
					}
					else if(i < area-1) {
						stTmpList.addAll(dpCal(stTmp, tmp));
					}
				}
				
				stList = stTmpList;
			}			
		}		
		
		
		System.out.println("Max: "+ max);
		System.out.printf("특수 소대 최소수 : %d", (area-max)*2 + max);
		
		
	}
	public void removeVal(ArrayList<State> s, int[] targets){		
		for(int i = 0; i < s.size() ; i++) {			
			for(int target : targets) {
				if(s.get(i).val == target) {
					s.remove(i);
					i--;
				}
			}			
		}
	}
	
	public ArrayList<State> dpCal(State st, ArrayList<State> s) {
			
		int val = st.val;
		int total = st.total;
		int begin = st.begin;
		
		ArrayList<State> tmps = new ArrayList<State>();
		
//		System.out.printf("preVal  : %d\n", val);
//		System.out.printf("preTotal: %d\n", total);
//		System.out.printf("preBegin: %d\n", st.begin);

		if(val == 0) {					
			for(State tmp : s) {				
				State stateTmp = new State(tmp.val, tmp.total + total, begin);
				tmps.add(stateTmp);
				if(max <stateTmp.total) max = stateTmp.total;
			}					
		}		
		
		else if(val == 1) {			
			for(State tmp : s) {	
				if(tmp.val == 0) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 2) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 3) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
			}			
		}
		
		else if(val == 2) {
			for(State tmp : s) {				
				if(tmp.val == 0) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 2) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
			}			
		}
		
		else if(val == 3) {
			for(State tmp : s) {				
				if(tmp.val == 0) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 1) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 2) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
			}		
		}
		
		else if(val == 4) {	
			for(State tmp : s) {
				State stateTmp = new State(tmp.val, tmp.total + total, begin);
				tmps.add(stateTmp);
				if(max <stateTmp.total) max = stateTmp.total;
			}
		}
		
		else if(val == 5) {			
			for(State tmp : s) {				
				if(tmp.val == 0) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
				else if(tmp.val == 2) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
			}			
		}
		
		else if(val == 6) {
			for(State tmp : s) {				
				if(tmp.val == 0) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}				
				else if(tmp.val == 2) {
					State stateTmp = new State(tmp.val, tmp.total + total, begin);
					tmps.add(stateTmp);
					if(max <stateTmp.total) max = stateTmp.total;
				}
			}			
		}	
		
//		System.out.printf("val     : ");
//		for(State stTmp : tmps) {			
//			System.out.printf("%d ", stTmp.val);			
//		}
//		System.out.println();
//		System.out.printf("total   : ");
//		for(State stTmp : tmps) {			
//			System.out.printf("%d ", stTmp.total);			
//		}
//		System.out.println();
//		System.out.println();
		
		return tmps;
		
	}
	


	public ArrayList<State> stateCal(int a, int b, int c, int d, int sp) {
		
		 /*
		 * 2구역 침투 경우의 수 
		 * s0 : 겹치는 경우가 없는 경우	1		0		-> 어차피 0이고 무조건 발생 가능하므로 반환필요 없을 것으로 보임
		 * s1 : 1 , 2			 	1		1	
		 * s2 : 2 , 3				1		2
		 * s3 : 3 , 4				1		3
		 * s4 : 4 , 1				1		4
		 * s5 : (1, 2), (3, 4)		2		5
		 * s6 : (4, 1), (2, 3)		2		6
		 */
		
		System.out.printf("st[a: %d b: %d c: %d d: %d]\n\n", a,b,c,d);
		
		ArrayList<State> st = new ArrayList<State>();
		
		st.add(new State(0,0));								
		if(a+b<=sp) st.add(new State(1,1));
		if(b+c<=sp) st.add(new State(2,1));
		if(c+d<=sp) st.add(new State(3,1));
		if(d+a<=sp) st.add(new State(4,1));
		if((a+b<=sp && c+d<=sp)) st.add(new State(5,2));
		if((d+a<=sp && b+c<=sp)) st.add(new State(6,2));
				
		return st;
	}
	
}
