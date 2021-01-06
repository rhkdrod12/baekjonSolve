
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marin marin1 = new Marin();
		Marin marin2 = new Marin();
		
		marin1.attack(marin2);
		marin1.attack(marin2);
		marin1.attack(marin2);
		marin1.attack(marin2);
		marin1.attack(marin2);
		marin1.attack(marin2);
	}

}


abstract class Unit{
	
	protected String name;
	
	protected int health;
	
	protected int damage;
	protected int damageType;
	
	protected int defence;
	protected int defenceType;
	
	protected int attackRange;
	protected int attackSplash;
	
	protected int attackSpeed;
	
	protected int enermyDamge;
	
	/* 공격타입 
	 * 0 경공격
	 * 1 중공격
	 * 2 강공격
	 */
	/* 장갑타입
	 * 0 장갑없음
	 * 1 경장갑
	 * 2 중장갑
	 */	
	/* 공격범위
	 * 1~10;
	 */
	
	//공격
	abstract void attack(Unit unit);
	//반격
	abstract void counterAttack(Unit unit);	
	//방어
	abstract void defence(Unit unit);	
	
	public abstract String toString();
}

class Marin extends Unit{
	
	Marin(){
		
		name = "Marin";
		
		health = 50;
		
		damage = 10;
		damageType = 0;
		
		defence = 1;
		defenceType = 0;
		
		attackRange = 5;
		attackSplash = 1;
		
		attackSpeed = 1;
	}	
	
	@Override
	void attack(Unit unit) {
		// TODO Auto-generated method stub
		if(unit.health>0) {
			unit.enermyDamge = (this.damage * (1-(this.damageType - unit.defenceType)/10));
			
			System.out.printf("%s은 %s를 공격했다\n", this, unit);
			System.out.printf("%d의 피해를 가했다.\n", unit.enermyDamge);							
				
			unit.defence(this);	
		}
	}

	@Override
	void counterAttack(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void defence(Unit unit) {
		// TODO Auto-generated method stub
		
		this.health -= this.enermyDamge;
		
		if(this.health > 0) {
			System.out.printf("%s는 %d의 피해를 입었다.\n", this, this.enermyDamge);
			System.out.printf("남은체력: %d\n", this.health);
		}
		else {
			this.health = 0;
			System.out.printf("%s는 쓰러졌다.\n", this);
		}		
	}	
	
	
	public String toString() {
		return name;
	}
}