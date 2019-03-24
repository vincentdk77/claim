package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfModelMain模板主表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.852<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfModelMain extends DBSwfModelMainBase{
    private static Log logger = LogFactory.getLog(DBSwfModelMain.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfModelMain(DBManager dbManager){
        super(dbManager);
    }

 /**
 * 获取modelNo
 * @return ModelNo
 * @throws Exception
 */
public int getModelNo()
    throws Exception{
    int modelNo = -1;
    String statement = "Select max(modelNo+1) from SwfModelMain";
    logger.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next();
    modelNo  = dbManager.getInt(resultSet,1);
    resultSet.close();
    if (modelNo==0)
    {
      modelNo=1;
    }

    return modelNo ;
}

}
