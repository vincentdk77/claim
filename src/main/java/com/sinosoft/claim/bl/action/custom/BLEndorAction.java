package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBEndor;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ��������߼�
 * <p>Title: ����������������</p>
 * <p>Description: ����������������������action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ����������Ŀ��
 * @version 1.0
 */
public class BLEndorAction
{
  public BLEndorAction()
  {
  }

  /**
   * ����������
   * @param endorDto���Զ������������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,EndorDto endorDto)
    throws SQLException,Exception
  {
    DBEndor dbEndor = null;
    //ҵ�����
    dbEndor = new DBEndor();
    dbEndor.insert(dbManager,endorDto);
  }

}
