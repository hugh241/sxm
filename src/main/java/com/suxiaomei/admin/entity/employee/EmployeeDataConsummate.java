package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;
/**
 * 护理员资料完成度
 * 每一项都为百分比
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月10日 下午3:27:32
 */
public class EmployeeDataConsummate implements Serializable{
	private int	employeedataconsummateid;
	private int	employeeid;//护理员id
	private int	headportrait;//头像完成度 占总的10%
	private int	basicdata;//基本资料完成度 没一个空的字段减1 占总的10%
	private int	worktype;//工种 有工种没工资减5 占总的10%
	private int	album;//生活照 一张照片2 占总的20%
	private int	certificate;//证件照 一张照片10  占总的30%
	private int	train;//培训记录 20%
	private int	total;//总数 100
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getEmployeedataconsummateid() {
		return employeedataconsummateid;
	}
	public void setEmployeedataconsummateid(int employeedataconsummateid) {
		this.employeedataconsummateid = employeedataconsummateid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getHeadportrait() {
		return headportrait;
	}
	public void setHeadportrait(int headportrait) {
		this.headportrait = headportrait;
	}
	public int getBasicdata() {
		return basicdata;
	}
	public void setBasicdata(int basicdata) {
		this.basicdata = basicdata;
	}
	public int getWorktype() {
		return worktype;
	}
	public void setWorktype(int worktype) {
		this.worktype = worktype;
	}
	public int getAlbum() {
		return album;
	}
	public void setAlbum(int album) {
		this.album = album;
	}
	public int getCertificate() {
		return certificate;
	}
	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}
	public int getTrain() {
		return train;
	}
	public void setTrain(int train) {
		this.train = train;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
