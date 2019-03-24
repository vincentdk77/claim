package com.sinosoft.claimzy.facade;
/**
 * 这是报案信息的数据访问类
 */
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.RegistInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpRegistInfoZY {
	 /**
    * 资源管理类的实例，处理数据库操作.
    */
   protected DBManager dbManager = new DBManager();
   private static Log logger = LogFactory.getLog(DBPrpRegistInfoZY.class);

   /**
    * 构造函数
    * @param dbManager 资源管理类
    */
   public DBPrpRegistInfoZY(DBManager dbManager){
	   this.dbManager = dbManager;
   }
   /**
    * 按主键查找数据
    * @throws Exception 
    * 
    */
   public RegistInfo findByPrimaryKey(String registNo) throws Exception{
   	StringBuffer buffer = new StringBuffer(200);
   	 //拼SQL语句
   	buffer.append("select ");
   	buffer.append("registNo, ");//报案号
   	buffer.append("reportorName, ");//报案人
   	buffer.append("phoneNumber, ");//电话
   	buffer.append("reportDate, ");//报案日期
   	buffer.append("damageName ");//出险原因
   	buffer.append("from prplregist ");
   	if(logger.isDebugEnabled()){
   		StringBuffer debugBuffer = new StringBuffer(buffer.length()*4);
   		debugBuffer.append(buffer.toString());
   		debugBuffer.append(" Where registNo=").append("'").append(registNo).append("'");
   		logger.debug(debugBuffer.toString());
   	}
   	buffer.append("Where registNo=? ");
    dbManager.prepareStatement(buffer.toString());
   	//设置条件字段
   	dbManager.setString(1, registNo);
   	ResultSet resultSet = dbManager.executePreparedQuery();
   	RegistInfo registInfo = new RegistInfo();;
   	if(resultSet.next()){
   		 registInfo.setNotificationNumber(dbManager.getString(resultSet, 1));//报案号
   	     //报案人(处理)
   		 String reptorName = dbManager.getString(resultSet, 2);
   		 if(reptorName.equals("")){
   			 registInfo.setNotifier("**");
   		 }else{
   			 registInfo.setNotifier(dbManager.getString(resultSet, 2));
   		 }
   		 registInfo.setNotifierTelephone(dbManager.getString(resultSet, 3));//联系电话
   		 registInfo.setNotificationTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 4));//报案时间
   		//出险原因转码
   		if(dbManager.getString(resultSet, 5).equals("暴雨")){
   			registInfo.setLossReason("103");//暴雨
    	}else if(dbManager.getString(resultSet, 5).equals("洪水")){
    		registInfo.setLossReason("105");//洪水
    	}else if(dbManager.getString(resultSet,5).equals("虫灾、虫害、病害")){
    		registInfo.setLossReason("401");//虫灾、虫害、病害
    	}else if(dbManager.getString(resultSet, 5).equals("草害")){
    		registInfo.setLossReason("402");//草害
    	}else if(dbManager.getString(resultSet, 5).equals("鼠害")){
    		registInfo.setLossReason("403");//鼠害
    	}else if(dbManager.getString(resultSet, 5).equals("内涝")){
    		registInfo.setLossReason("104");//内涝
    	}else if(dbManager.getString(resultSet, 5).equals("风灾")){
    		registInfo.setLossReason("101");//风灾
    	}else if(dbManager.getString(resultSet, 5).equals("冰雹、雹灾")){
    		registInfo.setLossReason("107");//冰雹、雹灾
    	}else if(dbManager.getString(resultSet, 5).equals("冷冻、冻灾")){
    		registInfo.setLossReason("109");//冷冻、冻灾
    	}else if(dbManager.getString(resultSet, 5).equals("干旱、旱灾")){
    		registInfo.setLossReason("106");//干旱、旱灾
    	}else{
    		registInfo.setLossReason("9");//其它
    	}
   	}
   	resultSet.close();
    return registInfo;
   	
   }
}
