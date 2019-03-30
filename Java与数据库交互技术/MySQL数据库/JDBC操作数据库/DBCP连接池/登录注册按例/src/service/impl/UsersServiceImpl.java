package service.impl;

import dao.UsersDao;
import dao.impl.UsersDaoImpl;
import service.UsersService;

public class UsersServiceImpl implements UsersService{
	UsersDao usersDao = new UsersDaoImpl();
	@Override
	public boolean login(String username, String password) {
		Object[] result =usersDao.login(username, password);
		if(result.length ==0)
			return false;
		return true;
	}

	@Override
	public boolean register(String username, String password) {
		return usersDao.registr(username, password);
	}

}
