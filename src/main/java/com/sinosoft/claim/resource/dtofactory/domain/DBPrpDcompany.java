package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.SysConfig;

/**
 * ����prpdcompany�������������ݷ��ʶ�����<br>
 * ������ 2004-08-25 16:51:29.092<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcompany extends DBPrpDcompanyBase{
    private static Log logger = LogFactory.getLog(DBPrpDcompany.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcompany(DBManager dbManager){
        super(dbManager);
    }

    /**
     * �������
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
     * ʵ��db2�ĵݹ����
     * ����
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
