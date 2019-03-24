package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMainWF的数据访问对象类<br>
 * 创建于 2005-03-18 16:42:20.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleMainWF extends DBPrpLscheduleMainWFBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleMainWF.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleMainWF(DBManager dbManager){
        super(dbManager);
    }
     /**
     * 获取调度号
     * @param registNo
     * @return scheduleID
     * @throws Exception
     */
    public int getNo(String registNo)
        throws Exception{
        int scheduleID = -1;
        String statement = "Select max(scheduleID+1) from PrpLscheduleMainWF Where registNo='" + registNo+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        scheduleID  = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleMainBase.getCount() success!");
        if (scheduleID==0)
        {
          scheduleID=1;
        }

        return scheduleID ;
    }

    /**
     * 按条件更新数据  add by liyannjie 2005-12-11 for:双代标志更新
     * @param String condition 
     * @throws Exception
     */
    public void updateByCondition(String condition) 
        throws Exception
	{
        
    	String statement = " Update PrpLscheduleMainWF Set " + condition;
    	logger.debug(statement);
		dbManager.prepareStatement(statement);
		dbManager.executePreparedUpdate();
		logger.info("DBPrpLscheduleMainWF.updateByCondition() success!");
    }
    
}
