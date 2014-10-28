import org.newdawn.slick.Image;


public class Character {

	
	public String name;
	public Image sprite;
	public int xCoord;
	public int yCoord;
	public int health;
	public int attack;
	public int defense;
	
	
	public Character(String name, Image sprite, int xCoord, int yCoord,
			int health, int attack, int defense) {
		super();
		this.name = name;
		this.sprite = sprite;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
	public int getHealth(){
		return health;
	}
	public int getAttack(){
		return attack;
	}
	public int getDefense(){
		return defense;
	}
	public int getXCoord(){
		return xCoord;
	}
	public int getYCoord(){
		return yCoord;
	}
	
}
