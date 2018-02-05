package game.farm;

public class AnimalJenny {

	private String name;
	private String src;
	private AnimalProduceJenny produce;
	private String[] names;
	private int index;

	public AnimalJenny(String name) {
		this.name = name;
		src = "resources/" + name;
		
		String[] temp = {"brownChicken", "whiteChicken", "blackChicken", "sheep", "cow", "pig"};
		names = temp;
		
		for(int i = 0; i < names.length; i++) {
			if(name.equals(names[i]))
				index = i;
		}
		this.produce = new AnimalProduceJenny(index);
	}

	public String getName() {
		return name;
	}

	public String getSrc() {
		return src;
	}
	
	public AnimalProduceJenny getProduce() {
		return produce;
	}
}
