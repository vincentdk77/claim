package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmessage理赔流转讨论留言表的数据访问对象类<br>
 * 创建于 2004-07-27 16:11:38.158<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLmessage extends DBPrpLmessageBase{
    private static Log logger = LogFactory.getLog(DBPrpLmessage.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLmessage(DBManager dbManager){
        super(dbManager);
    }

    /**
    * 获取序号
    * @param registNo
    * @return messageID
    * @throws Exception
    */
   public int getNo(String registNo)
       throws Exception{
       int messageID = -1;
       String statement = "Select max(serialNo+1) from PrpLmessage Where RegistNo='" +registNo+"'";
       logger.debug(statement);
       ResultSet resultSet = dbManager.executeQuery(statement);
       resultSet.next();
       messageID  = dbManager.getInt(resultSet,1);
       resultSet.close();
       logger.info("DBPrpLmessageBase.getCount() success!");
       if (messageID==0)
       {
         messageID=1;
       }

       return messageID ;
   }


}
