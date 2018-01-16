package game;

public class AnimalJenny {

	private String name;
	private String src;
	private AnimalProduceJenny produce;

	public AnimalJenny(String name, String src, String produce) {
		this.name = name;
		this.src = src;
		this.produce = new AnimalProduceJenny(produce);
	}

	public String getName() {
		return name;
	}

	public String getSrc() {
		return src;
	}
	
	public String getProduce() {
		return src;
	}
}
