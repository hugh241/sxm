package com.suxiaomei.admin.entity.common;

import java.io.Serializable;
/**
 * 数据字典表
 * @author zl
 */
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.suxiaomei.admin.response.Dict;

public class Dictionary implements Serializable{
	private int	dictionaryid;
	private String dictionarykey;
	private String dictionaryname;
	private List<Dict> values;
	private static final long serialVersionUID = 1L;
	public int getDictionaryid() {
		return dictionaryid;
	}
	public void setDictionaryid(int dictionaryid) {
		this.dictionaryid = dictionaryid;
	}
	public String getDictionarykey() {
		return dictionarykey;
	}
	public void setDictionarykey(String dictionarykey) {
		this.dictionarykey = dictionarykey;
	}
	public String getDictionaryname() {
		return dictionaryname;
	}
	public void setDictionaryname(String dictionaryname) {
		this.dictionaryname = dictionaryname;
	}
	public List<Dict> getValues() {
		return values;
	}
	public void setValues(List<Dict> values) {
		this.values = values;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}
