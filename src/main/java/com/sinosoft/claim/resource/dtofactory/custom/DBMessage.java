package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmessage;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ������ת��������DB��
 * <p>Title:������ת��������DB�� </p>
 * <p>Description:������ת��������DB�� </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author Sunhao
 * @version 1.0
 */
public class DBMessage {
  /**
   * Ĭ�Ϲ��캯��
   */
  public DBMessage() {
  }

  /**
   * ��������
   * @param dbManager DBManager
   * @param prpLmessageDto prpLmessageDto
   * @throws SQLException
   * @throws Exception
   */
  public void insert(DBManager dbManager,PrpLmessageDto prpLmessageDto
  ) throws SQLException,Exception
  {
    new DBPrpLmessage(dbManager).insert(prpLmessageDto);
  }

  /*
     * ���ȡ�÷���
     * @param serialNo ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public int getNo(DBManager dbManager,String registNo)
      throws SQLException,Exception
    {
         return new DBPrpLmessage(dbManager).getNo(registNo);
    }


}
