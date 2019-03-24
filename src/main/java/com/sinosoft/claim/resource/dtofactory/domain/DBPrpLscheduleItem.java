package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleItem���������ı�����ݷ��ʶ�����<br>
 * ������ 2004-07-15 21:00:43.195<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleItem extends DBPrpLscheduleItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleItem.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleItem(DBManager dbManager){
        super(dbManager);
    }
    
    
    /**
     * ��������������  add by liyannjie 2005-12-11 for:˫����־����
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
