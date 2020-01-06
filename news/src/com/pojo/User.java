package com.pojo;

public class User {// 实体类
	private String aid;
	private String aname;
	private String apwd;
	private String sex;
	private int age;
	private String birthday;
	private String phone;
	private String qq;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public User() {
		super();
	}

	public User(String aid, String aname, String apwd, String sex, int age, String birthday) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [aid=" + aid + ", aname=" + aname + ", apwd=" + apwd + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	

}
