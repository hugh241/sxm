package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 员工
 * @author zl
 */
public class Employee extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	employeeid;
	private String name = "";//姓名
	private String idcard = "";
	private int	sex;//性别 0：未知、1：男、2：女
	private String nativeplace = "";//籍贯
	private String birthday = "0000-00-00";//生日
	private String place = "";//先住址
	private String mobile = "";//手机
	private int	marriage = 1;//0已婚 1未婚 2离异 3丧偶
	private int	height = 0;//升高
	private int	weight = 0;//体重
	private int	education = -1;//学历
	private String photo = "";//头像
	private int	disposition = 0;//性格0稳重、1温和、2直爽、3内敛、4外向
	private int	animal = 0;//属相
	private int	constellation = 0;//星座
	private String physicaldate = "0000-00-00";//体检日期
	private String nationality = "";//民族
	private String health="良好";//健康状况
	private String residence = "";//户口所在地
	private int differentplaces;//是否愿意外地上班 0否 1是
	private String professiondate = "0000-00-00";//入司日期
	private String introduce;//阿姨描述
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getMarriage() {
		return marriage;
	}
	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getDisposition() {
		return disposition;
	}
	public void setDisposition(int disposition) {
		this.disposition = disposition;
	}
	public int getAnimal() {
		return animal;
	}
	public void setAnimal(int animal) {
		this.animal = animal;
	}
	public int getConstellation() {
		return constellation;
	}
	public void setConstellation(int constellation) {
		this.constellation = constellation;
	}
	public String getPhysicaldate() {
		return physicaldate;
	}
	public void setPhysicaldate(String physicaldate) {
		this.physicaldate = physicaldate == null ? "0000-00-00" : physicaldate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public int getDifferentplaces() {
		return differentplaces;
	}
	public void setDifferentplaces(int differentplaces) {
		this.differentplaces = differentplaces;
	}
	public String getProfessiondate() {
		return professiondate;
	}
	public void setProfessiondate(String professiondate) {
		this.professiondate = professiondate==null?"0000-00-00":professiondate;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
