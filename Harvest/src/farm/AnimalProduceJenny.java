package farm;

public class AnimalProduceJenny {
	
	private String produce;
	private String imageSrc;
	private int rate;

	public AnimalProduceJenny(String produce, int productionRate, String src) {
		this.produce = produce;
		imageSrc = src;
		rate = productionRate;
	}
	
	public String getSrc() {
		return imageSrc;
	}
}
