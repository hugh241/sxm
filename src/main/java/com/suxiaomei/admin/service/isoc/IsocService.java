package com.suxiaomei.admin.service.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;
import com.suxiaomei.admin.entity.isoc.extend.IsocBusinessOrderExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocEmpowerExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;
import com.suxiaomei.admin.util.QueryResult;

/**
 * 家协
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
 * 2018年9月20日 下午5:10:54
 */
public interface IsocService {
	/**
	 * 初始化所有家协的token
	 * 1.系统启动运行
	 */
	void updateAllToken();
	/**
	 * 条件分页查询家协列表
	 * 1.管理后台家协管理列表查询
	 * @param condition
	 * @return
	 */
	QueryResult<IsocExtend> findByPageList(String condition);
	/**
	 * 新增家协
	 * 1.管理后台新增家协并为该家协创建登录账号
	 * @param ie
	 * @return
	 */
	int add(IsocExtend ie);
	/**
	 * 修改家协
	 * 1.管理后台家协管理列表查询
	 * @param ie
	 * @return
	 */
	int update(IsocExtend ie);
	/**
	 * 启用/停用家协账号
	 * 1.管理后台家协管理列表查询
	 * @param id
	 * @return
	 */
	int updateStatus(int id);
	/**
	 * 修改家协密码
	 * 1.管理后台家协管理列表查询
	 * @param ie
	 * @return
	 */
	int updatePassword(IsocExtend ie);
	/**
	 * 根据家协id查询家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param isocid
	 * @return
	 */
	List<IsocBusinessDataConfigure> findConfigByIsocid(int isocid);
	/**
	 * 新增家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param config
	 * @return
	 */
	int addConfig(IsocBusinessDataConfigure config);
	/**
	 * 修改家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param config
	 * @return
	 */
	int updateConfig(IsocBusinessDataConfigure config);
	/**
	 * 删除配置项
	 * 1.管理后台家协管理列表查询
	 * @param id
	 * @return
	 */
	int deleteConfig(int id);
	/**
	 * 根据家协id查询家协详细信息
	 * 1.家协端首页
	 * @param isocid
	 * @return
	 */
	IsocExtend findByIsocid(Integer isocid);
	/**
	 * 根据家协id查询家协基本信息
	 * 1.家协端首页
	 * @param isocid
	 * @return
	 */
	Isoc selectByPrimaryKey(Integer isocid);
	/**
	 * 修改家协基本信息
	 * 1.家协端首页
	 * @param isoc
	 * @return
	 */
	int update(Isoc isoc);
	/**
	 * 查询出企业认证申请记录
	 * 1.家协端 认证企业申请管理
	 * @param condition
	 * @param user
	 * @return
	 */
	QueryResult<IsocBusinessOrderExtend> findIsocBusinessOrder(String condition, User user);
	/**
	 * 根据认证订单id查询订单记录
	 * 1.家协端 认证企业申请管理
	 * 2.企业端 企业认证申请管理
	 * @param isocbusinessorderid
	 * @return
	 */
	List<IsocBusinessOrderRecord> findIsocBusinessOrderRecord(int isocbusinessorderid);
	/**
	 * 审核/驳回企业认证申请
	 * 1.家协端 认证企业申请管理
	 * @param order
	 * @return
	 */
	int authIsocBusinessOrder(IsocBusinessOrder order);
	/**
	 * 条件查询家协认证企业关联信息
	 * 1.家协端 认证企业管理
	 * @param condition
	 * @param cUser
	 * @return
	 */
	QueryResult<IsocIdentificationBusinessExtend> findIsocIdentificationBusiness(String condition, User cUser);
	/**
	 * 根据企业id查询出当前企业没有认证会员单位的家协
	 * 1.企业端 会员申请管理
	 * @param businessid
	 * @return
	 */
	List<Isoc> findIsocWitchNotAuthMember(Integer businessid);
	/**
	 * 根据企业id查询出已认证当前企业为会员单位的家协
	 * 1.企业端 企业认证申请管理
	 * @param businessid
	 * @return
	 */
	List<Isoc> findIsocWitchAuthMember(Integer businessid);
	/**
	 * 根据家协id，配置类型查询认证配置列表
	 * 1.企业端 企业认证申请管理
	 * 2.企业端 家政人员认证申请管理
	 * @param isocid
	 * @param type 0企业认证项配置 1护理员认证项配置 2学校认证配置
	 * @return
	 */
	List<IsocBusinessDataConfigure> findIsocBusinessDataConfiguresForBByIsocid(int isocid, int type);
	/**
	 * 创建企业/培训学校认证订单 
	 * 1.企业端 企业认证申请管理
	 * @param order
	 * @return 返回正数为错误码，负数为新增的订单id的负数
	 */
	int createIsocBusinessOrder(IsocBusinessOrder order);
	/**
	 * 根据认证订单id查询订单信息
	 * 1.企业端 企业认证申请管理
	 * @param isocbusinessorderid
	 * @return
	 */
	IsocBusinessOrder findIsocBusinessOrderByIsocbusinessorderid(int isocbusinessorderid);
	/**
	 * 根据订单id为该订单添加认证项，只有正在审核中的才能添加
	 * 1.企业端 企业认证申请管理
	 * @param isocbusinessorderid
	 * @param name
	 * @param pathes
	 * @paran type 0企业/培训学校认证 1护理员认证
	 * @return
	 */
	int addIsocBusinessOrderDataItems(int isocbusinessorderid, String name, List<String> pathes,int type);
	/**
	 * 根据认证项详细id删除该详细信息
	 * 1.企业端 企业认证申请管理
	 * 2.企业端 家政人员认证申请管理
	 * @param isocbusinessorderdatadetailid
	 * @param type 0企业认证项详细 1护理员认证项详细
	 * @return
	 */
	int deleteIsocBusinessOrderDataDetailByIsocbusinessorderdatadetailid(int isocbusinessorderdatadetailid, int type);
	/**
	 * 添加认证项详细 只能在驳回的订单下操作
	 * 1.企业端 企业认证申请管理
	 * 2.企业端 家政人员认证申请管理
	 * @param detail
	 * @param type 0企业认证项详细 1护理员认证项详细
	 * @return 小于0： 新增详细的主键id的负数 大于0：错误码
	 */
	int addIsocBusinessOrderDataDetail(IsocBusinessOrderDataDetail detail, int type);
	/**
	 * 重新编辑提交企业认证订单
	 * 1.企业端 企业认证申请管理
	 * @param isocbusinessorderid
	 * @return
	 */
	int reApply(int isocbusinessorderid);
	/**
	 * 查询认证当前企业的所有家协和家协下的授权单位
	 * 1.企业端 家政人员认证申请管理
	 * @param cUser
	 * @return
	 */
	List<IsocEmpowerExtend> findIsocEmpower(User cUser);
}
