package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDuser Ա�����������ݷ��ʶ�����<br>
 * ������ 2004-11-09 18:30:40.418<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuser extends DBPrpDuserBase{
    private static Log logger = LogFactory.getLog(DBPrpDuser.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDuser(DBManager dbManager){
        super(dbManager);
    }
    /**
     * �������
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String userCode,boolean isChinese) throws Exception
    {
      String userName  = "" ;
      if(userCode==null)
      {
        userName = "" ;
        return userName;
      }
      else
      {
          if(userCode.equals(""))
          {
            userName = "";
            return userName;
          }
      }
      String statement = "Select * from PrpDuser Where usercode='" + userCode + "'";

      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        if(isChinese)
        {
          userName = resultSet.getString("username");
        }
        else
        {
           userName = resultSet.getString("userename");
        }
      }
      resultSet.close();

      return userName;

    }

}
