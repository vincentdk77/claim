package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLAcciCheckCharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheckText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdriver;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;

/**
 * 查勘数据库管理对象
 * <p>Title: 车险理赔查勘数据管理</p>
 * <p>Description: 车险理赔查勘数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBCheck{
	
	/**
	 * 查勘保存方法
	 *@param checkDto 查勘对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public void insert(DBManager dbManager,CheckDto checkDto)
	throws SQLException,Exception
	{
		if (checkDto.getPrpLcheckDto() ==null)
		{
			throw new Exception();
		}
		
		String checkNo="";
		checkNo = checkDto.getPrpLcheckDto().getRegistNo();
		
		//首先删除原来的相关数据
		deleteSubInfo(dbManager,checkNo,checkDto);
		
		if (checkDto.getAcciCheckDto() == null) {
			new DBPrpLcheck(dbManager).insert(checkDto.getPrpLcheckDto());
			
			if(checkDto.getPrpLthirdPartyDtoList()!=null)
			{
				new DBPrpLthirdParty(dbManager).insertAll(checkDto.getPrpLthirdPartyDtoList());
			}
			if(checkDto.getPrpLdriverDtoList()!=null)
			{
				new DBPrpLdriver(dbManager).insertAll(checkDto.getPrpLdriverDtoList());
			}
			if(checkDto.getPrpLregistTextDtoList()!=null)
			{
				new DBPrpLregistText(dbManager).insertAll(checkDto.getPrpLregistTextDtoList());
			}
			
			if(checkDto.getPrpLcheckExtDtoList()!=null)
			{
				new DBPrpLcheckExt(dbManager).insertAll(checkDto.getPrpLcheckExtDtoList());
			}
			if(checkDto.getPrpLcheckLossDtoList()!=null)
			{
				new DBPrpLcheckLoss(dbManager).insertAll(checkDto.getPrpLcheckLossDtoList());
			}
			
			if(checkDto.getPrpLpersonTraceDtoList()!=null)
			{
				new DBPrpLpersonTrace(dbManager).insertAll(checkDto.getPrpLpersonTraceDtoList());
			}
			
			if(checkDto.getPrpLscheduleItemDtoList() !=null)   {
				
				new DBPrpLscheduleItem(dbManager).insertAll(checkDto.getPrpLscheduleItemDtoList()  );
			}
			
			if(checkDto.getPrpLthirdCarLossDtoList()!=null)
			{
				new DBPrpLthirdCarLoss(dbManager).insertAll(checkDto.getPrpLthirdCarLossDtoList());
			}
			if(checkDto.getPrpLthirdPropDtoList()!=null)
			{
				new DBPrpLthirdProp(dbManager).insertAll(checkDto.getPrpLthirdPropDtoList());
			}
			//add by qinyongli 货运险查勘信息 2005-8-30
			if(checkDto.getPrpLextDto()!=null){
				new DBPrpLext(dbManager).insert(checkDto.getPrpLextDto());
			}
			if(checkDto.getPrpLregistExtDtoList()!=null)
			{ 
				new DBPrpLregistExt(dbManager).insertAll(checkDto.getPrpLregistExtDtoList());
			}
			if(checkDto.getPrpLregistTextDtoList3() != null){
				new DBPrpLregistText(dbManager).insertAll(checkDto.getPrpLregistTextDtoList3());
			}
			if(checkDto.getPrpLcompensateeartDtoList() != null){
				new DBPrplcompensateear(dbManager).insertAll(checkDto.getPrpLcompensateeartDtoList());
			}
			
			if (checkDto.getPrplCompensateHouseDtoList()!= null && checkDto.getPrplCompensateHouseDtoList().size() > 0) {
				PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)checkDto.getPrplCompensateHouseDtoList().get(0);
				String registno = PrplcompensatehouseDto.getRegistno();
				String nodetype = PrplcompensatehouseDto.getNodetype();
				String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
				new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
				new DBPrplcompensatehouse(dbManager).insertAll(checkDto.getPrplCompensateHouseDtoList());
			}
		} else {
			//modify by wangwei add start 2005-06-18
			//原因：插入调查信息
			if (checkDto.getAcciCheckDto() != null && checkDto.getAcciCheckDto().getPrpLacciCheckDto() != null) {
				new DBPrpLacciCheck(dbManager).insert(checkDto.getAcciCheckDto().getPrpLacciCheckDto());
			}
			if (checkDto.getAcciCheckDto() != null && checkDto.getAcciCheckDto().getPrpLacciCheckTextDtoList() != null) {
				new DBPrpLacciCheckText(dbManager).insertAll(checkDto.getAcciCheckDto().getPrpLacciCheckTextDtoList());
			}
			//意健险要保存调查费用信息
			if (checkDto.getAcciCheckDto() != null && checkDto.getAcciCheckDto().getPrpLAcciCheckChargeDtoList() != null) {
				new DBPrpLAcciCheckCharge(dbManager).insertAll(checkDto.getAcciCheckDto().getPrpLAcciCheckChargeDtoList());
			}
			
		}
		//mofify by wangwei add end 2005-06-18
		//进行状态的改变
		updateClaimStatus(dbManager,checkDto);
	}
	
	
	/**
	 * 变更查勘的操作状态的方法
	 *@param checkDto 查勘对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public void updateClaimStatus(DBManager dbManager,CheckDto checkDto)
	throws SQLException,Exception
	{
		
		//示例未完成
		String statement = "";
		
		if(checkDto.getPrpLclaimStatusDto() !=null){
			String condition3 = " BusinessNo='" + StringUtils.rightTrim(checkDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
			+ " AND NodeType ='check' ";
			statement = " DELETE FROM prpLclaimStatus Where " + condition3;
			
			dbManager.executeUpdate(statement);
			
			new DBPrpLclaimStatus(dbManager).insert(checkDto.getPrpLclaimStatusDto() );
		}
	}
	
	/**
	 * 查勘删除
	 * @param checkNo
	 * @throws SQLException
	 * @throws Exception
	 */
	public void delete(DBManager dbManager,String checkNo)
	throws SQLException,Exception
	{
		String condition = " registNo = '" + StringUtils.rightTrim(checkNo) + "'";
		String condition3 = " BusinessNo='" + checkNo.trim() + "' "
		+ " AND NodeType ='check' ";
		
		String condition2 = "  businessno ='" + checkNo.trim() + "' "
		+ " AND NodeType ='check' and (nodeStatus='7' or nodeStatus<'4')";
		
		//示例未完成
		String statement = ""; //示例未完成
		statement = " DELETE FROM PrpLregistText Where " + condition +" and TextType = '3'";
		dbManager.executeUpdate(statement);
		statement = " DELETE FROM PrpLcheckExt Where " + condition;
		dbManager.executeUpdate(statement);
		statement = " DELETE FROM PrpLcheckLoss Where " + condition;
		dbManager.executeUpdate(statement);
		statement = " DELETE FROM prpLclaimStatus Where " + condition3;
		dbManager.executeUpdate(statement);
		statement = " DELETE FROM PrpLcheck Where " + condition;
		dbManager.executeUpdate(statement);
		
		//如果有工作流的话？？？？
		
		statement = " update swflog set nodestatus='0' Where " + condition2;
		
		dbManager.executeUpdate(statement);
	}
	
	/*
	 * 查勘查询方法
	 *@param checkDto 查勘对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public CheckDto findByPrimaryKey(DBManager dbManager,String checkNo)
	throws SQLException,Exception
	{
		String registNo= "";
		if (checkNo.length() > 21) {
			 registNo = checkNo.substring(0, 21);
		}else{
			 registNo=checkNo;
		}
		String conditions = " registNo = '"+registNo+"'";
		String conditions1 = " registNo = '"+registNo+"' and TextType = '3' ";
		String conditions2 = " registNo = '"+registNo+"' and TextType = '07' ";
		CheckDto checkDto = new CheckDto();
		checkDto.setPrpLcheckDto(new DBPrpLcheck(dbManager).findByPrimaryKey(registNo,1));
		checkDto.setPrpLthirdPartyDtoList((ArrayList)new DBPrpLthirdParty(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLthirdCarLossDtoList((ArrayList)new DBPrpLthirdCarLoss(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLthirdPropDtoList((ArrayList)new DBPrpLthirdProp(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLdriverDtoList((ArrayList)new DBPrpLdriver(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLregistTextDtoList((ArrayList)new DBPrpLregistText(dbManager).findByConditions(conditions1,0,0));
		checkDto.setPrpLregistTextDtoList3((ArrayList)new DBPrpLregistText(dbManager).findByConditions(conditions2,0,0));
		checkDto.setPrpLcheckExtDtoList((ArrayList)new DBPrpLcheckExt(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLcheckLossDtoList((ArrayList)new DBPrpLcheckLoss(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLpersonTraceDtoList((ArrayList)new DBPrpLpersonTrace(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,"check",0));
		checkDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
		checkDto.setPrpLextDto(new DBPrpLext(dbManager).findByPrimaryKey(registNo,"02"));//add by qinyongli 2005-8-30
		//modify by wangwei add start 2005-06-18
		//原因：添加调查信息
		AcciCheckDto acciCheckDto = new AcciCheckDto();
		int time = new DBPrpLacciCheck(dbManager).findByRegistNoMaxTimes(checkNo);
		
		String condition2 = " checkNo = '"+checkNo + "' and Times = " + time; 
		ArrayList acciCheckDtoList = (ArrayList) new DBPrpLacciCheck(dbManager).findByConditions(condition2);
		if (acciCheckDtoList != null && acciCheckDtoList.size() > 0) {
			acciCheckDto.setPrpLacciCheckDto((PrpLacciCheckDto) acciCheckDtoList.get(0));
			acciCheckDto.setPrpLacciCheckTextDtoList((ArrayList) new DBPrpLacciCheckText(dbManager).findByConditions("CheckNo = '" + acciCheckDto.getPrpLacciCheckDto().getCheckNo() +"'"));
			acciCheckDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(checkNo));
			String condition = " checkNo = '"+checkNo+"'";
			acciCheckDto.setPrpLAcciCheckChargeDtoList(new DBPrpLAcciCheckCharge(dbManager).findByConditions(condition));
		} 
		checkDto.setAcciCheckDto(acciCheckDto);
		//modify by wangwei add end 2005-06-18
		
		return checkDto;
	}
	
	/**
	 * 查勘删除子表信息
	 * @param checkNo
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteSubInfo(DBManager dbManager,String checkNo,CheckDto checkDto)
	throws SQLException,Exception
	{
		String condition = " registNo = '" + StringUtils.rightTrim(checkNo) + "'";
		String condition2 = " registNo = '" + StringUtils.rightTrim(checkNo) + "' and nodetype ='check'";
		String statement = ""; //示例未完成
		
		if (checkDto.getAcciCheckDto() == null) {
			//查勘则删除以下子表(非意健险中一般都是查勘)
			
			statement =  " DELETE FROM prpLcompensateEar Where " + condition2;
			dbManager.executeUpdate(statement);
			
			statement =  " DELETE FROM PrpLregistExt Where " + condition;
			dbManager.executeUpdate(statement);
			statement = " DELETE FROM PrpLregistText Where " + condition +" and (TextType = '3' or TextType='07')";
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckExt Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement =  " DELETE FROM prpLpersonTrace Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckLoss Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLdriver Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLthirdParty Where " + condition;
			dbManager.executeUpdate(statement);
			
			
			statement = " DELETE FROM PrpLcheck Where " + condition;
			dbManager.executeUpdate(statement);
			
			//add by qinyongli 货运险扩展信息 2005-8-30
			String condition1 = " certino = '" + StringUtils.rightTrim(checkNo) + "'";
			statement = " DELETE FROM prplext Where " + condition1;
			dbManager.executeUpdate(statement);
			
			//如果传过来的有scheduleITem的数据的话
			if(checkDto.getPrpLscheduleItemDtoList() !=null)   {
				statement = " DELETE FROM PrpLscheduleItem Where " + condition;
				dbManager.executeUpdate(statement);
			}
			//Modify by chenrenda add begin 20050408
			statement = " DELETE FROM prplThirdcarloss Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prplThirdProp Where " + condition;
			dbManager.executeUpdate(statement);
			//Modify by chenrenda add end 20050408
		} else {
			//调查则删除以下子表(意健险中一般称为调查)
			//modify by wangwei add start 2005-06-18
			//原因：删除调查信息
			statement = " DELETE FROM PrpLacciCheckText Where CheckNo = '" + checkDto.getAcciCheckDto().getPrpLacciCheckDto().getCheckNo() + "'";
			dbManager.executeUpdate(statement);
			statement = " DELETE FROM PrpLacciCheckCharge Where CheckNo = '" + checkDto.getAcciCheckDto().getPrpLacciCheckDto().getCheckNo() + "'";
			dbManager.executeUpdate(statement);
			statement = " DELETE FROM PrpLacciCheck Where CheckNo = '" + checkDto.getAcciCheckDto().getPrpLacciCheckDto().getCheckNo() + "'";
			dbManager.executeUpdate(statement);
			//modify by wangwei add end 2005-06-18
		}
		
	}	

	/*
	 * 查勘查询方法
	 *@param checkDto 查勘对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public Collection findNewScheduleTaskList(DBManager dbManager,String conditions)
	throws SQLException,Exception
	{
		Collection checkItemList = new ArrayList();
		checkItemList = (Collection)new DBPrpLcheckItem(dbManager).findByConditions(conditions);
		return checkItemList;
	}
	
	/**
	 * 查勘调度保存方法
	 *@param scheduleDto 调度对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	
	public void saveSchedule(DBManager dbManager,ScheduleDto scheduleDto)
	throws SQLException,Exception
	{
		if (scheduleDto.getPrpLscheduleMainWFDto() ==null)
		{
			throw new Exception();
		}
		
		String registNo = scheduleDto.getPrpLscheduleMainWFDto().getRegistNo();
		int scheduleID = scheduleDto.getPrpLscheduleMainWFDto().getScheduleID();
		
		deleteScheduleInfo(dbManager, registNo,scheduleID);
		if(scheduleDto.getPrpLscheduleMainWFDto()!=null)
		{
			new DBPrpLscheduleMainWF(dbManager).insert(scheduleDto.getPrpLscheduleMainWFDto());
			
			if (scheduleDto.getPrpLscheduleItemDtoList()!=null)
			{
				new DBPrpLscheduleItem(dbManager).insertAll(scheduleDto.getPrpLscheduleItemDtoList()) ;
			}
			//还需要保存需要查勘的信息到相应的查勘信息表中
			
			if (scheduleDto.getPrpLcheckItemDtoList()!=null)
			{
				new DBPrpLcheckItem(dbManager).insertAll(scheduleDto.getPrpLcheckItemDtoList());
			}
		}
		
	}
	
	/**
	 * 查勘调度删除子表信息
	 * @param scheduleID,registNo
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteScheduleInfo(DBManager dbManager,String registNo,int scheduleID)
	throws SQLException,Exception
	{
		String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "' and scheduleID="+scheduleID;
		
		String statement = ""; //示例未完成
		statement = " DELETE FROM PrpLcheckItem Where " + condition;
		dbManager.executeUpdate(statement);
		
		statement = " DELETE FROM PrpLscheduleItem Where " + condition;
		dbManager.executeUpdate(statement);
		
		statement = " DELETE FROM PrpLscheduleMainWFWF Where " + condition;
		dbManager.executeUpdate(statement);
		
	}
	
}
