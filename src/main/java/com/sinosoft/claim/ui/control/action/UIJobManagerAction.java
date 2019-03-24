package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.claim.ui.model.JobManagerQueryCommand;
import com.sinosoft.claim.ui.model.JobManagerSaveCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class UIJobManagerAction {
	/**
	   * 保存班表
	   * @param JobManagerDto：班表对象DTO
	   * @throws Exception
	   */
	  public void save(JobManagerDto jobManagerDto) throws SQLException,Exception
	  {
		  JobManagerSaveCommand  jobManagerSaveCommand = new JobManagerSaveCommand(jobManagerDto);
		  jobManagerSaveCommand.execute();
	  }
	  
	  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerRecord) throws Exception{
		  
		  JobManagerQueryCommand claimQueryCommand = new JobManagerQueryCommand(conditions,pageNo,recordPerRecord);
		  return (PageRecord)claimQueryCommand.executeCommand();
	  }
	 /**
	  * 查询险类
	 * @throws Exception 
	  * */
	/*public Collection findClassCodeByConditions(String conditions) throws Exception {
		JobManagerQueryCommand claimQueryCommand = new JobManagerQueryCommand(conditions,0,0);
		return claimQueryCommand.executeClassCodeCommand();
		
	}*/
}
