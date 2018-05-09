/** 
 * <pre>项目名称:mystical-organization 
 * 文件名称:LogRecord.java 
 * 包名:com.jk.common.aopAspect 
 * 创建日期:2018年3月20日下午9:36:27 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.common.aopAspect;

import com.jk.model.Logs;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LogRecord{
	private static final long serialVersionUID = 1596289900448371494L;
	private Logger logger=Logger.getLogger(LogRecord.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	private Long startTime;
	private Long endTime;
	public void beforeThead(){
		startTime=new Date().getTime();
		System.out.println("前置调用");
	}
	public void afterThead(JoinPoint jp,Object retValue){
		
		endTime=new Date().getTime();
		System.out.println("后置调用");
		//Long time=(endTime-startTime)/1000;
		//类名
		String clazzName=null;
		try {
			clazzName = Class.forName(jp.getTarget().getClass().getName()).getSimpleName();
			//System.out.println("在类名为"+clazzName+"，方法名为"+jp.getSignature().getName()+"的方法运行时间为"+time+"秒");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//方法名
		String methodName = jp.getSignature().getName();
		
		    Object[] paramValues = jp.getArgs();  
		    String[] paramNames = ((CodeSignature) jp.getSignature()).getParameterNames();  
		    String params=null;
		    for(int i=0;i<paramNames.length;i++){  
		    	params+=paramNames[i]+":"+paramValues[i]+",";  
		    }
		Logs logs=new Logs();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String time=sdf.format(now);
		logs.setParams(params);
		logs.setClazzName(clazzName);
		logs.setMethodName(methodName);
		logs.setTime(time);
		//System.out.println(retValue.toString());
		mongoTemplate.insert(logs);
		logger.info("类名:"+clazzName+",方法名:"+methodName+",参数与参数名:"+params+",操作时间是:"+now);
	}

	 /*public void throwThead(JoinPoint jp,Object retValue){
			endTime=new Date().getTime();
			System.out.println("异常通知");
			//Long time=(endTime-startTime)/1000;
			//类名
			String clazzName=null;
			try {
				clazzName = Class.forName(jp.getTarget().getClass().getName()).getSimpleName();
				//System.out.println("在类名为"+clazzName+"，方法名为"+jp.getSignature().getName()+"的方法运行时间为"+time+"秒");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//方法名
			String methodName = jp.getSignature().getName();
			
			    Object[] paramValues = jp.getArgs();  
			    String[] paramNames = ((CodeSignature) jp.getSignature()).getParameterNames();  
			    String params=null;
			    for(int i=0;i<paramNames.length;i++){  
			    	params+=paramNames[i]+":"+paramValues[i]+",";  
			    } 
			Logs logs=new Logs();
			logs.setParams(params);
			logs.setClazzName(clazzName);
			logs.setMethodName(methodName+"发生异常");
			//System.out.println(retValue.toString());
			mongoTemplate.insert(logs);
			logger.info("类名:"+clazzName+",方法名:"+methodName+"参数与参数名:"+params);
		}*/

}
