package mainMenu;

import java.util.List;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ChooseGenderScreen extends ClickableScreen implements Runnable {

//	CustomImageButton
	private Graphic girl;
	private Graphic boy;
	private Graphic back;

	public ChooseGenderScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	
//	public void resize(int w, int h){
//		back.loadImages("resources/background.png", w, h);
//		back.update();
//		girl.setX(w/2-girl.getWidth());
//		girl.setY(h/2-girl.getHeight());
//		boy.setX(w/2+boy.getWidth());
//		boy.setY(h/2+boy.getHeight());
//		super.resize(w, h);
//	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0,0,getWidth(),getHeight,"resources/background.png");
		viewObjects.add(back);
		girl = new Graphic(350,350, 150,150,"resources/girlButton.png");
		viewObjects.add(girl);
		boy = new Graphic(550,350, 150,150,"resources/boyButton.png");
		viewObjects.add(boy);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}

