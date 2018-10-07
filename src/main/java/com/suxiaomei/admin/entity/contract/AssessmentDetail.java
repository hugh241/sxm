package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;

/**
 * 评价内容详细
 * @author zl
 */
public class AssessmentDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	assessmentdetailid;
	private int	contractorderemployeeassessmentid;//评价id
	private String content;//内容
	private int	type;//类型 0默认回复 1客户追评 2企业用户评价 3阿姨追评
	private Integer relationid;//评价关联id 如果试客户，关联客户id 如果是企业关联该企业下评价该订单时登录的账号id
	private String name;//评价人名称
	private int flag;//0未处理 1已处理
	private int	status = 1;
	private String	createtime;
	private String	updatetime;
	public int getAssessmentdetailid() {
		return assessmentdetailid;
	}
	public void setAssessmentdetailid(int assessmentdetailid) {
		this.assessmentdetailid = assessmentdetailid;
	}
	public int getContractorderemployeeassessmentid() {
		return contractorderemployeeassessmentid;
	}
	public void setContractorderemployeeassessmentid(
			int contractorderemployeeassessmentid) {
		this.contractorderemployeeassessmentid = contractorderemployeeassessmentid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public Integer getRelationid() {
		return relationid;
	}
	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
