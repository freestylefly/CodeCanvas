package dao;

import java.util.List;

import entity.Pet;

/**
 * 接口
 * @author Administrator
 *
 */
public interface PetDao {
	
	/**
	 * 查询所有宠物列表
	 * @return
	 */
	public List<Pet> findaLLPet();
	
	/**
	 * 根据编号查询宠物列表
	 * @param id
	 * @return
	 */
	public Pet findAllPetById(int id);
	
	/**
	 * 新增宠物
	 * @param pet
	 * @return
	 */
	public int addPet(Pet pet);
}
