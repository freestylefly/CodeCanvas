package service;

import java.util.List;

import entity.Master;


public interface MasterService {
	//查询所有主人信息
	public List<Master> getAllMaster();
	//添加主人信息
	public boolean addMaster(Master master);
}
