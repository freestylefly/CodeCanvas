package mgr;

import java.util.Scanner;

import service.UsersService;
import service.impl.UsersServiceImpl;

//用户管理类
public class UsersMgr {
	Scanner input = new Scanner(System.in);
	UsersService usersService = new UsersServiceImpl();
	private String username;
	private String password;

	/**
	 * 主菜单
	 */
	public void menu() {
		boolean flag = true;
		do {
			System.out.println("*****欢迎进入苍何的登录系统*****");
			System.out.println("1、登录");
			System.out.println("2、注册");
			System.out.println("3、退出");
			System.out.print("请选择：");
			int option = input.nextInt();
			switch (option) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				System.exit(0);
			default:
				flag = false;
				break;
			}
		} while (flag);

	}

	public void login() {
		System.out.print("请输入您的用户名：");
		username = input.next();
		System.out.print("请输入您的密码：");
		password = input.next();
		boolean success = usersService.login(username, password);
		if (success) {
			System.out.println("登录成功，欢迎进入");
		} else {
			System.out.println("用户名或密码错误");
		}
	}

	public void register() {
		System.out.print("请输入您的用户名：");
		username = input.next();
		System.out.print("请输入您的密码：");
		password = input.next();
		boolean success = usersService.register(username, password);
		if(success) {
			System.out.println("注册成功");
		}else {
			System.out.println("用户名已存在，请重新注册");
		}
	}
}
