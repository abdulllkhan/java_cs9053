package fruit;


public class Fruit {

	private static int next_id;
	private int id;
	private String color;
	private Boolean rotten;

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects

		Fruit testFruit = new Fruit("red", false);
		testFruit.toString();
		System.out.println(testFruit.toString());
	}

	public Fruit(){
		Fruit.next_id++;
		this.id = Fruit.next_id;
	}

	public Fruit(String color, Boolean rotten){
		this();
		this.color = color;
		this.rotten = rotten;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public Boolean isRotten(){
		return this.rotten;
	}

	public void setRotten(Boolean rotten){
		this.rotten = rotten;
	}

	public int getId(){
		return this.id;
	}

	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();
		sb.append("This fruit has id: " + this.id + " and is of " + this.color + " color. This fruit is ");
		if(this.rotten){
			sb.append("rotten.");
		} else {
			sb.append("fresh.");
		}
		return sb.toString();

	}

	@Override
	public boolean equals(Object fruiObject){
		if(this.color != ((Fruit) fruiObject).getColor()
				|| this.rotten != ((Fruit) fruiObject).isRotten()){
			return false;
		}
		return true;
	}

}
