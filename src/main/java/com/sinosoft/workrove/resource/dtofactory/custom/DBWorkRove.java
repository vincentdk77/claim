package com.sinosoft.workrove.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;

/**
 * 定损数据库管理对象
 * <p>
 * Title: 车险理赔定损数据管理
 * </p>
 * <p>
 * Description: 车险理赔定损数据管理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class DBWorkRove {
	/**
	 * 定损保存方法
	 * 
	 * @param certainLossDto
	 *            定损对象
	 * @throws SQLException
	 * @throws Exception
	 * @return 无
	 */
	public void insert(DBManager dbManager, WorkRoveDto workRoveDto)
			throws SQLException, Exception {

		String registNo = workRoveDto.getRegistNo();
		// 首先删除原来的相关数据
		deleteSubInfo(dbManager, registNo);
		
		//1 调度明细表
		if(workRoveDto.getPrpLscheduleItemDto()!=null){
			new DBPrpLscheduleItem(dbManager).delete(workRoveDto.getPrpLscheduleItemDto().getScheduleID(), workRoveDto.getPrpLscheduleItemDto().getRegistNo(), workRoveDto.getPrpLscheduleItemDto().getItemNo());
			new DBPrpLscheduleItem(dbManager).insert(workRoveDto.getPrpLscheduleItemDto());
		}
		//2
		if(workRoveDto.getPrpLscheduleMainWFDto()!=null){
			new DBPrpLscheduleMainWF(dbManager).update(workRoveDto.getPrpLscheduleMainWFDto());
		}
	}

	/**
	 * 定损删除子表信息
	 * 
	 * @param registNo
	 *            //报案号
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteSubInfo(DBManager dbManager,String  registNo) throws SQLException, Exception {

		// 删除查勘相关信息
		//String statement = "registNo = '"+registNo.trim()+"'";
		String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
		String condition2 = " registNo = '" + StringUtils.rightTrim(registNo) + "' and nodetype ='check'";
		String statement = ""; //示例未完成

			//查勘则删除以下子表(非意健险中一般都是查勘)
			
			statement =  " DELETE FROM prpLcompensateEar Where " + condition2;
			dbManager.executeUpdate(statement);
			
			//statement =  " DELETE FROM PrpLregistExt Where " + condition;
			//dbManager.executeUpdate(statement);
			statement = " DELETE FROM PrpLregistText Where " + condition +" and (TextType = '3' or TextType='07')";
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckExt Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckLoss Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheck Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLprop Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLverifyloss Where " + condition;
			dbManager.executeUpdate(statement);
		
	}

	/**
	 * 变更定损的操作状态的方法
	 * 
	 * @param certainLossDto
	 *            立案对象
	 * @throws SQLException
	 * @throws Exception
	 * @return 无
	 */
	public void updateClaimStatus(DBManager dbManager,
			CertainLossDto certainLossDto) throws SQLException, Exception {
		// 示例未完成
		String statement = "";
		if (certainLossDto.getPrpLclaimStatusDto() != null) {
			String condition3 = " BusinessNo='"
					+ certainLossDto.getPrpLclaimStatusDto().getBusinessNo()
							.trim() + "' "
					+ " AND NodeType ='certa' and serialNo="
					+ certainLossDto.getPrpLclaimStatusDto().getSerialNo();
			statement = " DELETE FROM prpLclaimStatus Where " + condition3;
			dbManager.executeUpdate(statement);
			new DBPrpLclaimStatus(dbManager).insert(certainLossDto
					.getPrpLclaimStatusDto());
		}
	}

}
