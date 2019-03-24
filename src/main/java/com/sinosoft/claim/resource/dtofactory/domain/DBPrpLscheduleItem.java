package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLscheduleItem调度任务标的表的数据访问对象类<br>
 * 创建于 2004-07-15 21:00:43.195<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleItem extends DBPrpLscheduleItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleItem.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleItem(DBManager dbManager){
        super(dbManager);
    }
    
    
    /**
     * 按条件更新数据  add by liyannjie 2005-12-11 for:双代标志更新
     * @param String condition 
     * @throws Exception
     */
    public void updateByCondition(String condition) 
        throws Exception
	{
        
    	String statement = " Update PrpLscheduleItem Set " + condition;
    	logger.debug(statement);
		dbManager.prepareStatement(statement);
		dbManager.executePreparedUpdate();
		logger.info("DBPrpLscheduleItem.updateByCondition() success!");
    }
    
}
