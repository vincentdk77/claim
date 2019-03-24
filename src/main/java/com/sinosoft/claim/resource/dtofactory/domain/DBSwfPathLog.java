package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPATHLOG工作流路径日志表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.942<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfPathLog extends DBSwfPathLogBase{
    private static Log logger = LogFactory.getLog(DBSwfPathLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfPathLog(DBManager dbManager){
        super(dbManager);
    }
    
     /**
     * 获取pathno号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxPathNo(String flowID)
        throws Exception{
        int PathNo = -1;
        String statement = "Select max(PathNo+1) from SwfPathLog Where flowID='" +flowID+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        PathNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBwfpathlog.getMaxPathNo() success!");
        if (PathNo==0)
        {
          PathNo=1;
        }

        return PathNo ;
    }
}
