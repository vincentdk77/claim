
package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleAddCertainLoss;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 新增定损调度action
 * <p>Title: 车险理赔 新增定损调度acton</p>
 * <p>Description: 车险理赔 新增定损调度acton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class BLScheduleCertainLossAction {
	
	public BLScheduleCertainLossAction(){
		
	}
	
	  /**
	   * 保存新增定损调度
	   * @param checkDto：自定义新增定损调度对象
	   * @param dbManager  数据连接
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
