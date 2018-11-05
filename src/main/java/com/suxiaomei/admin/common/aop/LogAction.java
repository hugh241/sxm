package com.suxiaomei.admin.common.aop;

import java.lang.reflect.Method;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Log;
import com.suxiaomei.admin.entity.isoc.IsocLog;
import com.suxiaomei.admin.service.common.LogService;
import com.suxiaomei.admin.service.isoc.IsocLogService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.Util;
import com.suxiaomei.admin.util.redis.TokenUtil;
import com.suxiaomei.admin.util.redis.UserToken;

@Aspect
public class LogAction {
	@Autowired
    private LogService logservice;
	@Autowired
    private IsocLogService iLogservice;
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
    //配置接入点
    @Pointcut("execution(* com.suxiaomei.admin.controller.api..*.*(..))")  
    private void controllerAspect(){
    }//定义一个切入点
     
    @Before("controllerAspect() && args(name)")
    public void doAccessCheck(String name){
    }
    
    @AfterReturning("controllerAspect()")
    public void doAfter(){
    }
    
    @After("controllerAspect()")
    public void after(){
    }
    
    @AfterThrowing("controllerAspect()")
    public void doAfterThrow(){
    }
    
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //常见日志实体对象
        Log log = new Log();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getHeader("username") != null){
        	String name = URLDecoder.decode(URLDecoder.decode(request.getHeader("username"),"utf-8"),"utf-8");
            log.setUserid(name);
        }
        //获取系统时间
        log.setDate(DateUtil.getCurrentTime());
        
        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        String ip = Util.getIpAddress(request);
        log.setIp(ip);
        
       //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
       // 拦截的实体类，就是当前正在执行的controller
       Object target = pjp.getTarget();
       // 拦截的方法名称。当前正在执行的方法
       String methodName = pjp.getSignature().getName();
       // 拦截的方法参数
       Object[] args = pjp.getArgs();
       // 拦截的放参数类型
       Signature sig = pjp.getSignature();
       MethodSignature msig = null;
       if (!(sig instanceof MethodSignature)) {
           throw new IllegalArgumentException("该注解只能用于方法");
       }
       msig = (MethodSignature) sig;
       @SuppressWarnings("rawtypes")
       Class[] parameterTypes = msig.getMethod().getParameterTypes();
       
       Object object = null;
       // 获得被拦截的方法
       Method method = null;
       try {
           method = target.getClass().getMethod(methodName, parameterTypes);
       } catch (NoSuchMethodException e1) {
           e1.printStackTrace();
       } catch (SecurityException e1) {
           e1.printStackTrace();
       }
       if (null != method) {
    	   long end = 0;
    	   if(method.isAnnotationPresent(SystemLog.class) || method.isAnnotationPresent(IIsocLog.class)) {
    		   if (method.isAnnotationPresent(SystemLog.class)) {//是否存在系统注释
                   SystemLog systemlog = method.getAnnotation(SystemLog.class);
                   log.setModule(systemlog.module());
                   log.setMethod(systemlog.methods());
                   if(systemlog.methods().equals("用户-登陆") && args.length > 0 && args[0] instanceof User){
                	   log.setUserid(((User)args[0]).getUsername());
                   }
               }
			   IsocLog Ilog = null;
    		   if(method.isAnnotationPresent(IIsocLog.class)) {//是否存在家协注释
            	   String token = ((HttpServletRequest) request).getHeader("token");
            	   if(token != null) {
            		   UserToken userToken = (UserToken) TokenUtil.getStaticUserToken(redisTemplate,token);
        	   		   if(userToken != null && userToken.getUser() != null){
        	   			   User user = userToken.getUser();
        	   			   if(user.getRole().getType() == 5) {
        	   				   Ilog = new IsocLog();
        		         	   Ilog.setDate(log.getDate());
        		         	   Ilog.setIp(log.getIp());
        		         	   IIsocLog systemlog = method.getAnnotation(IIsocLog.class);
        		         	   Ilog.setRemark(log.getUserid()+systemlog.module()+"-"+systemlog.methods());
        	   			   }
        	   		   }
            	   }
               }
    		   object = pjp.proceed();
    		   if (method.isAnnotationPresent(SystemLog.class)) {//是否存在系统注释
    			   end = System.currentTimeMillis();
                   //将计算好的时间保存在实体中
                   log.setResponseData(""+(end-start));
                   log.setCommite("执行成功！");
                   logservice.saveLog(log);
    		   }
    		   if(Ilog != null) {//是否存在家协注释
    			   end = System.currentTimeMillis();
                   //将计算好的时间保存在实体中
                   Ilog.setResponseDate((int) (end-start));
                   Ilog.setCommite("执行成功！");
             	   iLogservice.saveLog(Ilog);
    		   }
    	   }else {//没有包含注解
    		   object = pjp.proceed();
    	   }
       } else { //不需要拦截直接执行
           object = pjp.proceed();
       }
       return object;
    }
}