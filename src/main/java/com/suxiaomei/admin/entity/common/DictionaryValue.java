package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 数据字典值
 * @author zl
 */
public class DictionaryValue implements Serializable{
	private static final long serialVersionUID = 1L;
	public DictionaryValue(){}
	public DictionaryValue(int dictionaryid){
		this.dictionaryid = dictionaryid;
		this.savevalue = -1;
	}
	public DictionaryValue(int dictionaryid,int savevalue){
		this.dictionaryid = dictionaryid;
		this.savevalue = savevalue;
	}
	
	private int	dictionaryvalueid;
	private int	dictionaryid;
	private String dictionaryvalue;
	private int	savevalue;
	private int	status;
	
	public int getDictionaryvalueid() {
		return dictionaryvalueid;
	}
	public void setDictionaryvalueid(int dictionaryvalueid) {
		this.dictionaryvalueid = dictionaryvalueid;
	}
	public int getDictionaryid() {
		return dictionaryid;
	}
	public void setDictionaryid(int dictionaryid) {
		this.dictionaryid = dictionaryid;
	}
	public String getDictionaryvalue() {
		return dictionaryvalue;
	}
	public void setDictionaryvalue(String dictionaryvalue) {
		this.dictionaryvalue = dictionaryvalue;
	}
	public int getSavevalue() {
		return savevalue;
	}
	public void setSavevalue(int savevalue) {
		this.savevalue = savevalue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DictionaryValue [dictionaryvalueid=" + dictionaryvalueid
				+ ", dictionaryid=" + dictionaryid + ", dictionaryvalue="
				+ dictionaryvalue + ", savevalue=" + savevalue + ", status="
				+ status + "]";
	}
}
