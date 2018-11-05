package com.suxiaomei.admin.entity.employee.extend;

import java.util.List;

import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.employee.Employee;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrderRecord;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;

public class EmployeeIdentificationOrderExtend extends EmployeeIdentificationOrder{
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private Business business;
	private Isoc isoc;
	private IsocEmpowerFirm isocEmpowerFirm;
	private List<IsocBusinessOrderData> datas;//订单审核项
	private List<EmployeeIdentificationOrderRecord> records;//审核记录
	private String qrcode;
	private String positionStr;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public IsocEmpowerFirm getIsocEmpowerFirm() {
		return isocEmpowerFirm;
	}
	public void setIsocEmpowerFirm(IsocEmpowerFirm isocEmpowerFirm) {
		this.isocEmpowerFirm = isocEmpowerFirm;
	}
	public String getPositionStr() {
		return positionStr;
	}
	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}
	public Isoc getIsoc() {
		return isoc;
	}
	public void setIsoc(Isoc isoc) {
		this.isoc = isoc;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public List<IsocBusinessOrderData> getDatas() {
		return datas;
	}
	public void setDatas(List<IsocBusinessOrderData> datas) {
		this.datas = datas;
	}
	public List<EmployeeIdentificationOrderRecord> getRecords() {
		return records;
	}
	public void setRecords(List<EmployeeIdentificationOrderRecord> records) {
		this.records = records;
	}
}
