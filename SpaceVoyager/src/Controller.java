import org.newdawn.slick.*;


public class Controller {

	Input input;
	Player player;
	
	public Controller(GameContainer window, Player player) {
		input = window.getInput();
		this.player = player;
	}
	
	public void move(){
		if(input.isKeyDown(Input.KEY_W)){
			player.yCoord -= 5;
		}if(input.isKeyDown(Input.KEY_A)){
			player.xCoord -= 5;
		}if(input.isKeyDown(Input.KEY_S)){
			player.yCoord += 5;
		}if(input.isKeyDown(Input.KEY_D)){
			player.xCoord += 5;
		}
	}
	
	public void collision(){
		
	}
	

}
