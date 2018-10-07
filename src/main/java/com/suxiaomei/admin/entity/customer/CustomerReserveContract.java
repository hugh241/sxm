package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;

/**
 * 客户预定合同关联
 * @author zl
 */
public class CustomerReserveContract implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	customerreservecontractid;
	private int	customerreserveid;
	private int	contractid;
	public int getCustomerreservecontractid() {
		return customerreservecontractid;
	}
	public void setCustomerreservecontractid(int customerreservecontractid) {
		this.customerreservecontractid = customerreservecontractid;
	}
	public int getCustomerreserveid() {
		return customerreserveid;
	}
	public void setCustomerreserveid(int customerreserveid) {
		this.customerreserveid = customerreserveid;
	}
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
}
