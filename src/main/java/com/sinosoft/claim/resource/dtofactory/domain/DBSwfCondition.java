package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfConditionDto工作流条件描述表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.892<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfCondition extends DBSwfConditionBase{
    private static Log logger = LogFactory.getLog(DBSwfCondition.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfCondition(DBManager dbManager){
        super(dbManager);
    }

      /**
     * 查询业务数据是否满足条件的约束
     * @param conditions
     * @return boolean
     * @throws Exception
     */
    public boolean executeResult(String conditions)
        throws Exception{
        boolean  result =false;
        int count =-1;
        String statement = conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBClaim.getConditionExecuteResult() success!");
        if (count>0)
        {
          result=true;
        }

        return result;
    }

}
