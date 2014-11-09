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
	Image natune;
	Image duruta;
	Image zutania;
	Image space;
	String pCoords;
	String currentWorld;
	Image unseenShip;
	String fight;
	Image spirit;
	Image tempSpirit;
	String questIntro;
	
	
	
	public Map(int s){
		this.s = s;
	}

	@Override
	public void init(GameContainer window, StateBasedGame state)
			throws SlickException {
		// TODO Auto-generated method stub
		unseenShip = new Image("resources/nothing.png");
		spaceship = new Image("resources/spaceshipFinal.png");
		spaceship = spaceship.getScaledCopy((float).10);
		eShip = new Image("resources/spaceship.png");
		eShip = eShip.getScaledCopy((float).25);
		space = new Image("resources/Gameplay-Space.png");
		p = new Player("Hero", spaceship, 60, 350, 100, 10, 10, 1, 0);
		e = new Enemy("Starship", unseenShip, 120, 175, 100, 1, 1, true, 10);
		c = new Controller(window, p);
		natune = new Image("resources/natune.png");
		duruta = new Image("resources/duruta.png");
		zutania = new Image("resources/zutania.png");
		background = space;
		currentWorld = "space";
		fight = "";
		spirit = new Image("resources/spirit.png");
		questIntro = "";
		tempSpirit = spirit;
		
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
		g.drawString(pCoords, 50, 50);
		g.drawString(fight, 150, 175);
		g.drawImage(spirit, 300, 400);
		g.drawString(questIntro, 250, 350);
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
				background = space;
				currentWorld = "space";
				p.xCoord = 60;
				p.yCoord = 350;
				e.sprite = unseenShip;
				fight = "";
				questIntro = "";
				spirit = tempSpirit;
				state.enterState(0);
			}
		}
		if((p.xCoord > 330 && p.xCoord < 510) && (p.yCoord < 100 && p.yCoord > 5) && currentWorld.equalsIgnoreCase("space")){
			background = natune;
			e.sprite = unseenShip;
			currentWorld = "natune";
			fight = "";
			questIntro = "";
			spirit = unseenShip;
		}
		if((p.xCoord > 100 && p.xCoord < 210) && (p.yCoord < 100 && p.yCoord > 15) && currentWorld.equalsIgnoreCase("space")){
			background = duruta;
			e.sprite = unseenShip;
			currentWorld = "duruta";
			fight = "";
			questIntro = "";
			spirit = unseenShip;
		}
		if((p.xCoord > 385 && p.xCoord < 505) && (p.yCoord < 330 && p.yCoord > 225) && currentWorld.equalsIgnoreCase("space")){
			background = zutania;
			e.sprite = unseenShip;
			currentWorld = "zutania";
			fight = "";
			questIntro = "";
			spirit = unseenShip;
		}
		if((p.xCoord > 60 && p.xCoord < 145) && (p.yCoord < 200 && p.yCoord > 150) && currentWorld.equalsIgnoreCase("space")){
			e.sprite = eShip;
			fight = "Fights to be implemented in Phase 2";
		}
		if((p.xCoord > 230 && p.xCoord < 325) && (p.yCoord < 415 && p.yCoord > 360) && currentWorld.equalsIgnoreCase("space")){
			questIntro = "Quests to be implemented in Phase 2";
		}
		if((p.xCoord == 0) && (p.yCoord == 395) && !currentWorld.equalsIgnoreCase("space")){
			background = space;
			currentWorld = "space";
			spirit = tempSpirit;
			p.xCoord = 60;
			p.yCoord = 350;
		}
		c.move();
		pCoords = "x: " + p.xCoord + "\ny: " + p.yCoord;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
