package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcurrency币别代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcurrency extends DBPrpDcurrencyBase{
    private static Log log = LogFactory.getLog(DBPrpDcurrency.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcurrency(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 翻译代码
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String currencyCode,boolean isChinese) throws Exception
    {
      String codeName  = "" ;
      if(currencyCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(currencyCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDcurrency Where currencycode='" + currencyCode + "'";
      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          codeName = resultSet.getString("currencycname");
        }
        else
        {
           codeName = resultSet.getString("currencyename");
        }
      }
      resultSet.close();
      log.info("DBPrpDcurrency.translate() success!");
      return codeName;

    }

}
