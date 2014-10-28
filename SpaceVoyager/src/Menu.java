import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{
	
	public String mouse = "";
	Player p;
	Image spaceship;
	int shipX = 100;
	int shipY = 150;
	Animation north;
	Animation east;
	Animation south;
	Animation west;
	int[] duration = {200, 200};
	Controller c;
	Enemy e;
	Image eShip;
	
	public Menu(int state){
		
	}

	@Override
	public void init(GameContainer window, StateBasedGame state)
			throws SlickException {
		spaceship = new Image("resources/spaceshipFinal.png");
		spaceship = spaceship.getScaledCopy((float).10);
		eShip = new Image("resources/spaceship.png");
		eShip = eShip.getScaledCopy((float).25);
		p = new Player("Hero", spaceship, shipX, shipY, 100, 10, 10, 1, 0);
		e = new Enemy("Starship", eShip, 100, 100, 100, 1, 1, true, 10);
		c = new Controller(window, p);
	}

	@Override
	public void render(GameContainer window, StateBasedGame state, Graphics g)
			throws SlickException {
		Image menuBackground = new Image("resources/Menu.png");
		g.drawImage(menuBackground, 0, 0);
		g.drawString(mouse, 100, 100);
		g.drawRect(230, 65, 150, 40);
		g.drawImage(p.sprite, p.xCoord, p.yCoord);
		g.drawImage(e.sprite, 100, 100);
	}

	@Override
	public void update(GameContainer window, StateBasedGame state, int arg2)
			throws SlickException {
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		mouse = "x: " + mouseX + "\ny: " + mouseY;
		Input input = window.getInput();
//		if(input.isKeyDown(Input.KEY_W)){
//			shipY -= 5;
//		}if(input.isKeyDown(Input.KEY_A)){
//			shipX -= 5;
//		}if(input.isKeyDown(Input.KEY_S)){
//			shipY += 5;
//		}if(input.isKeyDown(Input.KEY_D)){
//			shipX += 5;
//		}
		
		c.move();
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
