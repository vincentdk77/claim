package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcurrency�ұ���������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcurrency extends DBPrpDcurrencyBase{
    private static Log log = LogFactory.getLog(DBPrpDcurrency.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcurrency(DBManager dbManager){
        super(dbManager);
    }

    /**
     * �������
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
