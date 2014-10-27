import java.applet.Applet;
import java.awt.Dimension;
import javax.swing.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class SpaceVoyager extends StateBasedGame{

	public static final String name = "Space Voyager";
	public static final int menu = 0;
	public static final int worldMap = 1;
	
	public SpaceVoyager(String name) {
		super(name);
		this.addState(new Menu(menu));
		this.addState(new Map(worldMap));

	}
	
	public static void main(String[] args){
		try{
			AppGameContainer window = new AppGameContainer(new SpaceVoyager(name));
			window.setDisplayMode(640, 480, false);
			window.setTargetFrameRate(60);
			window.setVSync(true);
			window.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.getState(menu).init(arg0, this);
		this.getState(worldMap).init(arg0, this);
		this.enterState(menu);
	}
	

}
