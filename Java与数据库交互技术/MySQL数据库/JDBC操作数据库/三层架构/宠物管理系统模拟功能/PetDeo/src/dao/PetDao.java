package dao;

import java.util.List;

import entity.Pet;

/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface PetDao {
	
	/**
	 * ��ѯ���г����б�
	 * @return
	 */
	public List<Pet> findaLLPet();
	
	/**
	 * ���ݳ���id�������Ϣ
	 */
	public List<Pet> findAllPetByMasterId(int masterid);
	
	/**
	 * ���ݱ�Ų�ѯ�����б�
	 * @param id
	 * @return
	 */
	public Pet findAllPetById(int id);
	
	/**
	 * ��������
	 * @param pet
	 * @return
	 */
	public int addPet(Pet pet);
}
