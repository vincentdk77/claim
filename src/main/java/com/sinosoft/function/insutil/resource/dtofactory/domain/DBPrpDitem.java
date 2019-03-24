package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpditem的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDitem extends DBPrpDitemBase{
    private static Log log = LogFactory.getLog(DBPrpDitem.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDitem(DBManager dbManager){
        super(dbManager);
    }
    
    /**根据子险种代码，险种得到子险种名称
    *
    * @param userCode String
    * @param isChinese boolean
    * @throws Exception
    * @return String
    */
   public String translateCode(String riskCode,String itemCode,boolean isChinese) throws Exception
   {
     String codeName  = "" ;
     if(riskCode==null||itemCode==null)
     {
       codeName = "" ;
       return codeName;
     }
     else
     {
         if(riskCode.equals("")||itemCode.equals(""))
         {
           codeName = "";
           return codeName;
         }
     }
     String statement = "Select itemcname,itemename from PrpDitem Where riskCode='" + riskCode + "' AND itemCode='" + itemCode + "'";

     ResultSet resultSet = dbManager.executeQuery(statement);
     while(resultSet.next())
     {
       if(isChinese)
       {
         codeName = resultSet.getString("itemcname");
       }
       else
       {
          codeName = resultSet.getString("itemename");
       }
     }
     resultSet.close();
     log.info("DBPrpDkind.translate() success!");
     return codeName;

   }
}
