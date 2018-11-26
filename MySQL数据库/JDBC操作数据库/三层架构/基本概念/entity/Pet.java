package entity;

public class Pet {
	private int id;
	private String name;
	private int health;
	private int love;
	private String strain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	public Pet() {
		super();
	}
	public Pet(int id, String name, int health, int love, String strain) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}
	
}
