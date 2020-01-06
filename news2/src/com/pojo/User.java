package com.pojo;

public class User {//实体类
	private String aid;
	private String aname;
	private String apwd;
	private String sex;
	private int age;
	private String birthday;
	private String phone;
	private String city;
	private String grade;
	private String school;
	
	private String qq;
	private String realName;
	private String photoName;
	private String photoType;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public User(String aid,  String phone, String qq, String realName, String photoName,
			String photoType) {
		super();
		this.aid = aid;
		
		this.phone = phone;
		this.qq = qq;
		this.realName = realName;
		this.photoName = photoName;
		this.photoType = photoType;
	}
	
	public User(String phone,String city,
			String grade, String school,String qq) {
		super();
		this.aid = aid;
		
		this.phone = phone;
		this.city = city;
		this.grade = grade;
		this.school = school;
		this.qq = qq;
		
	}

	
	public User() {
	super();
}
	public String getRealName() {
		return realName;
	}
	public void setRealname(String realName) {
		this.realName = realName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhototype(String photoType) {
		this.photoType = photoType;
	}
	public User(String aid, String aname, String apwd) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		
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
	
	public User(String aid, String aname, String apwd, String sex, int age, String birthday, String phone, String qq) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.qq = qq;
	}
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
