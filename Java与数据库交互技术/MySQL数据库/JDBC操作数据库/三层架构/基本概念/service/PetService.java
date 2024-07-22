package service;

import java.util.List;

import entity.Pet;

/**
 * 业务逻辑类
 * @author Administrator
 *
 */
public interface PetService {
	//查询所有宠物信息
	public List<Pet> getAllPet();
	//查询指定id宠物信息
	public Pet getPetById(int id);
	//注册
	public boolean register(Pet pet);
}
