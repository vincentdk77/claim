package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLogStore的数据访问对象类<br>
 * 创建于 2006-12-08 11:24:40.390<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfLogStore extends DBSwfLogStoreBase{
    private static Log logger = LogFactory.getLog(DBSwfLogStore.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfLogStore(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 获取logno号
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
     * 获取logno号
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
