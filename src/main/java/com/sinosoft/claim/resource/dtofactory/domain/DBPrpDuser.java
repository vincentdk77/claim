package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDuser 员工代码表的数据访问对象类<br>
 * 创建于 2004-11-09 18:30:40.418<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuser extends DBPrpDuserBase{
    private static Log logger = LogFactory.getLog(DBPrpDuser.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDuser(DBManager dbManager){
        super(dbManager);
    }
    /**
     * 翻译代码
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String userCode,boolean isChinese) throws Exception
    {
      String userName  = "" ;
      if(userCode==null)
      {
        userName = "" ;
        return userName;
      }
      else
      {
          if(userCode.equals(""))
          {
            userName = "";
            return userName;
          }
      }
      String statement = "Select * from PrpDuser Where usercode='" + userCode + "'";

      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          userName = resultSet.getString("username");
        }
        else
        {
           userName = resultSet.getString("userename");
        }
      }
      resultSet.close();

      return userName;

    }

}
