
package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleAddCertainLoss;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����������action
 * <p>Title: �������� �����������acton</p>
 * <p>Description: �������� �����������acton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class BLScheduleCertainLossAction {
	
	public BLScheduleCertainLossAction(){
		
	}
	
	  /**
	   * ���������������
	   * @param checkDto���Զ�������������ȶ���
	   * @param dbManager  ��������
	   * @throws SQLException
	   * @throws Exception
	   */
	  public void save(DBManager dbManager,CheckDto checkDto)
	    throws SQLException,Exception
	  {
	  	DBScheduleAddCertainLoss dBScheduleAddCertainLoss = null;
	  	
	  	dBScheduleAddCertainLoss = new DBScheduleAddCertainLoss();

	  	dBScheduleAddCertainLoss.insert(dbManager,checkDto);
	  }
}
