package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 
 * @ClassName: IsocCreditCardTemplate.java
 * @Description: 家协信誉卡模版
 * 
 * @author JenpoLee
 * @version V1.0
 * @Date 2018年8月9日 上午11:46:10
 */
public class IsocCreditCardTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer isoccreditcardtemplateid; // id
	private Integer isocid; // 家协id
	private Integer type; // 1正面2背面
	private String name; // 名称
	private String url = ""; // 模版地址
	private Integer hasname; // 是否有人员名字0无1有
	private Integer namepositiontype; // 名字位置 1左对齐 2居中对齐 3右对齐
	private Integer nametop;// 名字上边距
	private Integer nameleft;// 名字左边距
	private String namefontfamily;// 名字字体
	private Integer namefontsize;// 名字字号(字体大小)
	private String namecolor;// 名字颜色
	private Integer hashead;// 是否有头像0无1有
	private Integer headpositiontype;// 头像位置 1左对齐 2居中对齐 3右对齐
	private Integer headwidth;// 头像宽度
	private Integer headheight;// 头像高度
	private Integer headtop;// 头像上边距
	private Integer headleft;// 头像左边距
	private Integer hasqrcode;// 是否有二维码
	private Integer qrcodepositiontype;// 二维码位置 1左对齐 2居中对齐 3右对齐
	private Integer qrcodewidth;// 二维码宽度
	private Integer qrcodeheight;// 二维码高度
	private Integer qrcodetop;// 二维码上边距
	private Integer qrcodeleft;// 二维码左边距
	private Integer usestatus;// 使用状态0未启用1已启用
	private Integer status = 1;
	private String createtime;
	private String updatetime;
	public IsocCreditCardTemplate() {
		super();
	}
	public IsocCreditCardTemplate(Integer isoccreditcardtemplateid, Integer isocid, Integer type, String name, String url, Integer hasname, Integer namepositiontype,
			Integer nametop, Integer nameleft, String namefontfamily, Integer namefontsize, String namecolor, Integer hashead, Integer headpositiontype, Integer headwidth,
			Integer headheight, Integer headtop, Integer headleft, Integer hasqrcode, Integer qrcodepositiontype, Integer qrcodewidth, Integer qrcodeheight, Integer qrcodetop,
			Integer qrcodeleft, Integer usestatus, String createtime, String updatetime, Integer status) {
		super();
		this.isoccreditcardtemplateid = isoccreditcardtemplateid;
		this.isocid = isocid;
		this.type = type;
		this.name = name;
		this.url = url;
		this.hasname = hasname;
		this.namepositiontype = namepositiontype;
		this.nametop = nametop;
		this.nameleft = nameleft;
		this.namefontfamily = namefontfamily;
		this.namefontsize = namefontsize;
		this.namecolor = namecolor;
		this.hashead = hashead;
		this.headpositiontype = headpositiontype;
		this.headwidth = headwidth;
		this.headheight = headheight;
		this.headtop = headtop;
		this.headleft = headleft;
		this.hasqrcode = hasqrcode;
		this.qrcodepositiontype = qrcodepositiontype;
		this.qrcodewidth = qrcodewidth;
		this.qrcodeheight = qrcodeheight;
		this.qrcodetop = qrcodetop;
		this.qrcodeleft = qrcodeleft;
		this.usestatus = usestatus;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.status = status;
	}

	public Integer getIsoccreditcardtemplateid() {
		return isoccreditcardtemplateid;
	}

	public void setIsoccreditcardtemplateid(Integer isoccreditcardtemplateid) {
		this.isoccreditcardtemplateid = isoccreditcardtemplateid;
	}

	public Integer getIsocid() {
		return isocid;
	}

	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getHasname() {
		return hasname;
	}

	public void setHasname(Integer hasname) {
		this.hasname = hasname;
	}

	public Integer getNamepositiontype() {
		return namepositiontype;
	}

	public void setNamepositiontype(Integer namepositiontype) {
		this.namepositiontype = namepositiontype;
	}

	public Integer getNametop() {
		return nametop;
	}

	public void setNametop(Integer nametop) {
		this.nametop = nametop;
	}

	public Integer getNameleft() {
		return nameleft;
	}

	public void setNameleft(Integer nameleft) {
		this.nameleft = nameleft;
	}

	public String getNamefontfamily() {
		return namefontfamily;
	}

	public void setNamefontfamily(String namefontfamily) {
		this.namefontfamily = namefontfamily;
	}

	public Integer getNamefontsize() {
		return namefontsize;
	}

	public void setNamefontsize(Integer namefontsize) {
		this.namefontsize = namefontsize;
	}

	public String getNamecolor() {
		return namecolor;
	}

	public void setNamecolor(String namecolor) {
		this.namecolor = namecolor;
	}

	public Integer getHashead() {
		return hashead;
	}

	public void setHashead(Integer hashead) {
		this.hashead = hashead;
	}

	public Integer getHeadpositiontype() {
		return headpositiontype;
	}

	public void setHeadpositiontype(Integer headpositiontype) {
		this.headpositiontype = headpositiontype;
	}

	public Integer getHeadwidth() {
		return headwidth;
	}

	public void setHeadwidth(Integer headwidth) {
		this.headwidth = headwidth;
	}

	public Integer getHeadheight() {
		return headheight;
	}

	public void setHeadheight(Integer headheight) {
		this.headheight = headheight;
	}

	public Integer getHeadtop() {
		return headtop;
	}

	public void setHeadtop(Integer headtop) {
		this.headtop = headtop;
	}

	public Integer getHeadleft() {
		return headleft;
	}

	public void setHeadleft(Integer headleft) {
		this.headleft = headleft;
	}

	public Integer getHasqrcode() {
		return hasqrcode;
	}

	public void setHasqrcode(Integer hasqrcode) {
		this.hasqrcode = hasqrcode;
	}

	public Integer getQrcodepositiontype() {
		return qrcodepositiontype;
	}

	public void setQrcodepositiontype(Integer qrcodepositiontype) {
		this.qrcodepositiontype = qrcodepositiontype;
	}

	public Integer getQrcodewidth() {
		return qrcodewidth;
	}

	public void setQrcodewidth(Integer qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}

	public Integer getQrcodeheight() {
		return qrcodeheight;
	}

	public void setQrcodeheight(Integer qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}

	public Integer getQrcodetop() {
		return qrcodetop;
	}

	public void setQrcodetop(Integer qrcodetop) {
		this.qrcodetop = qrcodetop;
	}

	public Integer getQrcodeleft() {
		return qrcodeleft;
	}

	public void setQrcodeleft(Integer qrcodeleft) {
		this.qrcodeleft = qrcodeleft;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
