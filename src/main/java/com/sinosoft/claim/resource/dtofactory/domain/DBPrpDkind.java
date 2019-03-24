package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdkind�ձ���������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDkind extends DBPrpDkindBase{
    private static Log log = LogFactory.getLog(DBPrpDkind.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDkind(DBManager dbManager){
        super(dbManager);
    }

    /**���������ִ��룬���ֵõ�����������
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

    /**���������ִ��룬���ֵõ���ѯ�����ܱ����־
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
