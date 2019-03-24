package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdkind险别代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDkind extends DBPrpDkindBase{
    private static Log log = LogFactory.getLog(DBPrpDkind.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDkind(DBManager dbManager){
        super(dbManager);
    }

    /**根据子险种代码，险种得到子险种名称
     *
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String riskCode,String kindCode,boolean isChinese) throws Exception
    {
      String codeName  = "" ;
      if(riskCode==null||kindCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(riskCode.equals("")||kindCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDkind Where riskCode='" + riskCode + "' AND kindcode='" + kindCode + "'";
      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          codeName = resultSet.getString("kindcname");
        }
        else
        {
           codeName = resultSet.getString("kindename");
        }
      }
      resultSet.close();
      log.info("DBPrpDkind.translate() success!");
      return codeName;

    }

    /**根据子险种代码，险种得到查询计入总保额标志
     *
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCalculateFlag(String riskCode,String kindCode) throws Exception
    {
      String codeName  = "" ;
      if(riskCode==null||kindCode==null)
      {
        codeName = "" ;
        return codeName;
      }
      else
      {
          if(riskCode.equals("")||kindCode.equals(""))
          {
            codeName = "";
            return codeName;
          }
      }
      String statement = "Select * from PrpDkind Where riskCode='" + riskCode + "' AND kindcode='" + kindCode + "'";
      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
          codeName = resultSet.getString("CalculateFlag");
      }
      resultSet.close(); 
      log.info("DBPrpDkind.translateCalculateFlag() success!");
      return codeName;

    }
}
