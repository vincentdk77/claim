package com.sinosoft.claim.resource.dtofactory.custom;

import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcomplaint;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.reference.DBManager;

public class DBReturnVisit {
	public void insert(DBManager dbManager,ReturnVisitDto returnVisitDto) throws Exception{
		/** 保存回访子表信息 */
		if(returnVisitDto.getPrplreturnvisitDtoList() != null){
			new DBPrplreturnvisit(dbManager).insertAll(returnVisitDto.getPrplreturnvisitDtoList());
		}
		/** 保存回访主表信息 */
		if(returnVisitDto.getPrplreturnvisitswflogDto() != null){
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = returnVisitDto.getPrplreturnvisitswflogDto();
			new DBPrplreturnvisitswflog(dbManager).insert(prplreturnvisitswflogDto);
		}
		/** 保存投诉信息 */
		if(returnVisitDto.getPrplcomplaintDto() != null){
			new DBPrplcomplaint(dbManager).insert(returnVisitDto.getPrplcomplaintDto());
		}
	}
	
	public void delete(DBManager dbManager,ReturnVisitDto returnVisitDto) throws Exception{
		/** 删除回访子表信息 */
		if(returnVisitDto.getPrplreturnvisitDtoList() != null){
			String businessNo = returnVisitDto.getPrplreturnvisitDtoList().get(0).getBusinessNo();
			String nodetype=returnVisitDto.getPrplreturnvisitDtoList().get(0).getNodetype();
			String conditions = " businessNo='"+businessNo+"' and nodetype='"+nodetype+"'";
			new DBPrplreturnvisit(dbManager).deleteByConditions(conditions);
		}
		/** 删除回访主表信息 */
		if(returnVisitDto.getPrplreturnvisitswflogDto() != null){
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = returnVisitDto.getPrplreturnvisitswflogDto();
			new DBPrplreturnvisitswflog(dbManager).delete(prplreturnvisitswflogDto.getBusinessno(), prplreturnvisitswflogDto.getNodetype());
		}
		/** 删除投诉信息 */
		if(returnVisitDto.getPrplcomplaintDto() != null){
			new DBPrplcomplaint(dbManager).delete(returnVisitDto.getPrplcomplaintDto().getComplaintno());
		}
	}

}
