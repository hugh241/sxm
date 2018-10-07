package com.suxiaomei.admin.response;

import java.io.Serializable;

public class Dict implements Serializable{
	private static final long serialVersionUID = 1L;
	private int key;
	private String value;
	public Dict(){}
	public Dict(int key) {
		this.key = key;
	}
	public Dict(int key,String value){
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Dict){
			if(this.key == ((Dict)obj).getKey()){
				return true;
			}
		}
		return false;
	}
}
