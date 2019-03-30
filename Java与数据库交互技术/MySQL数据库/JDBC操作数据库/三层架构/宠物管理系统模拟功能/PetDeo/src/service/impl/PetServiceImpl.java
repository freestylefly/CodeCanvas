package service.impl;

import java.util.List;

import dao.PetDao;
import dao.impl.PetDaoImpl;
import entity.Pet;
import service.PetService;

/**
 * 业务逻辑类 实现类
 * @author Administrator
 *
 */
public class PetServiceImpl implements PetService{
	PetDao petDao = new PetDaoImpl();
	
	//查询所有宠物信息
	@Override
	public List<Pet> getAllPet() {
		return petDao.findaLLPet();
	}
	//查询指定id宠物信息
	@Override
	public Pet getPetById(int id) {
		return petDao.findAllPetById(id);
	}
	//注册（增加宠物）
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
