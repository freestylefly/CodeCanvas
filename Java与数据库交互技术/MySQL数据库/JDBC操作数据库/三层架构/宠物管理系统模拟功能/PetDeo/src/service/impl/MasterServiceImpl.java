package service.impl;

import java.util.List;

import dao.MasterDao;
import dao.impl.MasterDaoImpl;
import entity.Master;
import service.MasterService;

public class MasterServiceImpl implements MasterService{
	MasterDao masterDao = new MasterDaoImpl();
	@Override
	public List<Master> getAllMaster() {
		
		List<Master> listMaster = masterDao.findallMaster();
		
		return listMaster;
	}

	@Override
	public boolean addMaster(Master master) {
		int result=masterDao.addMaster(master);
		if(result!=-1) {
			System.out.println("增加成功！");
			return true;
		}
		return false;
	}

}
