package mgr;

import java.util.List;
import java.util.Scanner;

import entity.Master;
import entity.Pet;
import service.MasterService;
import service.PetService;
import service.impl.MasterServiceImpl;
import service.impl.PetServiceImpl;

/**
 * 宠物管理类
 * 
 * @author Administrator
 *
 */
public class PetMgr {
	Scanner input = new Scanner(System.in);
	PetService petService = new PetServiceImpl();
	MasterService masterService = new MasterServiceImpl();
	Pet pet = null;

	/**
	 * 主菜单
	 */
	public void menu() {
		boolean flag = true;
		do {
			System.out.println("***************欢迎进入宠物管理系统***************");
			System.out.println("1.查询宠物列表");
			System.out.println("2.购买宠物");
			System.out.println("3.删除宠物信息");
			System.out.println("4.修改宠物信息");
			System.out.println("5.查看所有主人对应的宠物列表");
			System.out.println("6.注册商家");
			System.out.println("7.退出系统");
			System.out.println("************************************************");
			System.out.print("请选择：");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println(">>>>>>查询宠物列表>>>>>>");
				showPetList();
				break;
			case 2:
				System.out.println(">>>>>>购买宠物>>>>>>");
				buyPet();
				break;
			case 3:
				System.out.println(">>>>>>删除宠物信息>>>>>>");
				break;
			case 4:
				System.out.println(">>>>>>修改宠物信息>>>>>>");
				break;
			case 5:
				System.out.println(">>>>>>查看所有主人对应的宠物列表>>>>>>");
				showPetAndMaster();
				break;
			case 6:
				System.out.println(">>>>>>注册商家>>>>>>");
				break;
			case 7:
				flag = false;
				break;
			}
		} while (flag);
	}

	/**
	 * 查询宠物列表
	 */
	public void showPetList() {
		List<Pet> list = petService.getAllPet();
		System.out.println("编号 \t姓名\t健康值\t亲密度\t品种");
		for (int i = 0; i < list.size(); i++) {
			pet = list.get(i);
			System.out.println(pet);
		}
		System.out.println();
	}

	/**
	 * 购买宠物
	 */
	public void buyPet() {
		pet = new Pet();
		System.out.println("狗狗供应商信息>>>>>>>>>>");
		List<Master> listMaster = masterService.getAllMaster();
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			System.out.println(master);
		}
		System.out.print("请选择供应商编号：");
		int id = input.nextInt();
		int count=0;
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			if (id == master.getId()) {
				pet.setMasterid(id);
				System.out.print("请输入姓名：");
				pet.setName(input.next());
				System.out.print("请输入健康值：");
				pet.setHealth(input.nextInt());
				System.out.print("请输入亲密度：");
				pet.setLove(input.nextInt());
				System.out.print("请输入亲品种：");
				pet.setStrain(input.next());
				boolean isSuccess = petService.register(pet);
				if (isSuccess) {
					System.out.println("购买成功1");
				} else {
					System.out.println("购买失败1");
				}
			} else {
				count++;
			}
			if(count==4) {
				System.out.println("对不起，没有该供应商！");
			}
		}
		                       
		System.out.println();
	}

	/**
	 * 删除宠物信息
	 */
	public void deletePet() {
		
	}
	
	
	/**
	 * 查看所有主人对象的宠物；列表
	 */
	public void showPetAndMaster() {
		List<Master> listMaster  = masterService.getAllMaster();
		System.out.println("供应商id\t供应商姓名\t宠物名字\t宠物品种");
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			List<Pet> listPet = master.getListPet();
			for (int j = 0; j < listPet.size(); j++) {
				pet =listPet.get(j);
				System.out.println(master.getId()+"\t"+master.getName()+"\t"+pet.getName()+"\t"+pet.getStrain());
			}
		}
		System.out.println();
	}
	
}
