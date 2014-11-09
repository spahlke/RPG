import org.newdawn.slick.*;


public class Controller {

	Input input;
	Player player;
	
	public Controller(GameContainer window, Player player) {
		input = window.getInput();
		this.player = player;
	}
	
	public void move(){
		if(input.isKeyDown(Input.KEY_W) && player.yCoord > -10){
			player.yCoord -= 5;
		}if(input.isKeyDown(Input.KEY_A) && player.xCoord > 0){
			player.xCoord -= 5;
		}if(input.isKeyDown(Input.KEY_S) && player.yCoord < 395){
			player.yCoord += 5;
		}if(input.isKeyDown(Input.KEY_D) && player.xCoord < 495){
			player.xCoord += 5;
		}
	}
	
	public void collision(){
		
	}
	

}
