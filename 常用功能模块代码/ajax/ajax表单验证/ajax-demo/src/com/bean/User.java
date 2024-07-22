package com.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * �û�ʵ��
 * @author Administrator
 *
 */
public class User implements Serializable {

	private Integer id;
	private String userName;
	private String password;
	private Integer gender;
	private Date registeTime;
	
	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, Integer gender, String registeTime) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		setRegisteTime(registeTime);
	}

	public User(String userName, String password, Integer gender, Date registeTime) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.registeTime = registeTime;
	}

	public User(Integer id, String userName, String password, Integer gender, Date registeTime) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.registeTime = registeTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", registeTime=" + registeTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}
	
	public void setRegisteTime(String registeTime) {
		
		//���ڸ�ʽ������
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//���ַ�����ʽ����util��date����
			java.util.Date time = format.parse(registeTime);
			//Ϊ���Ը�ֵ
			this.registeTime = new Date(time.getTime());
			
		} catch (ParseException e) {
			this.registeTime = new Date(new java.util.Date().getTime());
		}
	}
}














