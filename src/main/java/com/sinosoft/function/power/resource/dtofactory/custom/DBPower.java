package com.sinosoft.function.power.resource.dtofactory.custom;
/**
 * <p>Title: ��ԱȨ�޴���</p>
 * <p>Description: �ڵ���ԱȨ�޴���</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ�� κʿ��
 * @version 1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.DBManager;


public class DBPower {
  protected DBManager dbManager = null; //��Դ������
  private static Log logger = LogFactory.getLog(DBPower.class);

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBPower(DBManager dbManager){
      this.dbManager = dbManager;
  }


 /**
  * ���ݸ�λ�����񣩼����֣������������ĳ��λ����ԱȨ��
  * @param conditions String
  * @throws SQLException
  * @throws Exception
  * @return Collection
  */
 public Collection findByTask(String conditions) throws SQLException,Exception
   {
       Collection powerList = new ArrayList();
       String statement = "";

       //����������ѯ
       logger.debug(conditions);

       PrpDuserDto prpDuserDto = null;
       ResultSet resultSet = dbManager.executeQuery(conditions);
       int count=0;

       while(resultSet.next())
       {
           count++;

           prpDuserDto = new PrpDuserDto();
           prpDuserDto.setUserCode(dbManager.getString(resultSet,1));
           prpDuserDto.setUserName(dbManager.getString(resultSet,2));
           powerList.add(prpDuserDto);
       }
       resultSet.close();
       logger.info("DBPower.findByTask() success!");
       return powerList;

   }

}
