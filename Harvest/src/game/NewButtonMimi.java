package game;

import guiTeacher.components.*;

public class NewButtonMimi extends Button{

	public NewButtonMimi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	
	//choose gender screen goes first (before starting a thread for new game)
	
	public static void main(String[] args) {
		NewButtonMimi n = new NewButtonMimi(380,350, 150,150, "new", new Action() {
			
			@Override
			public void act() {
				
			}
		});
		Thread runner = new Thread(n);
		runner.start();
	}
	
	public void initScreen() {
		FarmScreenAll f = new FarmScreenAll(getWidth(), getHeight());
		setScreen(f);
	}
}
