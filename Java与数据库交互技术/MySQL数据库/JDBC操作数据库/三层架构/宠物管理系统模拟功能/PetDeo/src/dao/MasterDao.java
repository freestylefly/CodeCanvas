package dao;

import java.util.List;

import entity.Master;

public interface MasterDao {
	//查询所有主人信息
	public List<Master> findallMaster();
	//添加主人
	public int addMaster(Master master);
	
}
