package test;

import java.util.Scanner;

import entity.Pet;
import service.PetService;
import service.impl.PetServiceImpl;

/**
 * ��ʾ��
 * ������
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PetService petService= new PetServiceImpl();
		Pet pet =null;
		
		/*//���Բ�ѯ���г�����Ϣ
		List<Pet> list =petService.getAllPet();
		System.out.println("��� \t����\t����ֵ\t���ܶ�\tƷ��");
		for (int i = 0; i < list.size(); i++) {
			pet=list.get(i);
			System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());
		}
		*/
		
		
		/*//���Բ�ѯָ��id������Ϣ
		System.out.print("��������Ҫ���ҵĳ����id��");
		int id =input.nextInt();
		pet=petService.getPetById(id);
		System.out.println("��� \t����\t����ֵ\t���ܶ�\tƷ��");
		System.out.println(pet.getId()+"\t"+pet.getName()+"\t"+pet.getHealth()+"\t"+pet.getLove()+"\t"+pet.getStrain());*/
		
		
		//ע�����
		pet = new Pet();
		System.out.print("������������");
		pet.setName(input.next());
		System.out.print("�����뽡��ֵ��");
		pet.setHealth(input.nextInt());
		System.out.print("���������ܶȣ�");
		pet.setLove(input.nextInt());
		System.out.print("��������Ʒ�֣�");
		pet.setStrain(input.next());
		boolean isSuccess=petService.register(pet);
		if(isSuccess) {
			System.out.println("ע��ɹ�1");
		}else {
			System.out.println("ע��ʧ��1");
		}
		
		
	}
}
