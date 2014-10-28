import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map extends BasicGameState{
	
	Image background;
	Image spaceship;
	Image eShip;
	Player p;
	Enemy e;
	int state;
	Controller c;
	int s;
	public String mouse = "";
	
	
	public Map(int s){
		this.s = s;
	}

	@Override
	public void init(GameContainer window, StateBasedGame state)
			throws SlickException {
		// TODO Auto-generated method stub
		
		if(s == 1){
			background = new Image("resources/Gameplay-Space.png");
		}
		else if(s == 2){
			background = new Image("resources/natune.png");
		}else if(s == 3){
			background = new Image("resources/duruta.png");
		}else if(s == 4){
			background = new Image("resources/zutania.png");
		}
		spaceship = new Image("resources/spaceshipFinal.png");
		spaceship = spaceship.getScaledCopy((float).10);
		eShip = new Image("resources/spaceship.png");
		eShip = eShip.getScaledCopy((float).25);
//		background = new Image("resources/Gameplay-Space.png");
		p = new Player("Hero", spaceship, 100, 100, 100, 10, 10, 1, 0);
		e = new Enemy("Starship", eShip, 100, 100, 100, 1, 1, true, 10);
		c = new Controller(window, p);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		g.drawRect(1, 439, 40, 40);
		g.drawImage(p.sprite, p.xCoord, p.yCoord);
		g.drawImage(e.sprite, e.xCoord, e.yCoord);
		g.drawString(mouse, 300, 300);
		g.drawRect(405, 20, 185, 185);
		
	}

	@Override
	public void update(GameContainer window, StateBasedGame state, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		//Controller c = new Controller(window);
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		mouse = "x: " + mouseX + "\ny: " + mouseY;
		Input input = window.getInput();
		
		if((mouseX > 0 && mouseX < 40) && (mouseY < 40  && mouseY > 0)){
			if(input.isMouseButtonDown(0)){
				state.enterState(0);
			}
		}
		if((p.xCoord > 405 && p.xCoord < 590) && (p.yCoord < 660 && p.yCoord > 485)){
			state.enterState(2);
		}
		c.move();
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
