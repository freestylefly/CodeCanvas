package dao;
/**
 * 对用户操作的接口
 * @author Administrator
 *
 */
public interface UsersDao {
	//登录
	public Object[] login(String username,String password);
	//注册
	public boolean registr(String username,String password);
}
