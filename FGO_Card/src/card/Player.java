package card;
import character.Character;
import javax.swing.ImageIcon;

public class Player extends Creature{
	public Weapon weapon=null;
	public Player(String scientifficName,int hp)
	{
		super("Player."+scientifficName);
		//ImageIcon cardPicture=null;
		
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		if(weapon.hp>0)
		{
			
			if(weapon.hp>=opponent.hp)
			{
				weapon.hp-=opponent.hp;
				if(weapon.weapontype.equals("sword"))//sword attack
				{
					opponent.getSwordDamage(opponent.hp);
				}
				if(weapon.weapontype.equals("wand"))//fire wand attack
				{
					opponent.getFireDamage(opponent.hp);
				}
				if(weapon.weapontype.equals("ice wand"))//ice wand attack
				{
					opponent.getIceDamage(opponent.hp);
				}
			}
			else
			{
				if(weapon.weapontype.equals("sword"))//sword attack
				{
					opponent.getSwordDamage(weapon.hp);
				}
				if(weapon.weapontype.equals("wand"))//wand attack
				{
					opponent.getFireDamage(weapon.hp);
				}
				if(weapon.weapontype.equals("ice wand"))//ice wand attack
				{
					opponent.getIceDamage(weapon.hp);
				}
				weapon.hp=0;
			}
		}
		else if(weapon.hp==0||weapon==null)
		{
			if(this.hp>opponent.hp)
			{
				this.hp-=opponent.hp;
				opponent.hp=0;
			}
			else
			{
				//game over!!
			}
		}
	}
	public void pickUpWeapon(Weapon newWeapon){
		if(weapon.hp<newWeapon.hp) weapon=newWeapon;
	}
	
	public void ability() {
		//default Do nothing~!
	}
	
}
