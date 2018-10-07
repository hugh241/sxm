package com.suxiaomei.admin.entity.employee.extend;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.suxiaomei.admin.entity.employee.Employee;

/**
 * 阿姨扩展类
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
 * 2018年9月30日 上午9:29:44
 */
@JsonIgnoreProperties(value = {"handler"})
public class EmployeeExd extends Employee{
	private static final long serialVersionUID = 1L;
	private List<EmployeePositionExtend> positions;//护理员所有工种
	private int age;
	private int workingmonth;
	public List<EmployeePositionExtend> getPositions() {
		return positions;
	}
	public void setPositions(List<EmployeePositionExtend> positions) {
		this.positions = positions;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWorkingmonth() {
		return workingmonth;
	}
	public void setWorkingmonth(int workingmonth) {
		this.workingmonth = workingmonth;
	}
}
