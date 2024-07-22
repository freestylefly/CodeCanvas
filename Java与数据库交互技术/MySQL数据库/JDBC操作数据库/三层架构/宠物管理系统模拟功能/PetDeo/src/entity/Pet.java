package entity;

public class Pet {
	private int id;
	private String name;
	private int health;
	private int love;
	private String strain;
	private int masterid;
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
	public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}
	public Pet(int id, String name, int health, int love, String strain) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}
	@Override
	public String toString() {
		return this.getId()+"\t"+this.getName()+"\t"+this.getHealth()+"\t"+this.getLove()+"\t"
	+this.getStrain();
	}
	
}
