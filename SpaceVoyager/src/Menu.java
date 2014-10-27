import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{
	
	public String mouse = "";
	Image spaceship;
	int shipX = 100;
	int shipY = 150;
	Animation north;
	Animation east;
	Animation south;
	Animation west;
	int[] duration = {200, 200};
	
	public Menu(int state){
		
	}

	@Override
	public void init(GameContainer window, StateBasedGame state)
			throws SlickException {
		spaceship = new Image("resources/spaceshipFinal.png");
		spaceship = spaceship.getScaledCopy((float).20);
		Image[] north;
	}

	@Override
	public void render(GameContainer window, StateBasedGame state, Graphics g)
			throws SlickException {
		Image menuBackground = new Image("resources/Menu.png");
		g.drawImage(menuBackground, 0, 0);
		g.drawString(mouse, 100, 100);
		g.drawRect(230, 65, 150, 40);
		g.drawImage(spaceship, shipX, shipY);
	}

	@Override
	public void update(GameContainer window, StateBasedGame state, int arg2)
			throws SlickException {
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		mouse = "x: " + mouseX + "\ny: " + mouseY;
		Input input = window.getInput();
		if(input.isKeyDown(Input.KEY_W)){
			shipY -= 5;
		}if(input.isKeyDown(Input.KEY_A)){
			shipX -= 5;
		}if(input.isKeyDown(Input.KEY_S)){
			shipY += 5;
		}if(input.isKeyDown(Input.KEY_D)){
			shipX += 5;
		}
		
		//select new game
		if((mouseX > 230 && mouseX < 380) && (mouseY < 410  && mouseY > 370)){
			if(input.isMouseButtonDown(0)){
				state.enterState(1);
			}
		}
		
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
