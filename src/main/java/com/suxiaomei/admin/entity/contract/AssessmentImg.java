package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.suxiaomei.admin.common.GlobalConfig;
/**
 * 评价内容图片地址
 * @author zl
 */
public class AssessmentImg implements Serializable{
	private int	assessmentimgid;
	private int	assessmentdetailid;
	private String	smallurl;
	private String	url;
	private int	status = 1;
	private String	createtime;
	private String	updatetime;
	private static final long serialVersionUID = 1L;
	@Autowired
	private GlobalConfig config;
	public int getAssessmentimgid() {
		return assessmentimgid;
	}
	public void setAssessmentimgid(int assessmentimgid) {
		this.assessmentimgid = assessmentimgid;
	}
	public int getAssessmentdetailid() {
		return assessmentdetailid;
	}
	public void setAssessmentdetailid(int assessmentdetailid) {
		this.assessmentdetailid = assessmentdetailid;
	}
	public String getSmallurl() {
		return config.UPLOADPATH_MOBILE+smallurl;
	}
	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	}
	public String getUrl() {
		return config.UPLOADPATH_ORIGINAL+url;
	}
	public void setUrl(String url) {
		this.url = url;
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
