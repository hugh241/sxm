package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 家协会员企业
 * @author zl
 */
public class Member extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer	memberid;
	private Integer businessid;//企业id
	private Integer isocid;//家协id
	private String name;//机构名字
	private String gszh = "";//工商证号
	private String clsj;//成立时间
	private String xyzh = "";//信用证号
	private String jydz;//经营地址
	private String rhsj;//入会时间
	private String jyxm;//经营项目 1.家政（家庭） 2.商业清洁 3.母婴护理（月嫂） 4.育婴（育儿嫂） 5.综合家政服务（家政保姆） 6.家庭清洁服务（保洁员） 7.养老护理 99.其他
	private String jyfs;//经营方式 1.中介制/2.员工制
	private String fwdh;//服务电话
	private String czdh;//传真电话
	private String lxry;//联系人员
	private String zw;//职务
	private String frdb;//法人代表
	private String xb;//性别 男/女 1.男 2女
	private String mz;//民族
	private String jg;//籍贯
	private String cssj;//出生时间
	private String zzmm;//政治面貌
	private String qyzw;//企业职务
	private String shzw;//社会职务
	private String sfzh;//身份证号
	private String bgdh;//办公电话
	private String yddh;//移动电话
	private int	zjzzgrs;//中介制职工人数
	private int	zjzkhrs;//中介制客户人数
	private int	ygzzgrs;//员工制职工人数
	private int	ygzkhrs;//员工制客户人数
	private Integer shstatus;//申请状态 0申请中 1申请通过 2申请驳回 3删除
	private String result = "";//备注
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGszh() {
		return gszh;
	}
	public void setGszh(String gszh) {
		this.gszh = gszh;
	}
	public String getClsj() {
		return clsj;
	}
	public void setClsj(String clsj) {
		this.clsj = clsj;
	}
	public String getXyzh() {
		return xyzh;
	}
	public void setXyzh(String xyzh) {
		this.xyzh = xyzh;
	}
	public String getJydz() {
		return jydz;
	}
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	public String getRhsj() {
		return rhsj;
	}
	public void setRhsj(String rhsj) {
		this.rhsj = rhsj;
	}
	public String getJyxm() {
		return jyxm;
	}
	public void setJyxm(String jyxm) {
		this.jyxm = jyxm;
	}
	public String getJyfs() {
		return jyfs;
	}
	public void setJyfs(String jyfs) {
		this.jyfs = jyfs;
	}
	public String getFwdh() {
		return fwdh;
	}
	public void setFwdh(String fwdh) {
		this.fwdh = fwdh;
	}
	public String getCzdh() {
		return czdh;
	}
	public void setCzdh(String czdh) {
		this.czdh = czdh;
	}
	public String getLxry() {
		return lxry;
	}
	public void setLxry(String lxry) {
		this.lxry = lxry;
	}
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getCssj() {
		return cssj;
	}
	public void setCssj(String cssj) {
		this.cssj = cssj;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getQyzw() {
		return qyzw;
	}
	public void setQyzw(String qyzw) {
		this.qyzw = qyzw;
	}
	public String getShzw() {
		return shzw;
	}
	public void setShzw(String shzw) {
		this.shzw = shzw;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getYddh() {
		return yddh;
	}
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	public int getZjzzgrs() {
		return zjzzgrs;
	}
	public void setZjzzgrs(int zjzzgrs) {
		this.zjzzgrs = zjzzgrs;
	}
	public int getZjzkhrs() {
		return zjzkhrs;
	}
	public void setZjzkhrs(int zjzkhrs) {
		this.zjzkhrs = zjzkhrs;
	}
	public int getYgzzgrs() {
		return ygzzgrs;
	}
	public void setYgzzgrs(int ygzzgrs) {
		this.ygzzgrs = ygzzgrs;
	}
	public int getYgzkhrs() {
		return ygzkhrs;
	}
	public void setYgzkhrs(int ygzkhrs) {
		this.ygzkhrs = ygzkhrs;
	}
	public Integer getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public Integer getShstatus() {
		return shstatus;
	}
	public void setShstatus(Integer shstatus) {
		this.shstatus = shstatus;
	}
}
