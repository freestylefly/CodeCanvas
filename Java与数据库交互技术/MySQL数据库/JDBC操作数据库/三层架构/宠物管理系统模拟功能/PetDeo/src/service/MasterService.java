package service;

import java.util.List;

import entity.Master;


public interface MasterService {
	//��ѯ����������Ϣ
	public List<Master> getAllMaster();
	//���������Ϣ
	public boolean addMaster(Master master);
}
