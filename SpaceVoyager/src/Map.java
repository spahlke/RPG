import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map extends BasicGameState{
	
	Image background;
	Animation north;
	Animation east;
	Animation south;
	Animation west;
	
	public Map(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		background = new Image("resources/Gameplay-Space.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		g.drawRect(1, 439, 40, 40);
	}

	@Override
	public void update(GameContainer window, StateBasedGame state, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		Input input = window.getInput();
		
		if((mouseX > 0 && mouseX < 40) && (mouseY < 40  && mouseY > 0)){
			if(input.isMouseButtonDown(0)){
				state.enterState(0);
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
