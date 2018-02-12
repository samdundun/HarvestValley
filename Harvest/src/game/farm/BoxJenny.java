package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import game.market.Inventory;
import game.market.InventoryScreen;
import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class BoxJenny extends CustomImageButton implements Clickable{

	private int imageIndx;
	private int index;
	private int length;
	private int stage;
	private int time;
	private int currentTime;
	private int x;
	private int y;

	public BoxJenny(int x, int y, String imageAddress, Action action, List<Visible> viewObjects, int i) {
		super(x, y, new Graphic(0,0,imageAddress).getWidth(), new Graphic(0,0,imageAddress).getHeight(), new DrawInstructions() {
			Graphic image = new Graphic(0,0,imageAddress);

			public void draw(Graphics2D g, boolean highlight) {
				g.drawImage(image.getImage(), 0, 0, null);
				if(highlight) {
					g.setColor(new Color(0,0,0,20));
					g.fillRect(0, 0, image.getWidth(), image.getHeight());
				}
			}
		}, new Action() {
			public void act() {
				FarmScreenAll.first.setX(x + 100);
				FarmScreenAll.first.setY(y - 100);
				FarmScreenAll.first.setVisible(true);
				FarmScreenAll.first.update();
				FarmScreenAll.first.setIndex(i);
				FarmScreenAll.disableButton(false);
			}
		});
		index = i;
		this.x = x;
		this.y = y;
	}

	public void changeAction() {
		updateImg(index, SelectionPaneJane.getSrc());
		this.setAction(new Action() {

			public void act() {
				BoxJenny animal = FarmScreenAll.animalBox.get(index);
				String name = SelectionPaneJane.items[animal.imageIndx + 6].getName().toLowerCase();
				System.out.println(name);
				int dayLeft = animal.getLength() - animal.getCurrentTime();
				FarmScreenAll.animalPane.setX(animal.getX());
				FarmScreenAll.animalPane.setY(animal.getY());
				FarmScreenAll.animalPane.setSrc(name);
				FarmScreenAll.animalPane.updateImg(FarmScreenAll.getView());
				FarmScreenAll.animalPane.setVisible(true);
				if(animal.getLength() != animal.getCurrentTime()) {
					FarmScreenAll.animalPane.getLabel().setText(dayLeft + " days until harvest");
					FarmScreenAll.animalPane.getHarvest().setAction(new Action() {
						public void act() {
							FarmScreenAll.animalPane.getLabel().setText("Cannot harvest yet");
						}
					});
				}
				else {
					FarmScreenAll.animalPane.getLabel().setText("Ready to harvest");
					FarmScreenAll.animalPane.getHarvest().setAction(new Action() {
						public void act() {
							FarmScreenAll.animalPane.setVisible(false);
							FarmScreenAll.animalPane.getImg().setVisible(false);
							FarmScreenAll.disableButton(true);
						}
					} );
				}
				FarmScreenAll.animalPane.getItem().setText(name);
				FarmScreenAll.animalPane.update();
				FarmScreenAll.disableButton(false);

			}
		});
	}

	private void updateImg(int idx, String src) {
		FarmScreenAll.getAnimalBox().remove(idx);
		BoxJenny animal = new BoxJenny(x, y, src, null, FarmScreenAll.getView(), idx);
		FarmScreenAll.getAnimalBox().add(idx, animal);
		FarmScreenAll.getView().add(animal);
	}

	public void printSelected(int x) {
		System.out.println(x);
	}

	public int getIndex() {
		return index;
	}
	public void setColor(Color red) {
		this.setForeground(red);

	}

	public void setTime(int time2) {
		time = time2;

	}

	public int getLength() {
		return length;
	}

	public int getStage() {
		// TODO Auto-generated method stub
		return stage;
	}

	public int getCurrentTime() {
		// TODO Auto-generated method stub
		return currentTime;
	}


}
