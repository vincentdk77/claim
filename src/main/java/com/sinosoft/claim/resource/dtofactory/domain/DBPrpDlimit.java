package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdlimit限额免赔代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDlimit extends DBPrpDlimitBase{
    private static Log log = LogFactory.getLog(DBPrpDlimit.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDlimit(DBManager dbManager){
        super(dbManager);
    }
    
    public String translateLimit(String riskCode,String limitCode,boolean isChinese) throws Exception
    {
      String limitName  = "" ;
      if(riskCode==null||limitCode==null)
      {
      	limitName = "" ;
        return limitName;
      }
      else
      {
          if(riskCode.equals("")||limitCode.equals(""))
          {
          	limitName = "";
            return limitName;
          }
      }
      String statement = "Select * from PrpDlimit Where riskCode='" + riskCode + "' AND limitCode='" + limitCode + "'";
      log.debug(statement);
      ResultSet resultSet =dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
        	limitName = resultSet.getString("limitcname");
        }
        else
        {
        	limitName = resultSet.getString("limitcname");
        }
      }
      resultSet.close();
      log.info("DBPrpDlimit.translate() success!");
      return limitName;

    }
    
    
    
    
}
