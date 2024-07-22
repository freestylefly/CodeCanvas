package service.impl;

import java.util.List;

import dao.PetDao;
import dao.impl.PetDaoImpl;
import entity.Pet;
import service.PetService;

/**
 * ҵ���߼��� ʵ����
 * @author Administrator
 *
 */
public class PetServiceImpl implements PetService{
	PetDao petDao = new PetDaoImpl();
	
	//��ѯ���г�����Ϣ
	@Override
	public List<Pet> getAllPet() {
		return petDao.findaLLPet();
	}
	//��ѯָ��id������Ϣ
	@Override
	public Pet getPetById(int id) {
		return petDao.findAllPetById(id);
	}
	//ע�ᣨ���ӳ��
	@Override
	public boolean register(Pet pet) {
		int result = petDao.addPet(pet);
		if(result==-1) {
			return false;
		}else {
			return true;
		}
	}
}
