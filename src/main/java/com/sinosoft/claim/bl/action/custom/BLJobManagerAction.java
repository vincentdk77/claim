package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBJobManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLJobManagerAction {
	public void save(DBManager dbManager,JobManagerDto jobManagerDto) throws Exception{
		DBJobManager dbJobManager = null;
		dbJobManager = new DBJobManager();
		if(jobManagerDto != null){
			String prpljobmanagerDtoSQL = "";
			String prplJobManagerTimeSQL = "";
			String prpLJobLinkerSQL = "";
			//jobManagerDto表中UpdateType字段 判断是机构修改或个人修改
			if("institution".equals(jobManagerDto.getUpdateType())){//机构修改
				if(jobManagerDto.getPrpljobmanagerDto() != null && !"".equals(jobManagerDto.getPrpljobmanagerDto())){
					prplJobManagerTimeSQL = " DELETE FROM prplJobManagerTime Where fid in (select id from prpljobmanager Where classcode='"+jobManagerDto.getPrpljobmanagerDto().getClasscode()+"' and month='"+jobManagerDto.getPrpljobmanagerDto().getMonth()+"' and handledept='"+jobManagerDto.getPrpljobmanagerDto().getHandledept()+"')";
					prpljobmanagerDtoSQL = " DELETE FROM prpljobmanager Where classcode='"+jobManagerDto.getPrpljobmanagerDto().getClasscode()+"' and month='"+jobManagerDto.getPrpljobmanagerDto().getMonth()+"' and handledept='"+jobManagerDto.getPrpljobmanagerDto().getHandledept()+"'";
					dbManager.executeUpdate(prplJobManagerTimeSQL);
					dbManager.executeUpdate(prpljobmanagerDtoSQL);
					//删除联系人信息
					prpLJobLinkerSQL = " DELETE FROM PrpLJobLinker Where classcode='"+jobManagerDto.getPrpljobmanagerDto().getClasscode()+"' and month='"+jobManagerDto.getPrpljobmanagerDto().getMonth()+"' and handledept='"+jobManagerDto.getPrpljobmanagerDto().getHandledept()+"'";
					dbManager.executeUpdate(prpLJobLinkerSQL);
					
				}
			}else{//个人修改
				if(jobManagerDto.getPrpljobmanagerDto() != null && !"".equals(jobManagerDto.getPrpljobmanagerDto())){
					prplJobManagerTimeSQL = " DELETE FROM prplJobManagerTime Where fid in (select id from prpljobmanager Where classcode= '"+ jobManagerDto.getPrpljobmanagerDto().getClasscode() +"' and month='"+jobManagerDto.getPrpljobmanagerDto().getMonth()+"' and handledept='"+jobManagerDto.getPrpljobmanagerDto().getHandledept()+"' and handlercode='"+jobManagerDto.getPrpljobmanagerDto().getHandlercode()+"')";
					prpljobmanagerDtoSQL = " DELETE FROM prpljobmanager Where classcode = '"+ jobManagerDto.getPrpljobmanagerDto().getClasscode() +"' and month='"+jobManagerDto.getPrpljobmanagerDto().getMonth()+"' and handledept='"+jobManagerDto.getPrpljobmanagerDto().getHandledept()+"' and handlercode='"+jobManagerDto.getPrpljobmanagerDto().getHandlercode()+"'";
					dbManager.executeUpdate(prplJobManagerTimeSQL);
					dbManager.executeUpdate(prpljobmanagerDtoSQL);
				}
			}
		}
		dbJobManager.insert(dbManager,jobManagerDto);
	}
	
	/**
	 * 判断是否存在班表信息
	 * @param dbManager
	 * @param registNo
	 * @return 
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean isExist(DBManager dbManager,String id)throws SQLException,Exception{   
		  DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
	      String strSql ="id='"+ id+"'";
	      if(dbPrpljobmanager.getCount(strSql)<1)
	      //     if (new DBPrpLregist().getCount(dbManager,registNo) == null)
	      {
	        return false;
	      }else
	      {
	        return true;
	      }
	  }
	
	
	/**
	   * 按条件查询多条数据
	   * @param dbManager DBManager
	   * @param conditions String
	   * @param pageNo int
	   * @param rowsPerPage int
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
	   */
	  public PageRecord findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpljobmanager bdPrpljobmanager = new DBPrpljobmanager(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    int count = bdPrpljobmanager.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = bdPrpljobmanager.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
	}

}
