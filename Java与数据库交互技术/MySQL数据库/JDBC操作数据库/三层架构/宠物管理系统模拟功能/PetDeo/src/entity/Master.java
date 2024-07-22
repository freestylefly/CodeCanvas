package entity;

import java.util.List;

/**
 * ������
 * @author Administrator
 *
 */
public class Master {
	private int id;
	private String name;
	private String password;
	private int money;
	
	//���һ�����Ｏ�����ԣ�һ�����˿����ж�����
	private List<Pet> listPet;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Pet> getListPet() {
		return listPet;
	}

	public void setListPet(List<Pet> listPet) {
		this.listPet = listPet;
	}

	public Master(int id, String name, String password, int money, List<Pet> listPet) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
		this.listPet = listPet;
	}

	public Master() {
		super();
	}

	@Override
	public String toString() {
		return this.getId()+"\t"+this.getName()+"\t"+this.getMoney();
	}
	
}
