package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLogStore�����ݷ��ʶ�����<br>
 * ������ 2006-12-08 11:24:40.390<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfLogStore extends DBSwfLogStoreBase{
    private static Log logger = LogFactory.getLog(DBSwfLogStore.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfLogStore(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * ��ȡlogno��
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxLogNo(String flowID)
        throws Exception{
        int LogNo = -1;
        String statement = "Select max(LogNo+1) from swfLogstore Where flowID='" +flowID+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        LogNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogStore.getMaxLogNo() success!");
        if (LogNo==0)
        {
          LogNo=1;
        }

        return LogNo ;
    }
    
    /**
     * ��ȡlogno��
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxNodeLogNo(String flowID,String nodeType,String businessNo)
        throws Exception{
        int LogNo = -1;
        String statement = "Select max(LogNo) from swfLogstore Where flowID='" +flowID+"' and  nodeType='"+ nodeType +"' and businessNo='"+businessNo+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        LogNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogStore.getMaxLogNo() success!");
        if (LogNo==0)
        {
          LogNo=1;
        }

        return LogNo ;
    }
    
}
