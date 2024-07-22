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
 * ���������
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
	 * ���˵�
	 */
	public void menu() {
		boolean flag = true;
		do {
			System.out.println("***************��ӭ����������ϵͳ***************");
			System.out.println("1.��ѯ�����б�");
			System.out.println("2.�������");
			System.out.println("3.ɾ��������Ϣ");
			System.out.println("4.�޸ĳ�����Ϣ");
			System.out.println("5.�鿴�������˶�Ӧ�ĳ����б�");
			System.out.println("6.ע���̼�");
			System.out.println("7.�˳�ϵͳ");
			System.out.println("************************************************");
			System.out.print("��ѡ��");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println(">>>>>>��ѯ�����б�>>>>>>");
				showPetList();
				break;
			case 2:
				System.out.println(">>>>>>�������>>>>>>");
				buyPet();
				break;
			case 3:
				System.out.println(">>>>>>ɾ��������Ϣ>>>>>>");
				break;
			case 4:
				System.out.println(">>>>>>�޸ĳ�����Ϣ>>>>>>");
				break;
			case 5:
				System.out.println(">>>>>>�鿴�������˶�Ӧ�ĳ����б�>>>>>>");
				showPetAndMaster();
				break;
			case 6:
				System.out.println(">>>>>>ע���̼�>>>>>>");
				break;
			case 7:
				flag = false;
				break;
			}
		} while (flag);
	}

	/**
	 * ��ѯ�����б�
	 */
	public void showPetList() {
		List<Pet> list = petService.getAllPet();
		System.out.println("��� \t����\t����ֵ\t���ܶ�\tƷ��");
		for (int i = 0; i < list.size(); i++) {
			pet = list.get(i);
			System.out.println(pet);
		}
		System.out.println();
	}

	/**
	 * �������
	 */
	public void buyPet() {
		pet = new Pet();
		System.out.println("������Ӧ����Ϣ>>>>>>>>>>");
		List<Master> listMaster = masterService.getAllMaster();
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			System.out.println(master);
		}
		System.out.print("��ѡ��Ӧ�̱�ţ�");
		int id = input.nextInt();
		int count=0;
		for (int i = 0; i < listMaster.size(); i++) {
			Master master = listMaster.get(i);
			if (id == master.getId()) {
				pet.setMasterid(id);
				System.out.print("������������");
				pet.setName(input.next());
				System.out.print("�����뽡��ֵ��");
				pet.setHealth(input.nextInt());
				System.out.print("���������ܶȣ�");
				pet.setLove(input.nextInt());
				System.out.print("��������Ʒ�֣�");
				pet.setStrain(input.next());
				boolean isSuccess = petService.register(pet);
				if (isSuccess) {
					System.out.println("����ɹ�1");
				} else {
					System.out.println("����ʧ��1");
				}
			} else {
				count++;
			}
			if(count==4) {
				System.out.println("�Բ���û�иù�Ӧ�̣�");
			}
		}
		                       
		System.out.println();
	}

	/**
	 * ɾ��������Ϣ
	 */
	public void deletePet() {
		
	}
	
	
	/**
	 * �鿴�������˶���ĳ���б�
	 */
	public void showPetAndMaster() {
		List<Master> listMaster  = masterService.getAllMaster();
		System.out.println("��Ӧ��id\t��Ӧ������\t��������\t����Ʒ��");
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
