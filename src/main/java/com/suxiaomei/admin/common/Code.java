package com.suxiaomei.admin.common;

public enum Code {
	SUCCESS(241,"操作成功"),LOGIN_UNLOGIN(445,"没有登陆或登陆失效"),LOGIN_FAILED(446,"账号或密码错误！"),
	CONTROLLE_FAILED(9999,"系统错误！"),
	NO_SYSTEM(421,"未选择系统"),NO_ROLES(422,"未选择角色"),USERNAME_REPEAT(423,"用户名称重复"),
	USER_NEW_FAILED(424,"添加失败"),PERMISSION_FAILED(425,"您没有权限进行本次操作，请联系管理员"),
	SUBMIT_DATA_ERROR(426,"提交数据错误，请检查"),IDCARDERROR(427,"身份证号不合法，请检查"),
	IDCARDEXIST(428,"身份证重复"),BETIMEERROR(429,"时间段不合法，请检查"),
	EXPERIENCETIMEREPEAT(430,"该时间段内已存在工作经历"),KEYEXIST(431,"已存在同名key"),
	EMPLOYEEEXISTSCHEDULE(432,"该时间段内已有档期"),MODULEEXIST(433,"模块重复，请检查"),
	USER_UPDATE_FAILED(434,"修改失败"),NO_SYSTEMS(435,"未选择系统"),SMSFAILED(436,"短信发送失败"),
	TELREGISTERED(437,"该手机号已注册"),REGISTERFAILED(438,"注册失败"),VCODEERROR(439,"验证码错误或超时"),
	SAVEIMAGEPATHNOTEXIST(440,"图片路径不存在"),SKILLEXIST(441,"已存在该技能，添加失败"),SKILLNOTEXIST(442,"不存在该技能，删除失败"),
	SKILLNOTEXISTINS(443,"系统中不存在该技能！"),CERDENTIALMAXERROR(444,"证件照最多上传8张"),
	LIFEPHOTOMAXERROR(445,"生活照照片数目已达上限，请删除一些再上传"),LIFEPHOTOMAXTIMES(446,"今天上传次数已达上限，请明天再上传"),
	PHOTONOTEXIST(447,"图片不存在！"),CANNOTDELETE(448,"当前数据不能删除"),CONTROLEFAILED(449,"操作有误"),
	ISOC_REPEAT(450,"已存在同名家协"),USERNICKNAME_REPEAT(451,"会员名称重复"),CONNECT_EXIST(452,"已存在系统中"),
	ROLE_EXIST(453,"已存在同名角色"),RESET_FAILED(454,"重置失败"),HOME_LOCATION_ERROR(455,"归属地不正确"),
	HOME_LOCATION_ISOC_REPEAT(456,"该归属地下已存在家协"),GOODSPOSITIONEXIST(457,"工种对应的产品已经存在"),
	GOODSNUMSLACK(458,"未结算消耗不足"),GROUPLEADEREXIST(459,"当前工作组已存在组长"),WORKGROUPNOTEXIST(460,"工作组不存在"),
	USERALREADINWORKGROUP(461,"当前员工已存在工作组中"),WORKGROUPHASUSERS(462,"不能删除存在组员的工作组"),
	NAMEEXIST(463,"名称重复"),CUSTOMEREXIST(464,"客户已存在"),CONTRACTCHILDBIRTHMAXERROR(465,"最多上传9张合同原件"),CREDITNOTENOUGH(465,"余额不足"),
	UPLOADFILESIZEMAX(466,"只能上传最大2M的文件"),AREADBINDIDCARD(467,"该账户已经绑定了身份证"),IDCARDAREADBIND(468,"该身份证已经被绑定"),
	ACCOUNTSEXIST(469,"已存在账号"),VIDUNUSEFUL(470,"VID已失效"),MOBILEEXIST(471,"该手机号已被占用"),WECHATEXIST(472,"该微信号已被占用"),
	EVALUATEEXIST(473,"该订单已评价过了"),ASSOCIATIONEXIST(474,"关联已经存在"),DOWNTASKALREADSUBMIT(475,"已提交了下户申请，请等待审核"),
	TELNOTREGISTER(476,"该手机号没有注册"),BUSINESSAPPLYINGORPASSAPPLY(477,"当前企业正在该家协申请或已是会员单位"),
	CANNOTDELETEIDENTIFICATIONBUSINESS(478,"不能删除认证企业"),ITEMSNOTCOMFIRM(479,"存在未确认项目"),BACKGROUNDCHECKERROR(480,"背调接口返回错误"),
	EDUCATIONINFO(481,"培训分数不合格"),ISOCGOODSNUMSLACK(482,"产品数量不足"),RUNNINGORDEREXIST(483,"当前时间段内存在其他档期"),
	RUNNINGCONTRACTEXIST(484,"存在进行中的合同,不能移出");
	// 成员变量
    private int code;
    private String message;
    // 构造方法  
    private Code(int code, String message) {  
        this.code = code;  
        this.message = message;  
    }  
    // 普通方法  
    public static String getName(int code) {  
        for (Code c : Code.values()) {  
            if (c.getCode() == code) {  
                return c.message;
            }  
        }  
        return null;  
    }
    // get set 方法  
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
