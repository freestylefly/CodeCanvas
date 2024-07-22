package test;

import java.util.List;
import java.util.Scanner;

import entity.Master;
import entity.Pet;
import service.MasterService;
import service.PetService;
import service.impl.MasterServiceImpl;
import service.impl.PetServiceImpl;

/**
 * 表示层
 * 测试类
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PetService petService= new PetServiceImpl();
		Pet pet =null;
		
		/*//测试查询所有宠物信息
		List<Pet> list =petService.getAllPet();
		System.out.println("编号 \t姓名\t健康值\t亲密度\t品种");
		for (int i = 0; i < list.size(); i++) {
			pet=list.get(i);
			System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());
		}
		*/
		
		
		/*//测试查询指定id宠物信息
		System.out.print("请输入您要查找的宠物的id：");
		int id =input.nextInt();
		pet=petService.getPetById(id);
		System.out.println("编号 \t姓名\t健康值\t亲密度\t品种");
		System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());*/
		
		
	/*	//注册测试
		pet = new Pet();
		System.out.print("请输入姓名：");
		pet.setName(input.next());
		System.out.print("请输入健康值：");
		pet.setHealth(input.nextInt());
		System.out.print("请输入亲密度：");
		pet.setLove(input.nextInt());
		System.out.print("请输入亲品种：");
		pet.setStrain(input.next());
		boolean isSuccess=petService.register(pet);
		if(isSuccess) {
			System.out.println("注册成功1");
		}else {
			System.out.println("注册失败1");
		}*/
		
		
	/*	//查询所有主人信息，包括主人所有的宠物信息
		MasterService masterService = new MasterServiceImpl();
		List<Master> listMaster  = masterService.getAllMaster();
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			List<Pet> listPet = master.getListPet();
			for (int j = 0; j < listPet.size(); j++) {
				pet =listPet.get(j);
				System.out.println(master.getId()+"\t"+master.getName()+"\t"+pet.getName()+"\t"+pet.getStrain());
			}
		}*/
		
		
		//添加主人
		MasterService masterService = new MasterServiceImpl();
		Master master  = new Master();
		System.out.print("请输入姓名：");
		master.setName(input.next());
		System.out.print("请输入密码：");
		master.setPassword(input.next());
		System.out.print("请输入金额：");
		master.setMoney(input.nextInt());
		masterService.addMaster(master);
	}
}
