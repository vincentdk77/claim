package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMainWF�����ݷ��ʶ�����<br>
 * ������ 2005-03-18 16:42:20.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleMainWF extends DBPrpLscheduleMainWFBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleMainWF.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleMainWF(DBManager dbManager){
        super(dbManager);
    }
     /**
     * ��ȡ���Ⱥ�
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
     * ��������������  add by liyannjie 2005-12-11 for:˫����־����
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
