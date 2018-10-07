package com.suxiaomei.admin.util;

/**
 * 只要登录，就有GET或少数其他类型权限的链接
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
 * 2018年9月26日 上午10:26:03
 */
public enum ExceptValidateModule {
	MODULE("module"),ROLE("role"),DICT("dict"),SYS("sys"),DICTIONARY("dictionary"),BSALESLEADS("bsalesleads"),
	BEMPLOYEE("bemployee"),BMCONTRACT("bmcontract"),BCONTRACTTYPE("bcontracttype"),LOSEREASON("losereason"),
	BUSINESSATTACH("businessattach"),REMOVERESOURCE("removereason"),BTRAFFIC("btraffic"),BUSER("buser"),SOURCE("source"),
	ORDERTYPEFAMILYMEMBER("orderTypeFamilyMember"),FAMILYMEMBERTOOLS("familyMemberTools"),BMCUSTOMER("bmcustomer"),
	USER("user");
	
	// 模块名称
    private String message;  
    // 构造方法  
    private ExceptValidateModule(String message) {  
        this.message = message;  
    }  
    //判断模块是否存在
    public static boolean isExist(String module, String method) {
    	if("user/password".equals(module) && "PUT".equals(method.toUpperCase())){//修改密码
    		return true;
    	}
    	if("user/logout".equals(module) && "DELETE".equals(method.toUpperCase())){//注销权限
    		return true;
    	}
    	module = module.split("/|\\?")[0];
    	if("upload".equals(module)){//上传文件权限
    		return true;
    	}
    	if(!"GET".equals(method.toUpperCase())){
    		return false;
    	}
        for (ExceptValidateModule c : ExceptValidateModule.values()) {  
            if (c.getMessage().equals(module)) {  
                return true;
            }  
        }  
        return false;  
    }  
    // get set 方法  
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
