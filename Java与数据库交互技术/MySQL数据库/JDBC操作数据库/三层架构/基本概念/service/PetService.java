package service;

import java.util.List;

import entity.Pet;

/**
 * ҵ���߼���
 * @author Administrator
 *
 */
public interface PetService {
	//��ѯ���г�����Ϣ
	public List<Pet> getAllPet();
	//��ѯָ��id������Ϣ
	public Pet getPetById(int id);
	//ע��
	public boolean register(Pet pet);
}
