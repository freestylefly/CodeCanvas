package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.PetDao;
import entity.Pet;

/**
 * 实现类
 * @author Administrator
 *
 */
public class PetDaoImpl extends BaseDao implements PetDao{
	
	/**
	 * 查询所有宠物
	 */
	@Override
	public List<Pet> findaLLPet() {
		List<Pet> list =null;
		try {
			String sql = "SELECT id,NAME,health,love,strain FROM pet";
			Object[] params=null;
			//调用方法
			rs=this.executQuery(sql, params);
			if(null!=rs) {
				list = new ArrayList<>();
				while(rs.next()) {
					Pet pet =new Pet();
					pet.setId(rs.getInt("id"));
					pet.setName(rs.getString("name"));
					pet.setHealth(rs.getInt("health"));
					pet.setLove(rs.getInt("love"));
					pet.setStrain(rs.getString("strain"));
					list.add(pet);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	/**
	 * 根据id查宠物信息
	 */
	@Override
	public Pet findAllPetById(int id) {
		Pet pet=null;
		try {
			String sql = "SELECT id,NAME,health,love,strain FROM pet WHERE id=?";
			Object[] params= {id};
			//调用方法
			rs=this.executQuery(sql, params);
			if(null!=rs) {
				while(rs.next()) {
					pet =new Pet();
					pet.setId(rs.getInt("id"));
					pet.setName(rs.getString("name"));
					pet.setHealth(rs.getInt("health"));
					pet.setLove(rs.getInt("love"));
					pet.setStrain(rs.getString("strain"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return pet;
	}

	@Override
	public int addPet(Pet pet) {
		String sql ="INSERT INTO pet (id,NAME,health,love,strain) VALUES (DEFAULT,?,?,?,?)";
		Object[] params= {pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
		int result =-1;
		try {
			result=this.exxcutUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
