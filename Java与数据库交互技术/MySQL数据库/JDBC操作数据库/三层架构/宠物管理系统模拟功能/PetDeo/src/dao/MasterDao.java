package dao;

import java.util.List;

import entity.Master;

public interface MasterDao {
	//��ѯ����������Ϣ
	public List<Master> findallMaster();
	//�������
	public int addMaster(Master master);
	
}
