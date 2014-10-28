import org.newdawn.slick.Image;



public class Player extends Character{

	public int level;
	public int experience;
	//public Item[] itemList;
	//public Quest[] questList;
	
	
	public Player(String name, Image sprite, int xCoord, int yCoord,
			int health, int attack, int defense, int level, int experience) {
		super(name, sprite, xCoord, yCoord, health, attack, defense);
		this.level = level;
		this.experience = experience;
		
	}
	
	public int getExp(){
		return experience;
	}
	
	public int getLvl(){
		return level;
	}
	
	public void addExp(Player p, int amount){
		p.experience += amount;
		if(p.experience >= 100){
			levelUp(p);
		}
	}
	
	public void levelUp(Player p){
		p.level += 1;
		p.attack += 1;
		p.defense += 1;
		p.health += 10;
	}
	
	public void updateQuest(Player p){
		
	}
	
	public void updateItems(Player p){
		
	}
}
