package com.suxiaomei.admin.service.impl.isoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.account.AccountMapper;
import com.suxiaomei.admin.dao.account.IntroducerConfigMapper;
import com.suxiaomei.admin.dao.account.IntroducerMapper;
import com.suxiaomei.admin.dao.account.RoleMapper;
import com.suxiaomei.admin.dao.account.RoleModuleMapper;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.dao.business.BusinessMapper;
import com.suxiaomei.admin.dao.business.BusinessParamsMapper;
import com.suxiaomei.admin.dao.common.ModuleMapper;
import com.suxiaomei.admin.dao.isoc.IsocEmpowerFirmMapper;
import com.suxiaomei.admin.dao.isoc.IsocIdentificationBusinessMapper;
import com.suxiaomei.admin.dao.isoc.IsocMemberMapper;
import com.suxiaomei.admin.dao.isoc.MemberMapper;
import com.suxiaomei.admin.dao.isoc.MemberRecordMapper;
import com.suxiaomei.admin.entity.account.Account;
import com.suxiaomei.admin.entity.account.Introducer;
import com.suxiaomei.admin.entity.account.IntroducerConfig;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.RoleModule;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.BusinessParams;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;
import com.suxiaomei.admin.entity.isoc.IsocIdentificationBusiness;
import com.suxiaomei.admin.entity.isoc.IsocMember;
import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.entity.isoc.MemberRecord;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;
import com.suxiaomei.admin.entity.isoc.extend.MemberExtend;
import com.suxiaomei.admin.service.isoc.MemberService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;

import net.sf.json.JSONObject;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private BusinessMapper businessDao;
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private ModuleMapper moduleDao;
	@Autowired
	private RoleModuleMapper roleModuleDao;
	@Autowired
	private GlobalConfig config;
	@Autowired
	private BusinessParamsMapper businessParamsDao;
	@Autowired
	private IntroducerMapper introducerDao;
	@Autowired
	private IntroducerConfigMapper introducerConfigDao;
	@Autowired
	private AccountMapper accountDao;
	@Autowired
	private MemberRecordMapper memberRecordDao;
	@Autowired
	private IsocMemberMapper isocMemberDao;
	@Autowired
	private IsocIdentificationBusinessMapper isocIdentificationBusinessDao;
	@Autowired
	private IsocEmpowerFirmMapper isocEmpowerFirmDao;
	
	@Override
	public int add(Member t) {
		if(t.getShstatus() == 0){//企业提交申请
			//验证当前企业是否是当前家协的会员或者正在申请中
			Member member = memberDao.findApplyingOrPassApplyByBusinessidAndIsocid(t.getBusinessid(),t.getIsocid());
			if(member != null){
				return 477;
			}
			memberDao.insert(t);
			return 1;
		}else{//家协新增会员单位
			//自动注册一个企业
			int businessid = autoRegisterBusinessByMember(t);
			if(businessid < 0){//注册成功
				businessid = -businessid;
				t.setBusinessid(businessid);
				t.setResult("家协添加");
				memberDao.insert(t);
				
				MemberRecord record = new MemberRecord();
				record.setMemberid(t.getMemberid());
				record.setResult("家协添加");
				memberRecordDao.insert(record);
				
				IsocMember im = new IsocMember();
				im.setIsocid(t.getIsocid());
				im.setBusinessid(t.getBusinessid());
				im.setMemberid(t.getMemberid());
				isocMemberDao.insert(im);
				return -t.getMemberid();
			}else{
				return businessid;//返回错误码
			}
		}
	}
	
	/**
	 * 根据会员信息自动注册一个企业并返回企业id
	 * @param member
	 * @return
	 */
	private int autoRegisterBusinessByMember(Member member) {
		if(member.getFwdh() == null || "".equals(member.getFwdh())){
			return 426;
		}
		//检测手机号是否存在
		User u = userDao.findByMobile(member.getFwdh());
		if(u != null){
			return 437;
		}
		//根据会员信息自动添加企业并为该企业创建介绍人，账号信息
		Business business = autoAddBusiness(member);
		//根据企业信息自动新增企业管理员角色并为该角色添加普通菜单模块
		Role role = autoAddRole(business.getBusinessid());
		//根据会员信息为管理员角色自动添加一个管理员账号
		User user = autoAddUser(member,role.getRoleid());
		//为企业添加默认介绍类型(阿姨转介绍 、客户转介绍、其他：默认不可删除)
		autoAddDefaultIntroducerType(business.getBusinessid());
		//添加企业认证申请权限
		for (int i = 0; i < config.STR_B_BAUTH.size(); i++) {
			Module module = moduleDao.findByUrlAndSxmsystemid(config.STR_B_BAUTH.get(i),config.INT_BUSINESS);
			RoleModule rm = new RoleModule(user.getRoleid(), module.getModuleid());
			roleModuleDao.insert(rm);
		}
		return -business.getBusinessid();
	}
	
	/**
	 * 为企业自动添加3中介绍人类型
	 * (阿姨转介绍 、客户转介绍、其他：默认不可删除)
	 * @param businessid
	 */
	private void autoAddDefaultIntroducerType(int businessid) {
		for (int i = 1; i <= config.STR_BUSINESS_P_TRAFFIC.size(); i++) {
			BusinessParams br = new BusinessParams();
			br.setBusinessid(businessid);
			br.setType(config.INT_BUSINESS_P_TRAFFIC);
			br.setName(config.STR_BUSINESS_P_TRAFFIC.get(i-1));
			br.setVkey(i+"");
			br.setIsdefault(1);
			businessParamsDao.insert(br);
			IntroducerConfig ic = new IntroducerConfig();
			ic.setType(config.INT_INTRODUCER_CONFIG_TYPE.get(1));
			ic.setRelationid(br.getBusinessparamsid());
			ic.setTcts(config.INT_TCTS_ZY);
			ic.setZjstcts(config.INT_TCTS_ZJS);
			introducerConfigDao.insert(ic);
			if(i == 3) {//为其他介绍人类型添加一个默认介绍人信息
				Introducer introducer = new Introducer();
				introducer.setBusinessparamsid(br.getBusinessparamsid());
				introducer.setName(config.STR_BUSINESS_P_TRAFFIC.get(i-1));
				introducer.setType(config.INT_INTRODUCER_TYPE.get(4));//config.getIntroducerType(4)
				introducerDao.insert(introducer);
				IntroducerConfig iic = new IntroducerConfig();
				iic.setType(config.INT_INTRODUCER_CONFIG_TYPE.get(0));
				iic.setRelationid(introducer.getIntroducerid());
				iic.setTcts(config.INT_TCTS_ZY);
				iic.setZjstcts(config.INT_TCTS_ZJS);
				introducerConfigDao.insert(iic);
			}
		}
	}

	/**
	 * 根据会员信息和管理员角色id自动为该角色添加管理员账号
	 * @param member
	 * @param roleid
	 * @return
	 */
	private User autoAddUser(Member member, int roleid) {
		User user = new User();
		user.setMobile(member.getFwdh());
		user.setName(member.getName());
		user.setUsername("A"+member.getFwdh());
		user.setRoleid(roleid);
		userDao.insert(user);
		return user;
	}

	/**
	 * 根据企业id自动为企业添加管理员角色并未该角色添加普通菜单模块
	 * @param business
	 * @return
	 */
	private Role autoAddRole(int businessid) {
		Role role = new Role(businessid,config.INT_BUSINESS,1,config.STR_MANAGER, config.STR_BUSINESSROLEDESC);
		roleDao.insertSelective(role);
		List<Module> moduleList = moduleDao.findAutomaticBySxmsystemid(config.INT_BUSINESS);
		for (int i = 0;moduleList != null && i < moduleList.size(); i++) {
			RoleModule rm = new RoleModule();
			rm.setModuleid(moduleList.get(i).getModuleid());
			rm.setRoleid(role.getRoleid());
			roleModuleDao.insert(rm);
		}
		return role;
	}
	/**
	 * 根据会员信息自动新增企业并添加企业的介绍人和账户
	 * @param member
	 * @return
	 */
	private Business autoAddBusiness(Member member) {
		//新增企业
		Business business = new Business();
		business.setFullname(member.getName());
		business.setShortname(member.getName());
		business.setPhone(member.getFwdh());
		businessDao.insert(business);
		//新增企业本身对应的介绍人信息
		Introducer bIntroducer = new Introducer();
		bIntroducer.setName(member.getName());
		bIntroducer.setRelationid(business.getBusinessid());
		bIntroducer.setType(config.INT_INTRODUCER_TYPE.get(3));
		introducerDao.insert(bIntroducer);
		//为当前企业新增账户并关联
		Account account = new Account();
		account.setAccountnum(business.getPhone());
		account.setPassword(business.getPhone());
		account.setIntroducerid(bIntroducer.getIntroducerid());
		accountDao.insert(account);
		return business;
	}

	@Override
	public QueryResult<MemberExtend> findPassMembersByPage(String condition, User cUser) {
		JSONObject json = JSONObject.fromObject(condition);
		Member member = new Member();
		if(cUser.getRole().getType() == config.INT_ISOCNO) {//家协端查询
			member.setIsocid(cUser.getRole().getRelationid());
			member.setShstatus(1);
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				member.setName(whereObj.getString("name").trim());
			}
		}
		QueryResult<MemberExtend> memberQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		memberQ.setList(memberDao.findByPageList((memberQ.getPageIndex()-1)*memberQ.getPageSize(),memberQ.getPageSize(),member));
		memberQ.setTotalRow(memberDao.findCountByCondition(member));
		return memberQ;
	}

	@Override
	public List<MemberRecord> findMemberRecordByMemberid(int memberid) {
		return memberRecordDao.findByMemberid(memberid);
	}

	@Override
	public int update(Member m) {
		Member member = memberDao.selectByPrimaryKey(m.getMemberid());
		if(member == null || member.getShstatus() != 1){
			return 426;
		}
		m.setIsocid(member.getIsocid());
		m.setBusinessid(member.getBusinessid());
		m.setShstatus(1);
		return memberDao.updateByPrimaryKey(m);
	}

	@Override
	public int delete(int memberid) {
		Member member = memberDao.selectByPrimaryKey(memberid);
		if(member == null || member.getShstatus() != 1){
			return 426;
		}
		IsocMember im = isocMemberDao.findByMemberid(member.getMemberid());
		if(im == null){
			return 426;
		}
		//查询出当前会员企业的认证信息
		IsocIdentificationBusiness iib = isocIdentificationBusinessDao.findByIsocidAndBusinessid(member.getIsocid(),member.getBusinessid());
		if(iib != null && DateUtil.getDaysByTwoSTRDate(DateUtil.getCurrentDate(), iib.getEnddate()) > 0){//认证未到期，不能删除
			return 478;
		}
		//查询出企业账号
		User user = userDao.findByBusinessid(member.getBusinessid());
		if(iib != null){//判断是否删除认证或授权（包括认证授权菜单）
			//删除认证关联
			isocIdentificationBusinessDao.deleteByPrimaryKey(iib.getIsocidentificationbusinessid());
			//查询该企业是否是其他家协的认证企业
			List<IsocIdentificationBusinessExtend> iibList = isocIdentificationBusinessDao.findByBusinessid(member.getBusinessid());
			if(iibList == null || iibList.size() == 0){
				//删除认证企业的菜单权限
				deleteBusinessRoleModule(config.STR_B_SEAUDIT_MODULENAME,user.getRoleid());
			}
			//查询该企业是否是当前家协的授权企业
			IsocEmpowerFirm firm = isocEmpowerFirmDao.findByIsocidAndBusinessid(member.getIsocid(),member.getBusinessid());
			if(firm != null && firm.getStatus() == 1){
				//删除授权关联
				firm.setStatus(0);
				isocEmpowerFirmDao.updateByPrimaryKey(firm);
				//查询该企业是否是其他家协的授权企业
				List<IsocEmpowerFirm> iefList = isocEmpowerFirmDao.findByBusinessid(member.getBusinessid());
				if(iefList == null || iefList.size() == 0) {
					//删除授权相关企业菜单
					deleteBusinessRoleModule(config.STR_B_CEAUDIT_MODULENAME,user.getRoleid());
				}
			}
		}
		//删除会员企业关联
		isocMemberDao.deleteByPrimaryKey(im.getIsocmemberid());
		//将会员申请信息设置为删除状态
		member.setShstatus(3);
		memberDao.updateByPrimaryKey(member);
		//查询当前企业是否是其他家协的会员单位
		List<IsocMember> imList = isocMemberDao.findByBusinessid(member.getBusinessid());
		if(imList == null || imList.size() == 0){
			//删除企业认证菜单
			deleteBusinessRoleModule(config.STR_B_BAUTH,user.getRoleid());
		}
		return 1;
	}
	
	/**
	 * 传入菜单名称，角色id，删除该角色的菜单权限
	 */
	public void deleteBusinessRoleModule(List<String> modulename,int roleid) {
		for (int i = 0; i < modulename.size(); i++) {
			RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(roleid,modulename.get(i),config.INT_BUSINESS);
			if(rm != null){
				roleModuleDao.deleteByPrimaryKey(rm.getRolemoduleid());
			}
		}
	}

	@Override
	public QueryResult<MemberExtend> findAllMembersByCondition(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		Member member = new Member();
		if(user.getRole().getType() == config.INT_ISOCNO) {//家协端查询
			member.setIsocid(user.getRole().getRelationid());
		}else if(user.getRole().getType() == config.INT_BUSINESS) {//企业端查询
			member.setBusinessid(user.getRole().getRelationid());
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				member.setName(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("shstatus") && whereObj.get("shstatus") instanceof Integer && 
				whereObj.getInt("shstatus") >= 0 && whereObj.getInt("shstatus") <= 3){
				member.setShstatus(whereObj.getInt("shstatus"));
			}
		}
		QueryResult<MemberExtend> memberQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		memberQ.setList(memberDao.findByPageList((memberQ.getPageIndex()-1)*memberQ.getPageSize(),memberQ.getPageSize(),member));
		memberQ.setTotalRow(memberDao.findCountByCondition(member));
		return memberQ;
	}

	@Override
	public int updatePassOrRejectApply(Member member) {
		//查询出当前申请
		Member m1 = memberDao.selectByPrimaryKey(member.getMemberid());
		if(m1 == null || m1.getShstatus() != 0){
			return 426;
		}
		//查询当前企业是否在该家协存在申请或通过申请
		Member m2 = memberDao.findApplyingOrPassApplyByBusinessidAndIsocid(m1.getBusinessid(),m1.getIsocid());
		if(m2 != null && m2.getMemberid() != m1.getMemberid()){
			return 426;
		}
		MemberRecord record = new MemberRecord();
		record.setMemberid(member.getMemberid());
		if(member.getShstatus() == 1){//通过审核
			m1.setShstatus(1);
			m1.setResult("审核通过");
		}else if(member.getShstatus() == 2){//驳回申请
			m1.setShstatus(2);
			m1.setResult(member.getResult());
		}else{
			return 426;
		}
		record.setResult(m1.getResult());
		//跟新申请
		memberDao.updateByPrimaryKey(m1);
		memberRecordDao.insert(record);
		if(m1.getShstatus() == 1){//审核通过，新建家协会员关联
			IsocMember im = new IsocMember();
			im.setIsocid(m1.getIsocid());
			im.setBusinessid(m1.getBusinessid());
			im.setMemberid(m1.getMemberid());
			isocMemberDao.insert(im);
			
			User user = userDao.findByBusinessid(m1.getBusinessid());
			//查询该企业是否有企业认证权限
			for (int i = 0; i < config.STR_B_BAUTH.size(); i++) {
				RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(user.getRoleid(), config.STR_B_BAUTH.get(i),config.INT_BUSINESS);
				if(rm == null) {
					Module module = moduleDao.findByUrlAndSxmsystemid(config.STR_B_BAUTH.get(i),config.INT_BUSINESS);
					rm = new RoleModule(user.getRoleid(), module.getModuleid());
					roleModuleDao.insert(rm);
				}
			}
		}
		return 1;
	}

	@Override
	public int reApply(Member member) {
		Member m = memberDao.selectByPrimaryKey(member.getMemberid());
		if(m == null || m.getShstatus() != 2){//会员申请不存在或不为驳回状态
			return 426;
		}
		//验证当前企业在该会员下是否市会员单位或正在申请会员单位
		Member m2 = memberDao.findApplyingOrPassApplyByBusinessidAndIsocid(m.getBusinessid(),m.getIsocid());
		if(m2 != null){//存在申请或已是会员单位
			return 477;
		}
		member.setIsocid(m.getIsocid());
		member.setBusinessid(m.getBusinessid());
		member.setShstatus(0);
		memberDao.updateByPrimaryKey(member);
		return 1;
	}
}
