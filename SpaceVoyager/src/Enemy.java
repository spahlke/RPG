import org.newdawn.slick.Image;


public class Enemy extends Character{

	public boolean isVisible;
	public int expReward;
	
	public Enemy(String name, Image sprite, int xCoord, int yCoord, int health,
			int attack, int defense, boolean isVisible, int expReward) {
		super(name, sprite, xCoord, yCoord, health, attack, defense);
		this.isVisible = isVisible;
		this.expReward = expReward;
	}
	
	public void makeVisible(Enemy e){
		
	}
}
