
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
	
	/* ����Ÿ�� 
	 * 0 �����
	 * 1 �߰���
	 * 2 ������
	 */
	/* �尩Ÿ��
	 * 0 �尩����
	 * 1 ���尩
	 * 2 ���尩
	 */	
	/* ���ݹ���
	 * 1~10;
	 */
	
	//����
	abstract void attack(Unit unit);
	//�ݰ�
	abstract void counterAttack(Unit unit);	
	//���
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
			
			System.out.printf("%s�� %s�� �����ߴ�\n", this, unit);
			System.out.printf("%d�� ���ظ� ���ߴ�.\n", unit.enermyDamge);							
				
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
			System.out.printf("%s�� %d�� ���ظ� �Ծ���.\n", this, this.enermyDamge);
			System.out.printf("����ü��: %d\n", this.health);
		}
		else {
			this.health = 0;
			System.out.printf("%s�� ��������.\n", this);
		}		
	}	
	
	
	public String toString() {
		return name;
	}
}