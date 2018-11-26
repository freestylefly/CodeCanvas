package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.MasterDao;
import entity.Master;

public class MasterDaoImpl extends BaseDao implements MasterDao{
	PetDaoImpl petDaoImpl = new PetDaoImpl();
	@Override
	public List<Master> findallMaster() {
		List<Master> listMaster = null;
		String sql ="SELECT id,`name`,`password`,money FROM `master`";
		Object[] params = null;
		rs=this.executQuery(sql, params);
		if(null !=rs) {
			listMaster=new ArrayList<Master>();
			try {
				while(rs.next()) {
					Master master = new Master();
					int masterid= rs.getInt("id");
					master.setId(masterid);
					master.setName(rs.getString("name"));
					master.setPassword(rs.getString("password"));
					master.setMoney(rs.getInt("money"));
					master.setListPet(petDaoImpl.findAllPetByMasterId(masterid));
					listMaster.add(master);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
		}
		return listMaster;
	}
	@Override
	public int addMaster(Master master) {
		int result = -1;
		String sql = "INSERT INTO `master` (id,`name`,`password`,money) VALUES (DEFAULT,?,?,?)";
		Object[] params= {master.getName(),master.getPassword(),master.getMoney()};
		result=this.exxcutUpdate(sql, params);
		return result;
	}
	

}
