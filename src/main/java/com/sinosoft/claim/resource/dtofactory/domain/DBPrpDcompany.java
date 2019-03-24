package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.SysConfig;

/**
 * 这是prpdcompany机构代码表的数据访问对象类<br>
 * 创建于 2004-08-25 16:51:29.092<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcompany extends DBPrpDcompanyBase{
    private static Log logger = LogFactory.getLog(DBPrpDcompany.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcompany(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 翻译代码
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String comCode,boolean isChinese) throws Exception
    {
      String codeName  = "" ;
      if(comCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(comCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDcompany Where comcode='" + comCode + "'";

      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          codeName = resultSet.getString("comcname");
        }
        else
        {
           codeName = resultSet.getString("comename");
        }
      }
      resultSet.close();

      return codeName;

    }
    /*
     * 实现db2的递归操作
     * 郭磊
     * 
     */
    public String getRecursionComCode(String conditions) throws Exception
    {
      String comCode  = "" ;
      ResultSet resultSet = dbManager.executeQuery(conditions);
      while(resultSet.next())
      { 
    	  comCode=comCode+"'"+resultSet.getString("comcode")+"',";
      }
     if(comCode.endsWith(","))
      comCode=comCode.substring(0, comCode.length()-1);
      resultSet.close();
      String dbType=SysConfig.getProperty("DBTYPE");   
      return comCode;

    }
}
