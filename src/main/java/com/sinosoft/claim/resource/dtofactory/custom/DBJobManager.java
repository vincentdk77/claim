package com.sinosoft.claim.resource.dtofactory.custom;

import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLJobLinker;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanagertime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBJobManager {
	private DBManager dbManager = null; //资源管理类
	
	 public void insert(DBManager dbManager,JobManagerDto JobManagerDto) throws Exception{
		 if(JobManagerDto.getPrpljobmanagerDtoList() != null){
			 new DBPrpljobmanager(dbManager).insertAll(JobManagerDto.getPrpljobmanagerDtoList());
		 }
		 
		 if(JobManagerDto.getPrpljobmanagertimeDtoList() != null){
			 new DBPrpljobmanagertime(dbManager).insertAll(JobManagerDto.getPrpljobmanagertimeDtoList());
		 }
		 if(JobManagerDto.getPrpLJobLinkerDtoList() != null){
			 new DBPrpLJobLinker(dbManager).insertAll(JobManagerDto.getPrpLJobLinkerDtoList());
		 }
		 
	 }
	 
	 /**
	  * 删除班表
	  * @param dbManager
	  * @param id
	 * @throws Exception 
	  */
	 public void delete(DBManager dbManager,String id) throws Exception{
		 String condition = " fid = '" + StringUtils.rightTrim(id) + "'";
		    //示例未完成
		    String statement = " DELETE FROM prplJobManagerTime Where " + condition ;
		    dbManager.executeUpdate(statement);
	 }
}
