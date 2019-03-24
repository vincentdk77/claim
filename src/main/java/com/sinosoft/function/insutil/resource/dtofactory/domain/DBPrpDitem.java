package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpditem�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDitem extends DBPrpDitemBase{
    private static Log log = LogFactory.getLog(DBPrpDitem.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDitem(DBManager dbManager){
        super(dbManager);
    }
    
    /**���������ִ��룬���ֵõ�����������
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
