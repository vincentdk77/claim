package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdlimit�޶�������������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDlimit extends DBPrpDlimitBase{
    private static Log log = LogFactory.getLog(DBPrpDlimit.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
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
