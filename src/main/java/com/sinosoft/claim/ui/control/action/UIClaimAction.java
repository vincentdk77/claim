package com.sinosoft.claim.ui.control.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.ui.model.ClaimDeleteCommand;
import com.sinosoft.claim.ui.model.ClaimFindByConCommand;
import com.sinosoft.claim.ui.model.ClaimGetNoEndCaseCommand;
import com.sinosoft.claim.ui.model.ClaimIsExistCommand;
import com.sinosoft.claim.ui.model.ClaimLossCommand;
import com.sinosoft.claim.ui.model.ClaimQueryCommand;
import com.sinosoft.claim.ui.model.ClaimQuerySumEndCaseCommand;
import com.sinosoft.claim.ui.model.ClaimQuerySumEndCaseDetailCommand;
import com.sinosoft.claim.ui.model.ClaimSaveCommand;
import com.sinosoft.claim.ui.model.ClaimUpdateEndCaseDateCommand;
import com.sinosoft.claim.ui.model.PrpLclaimFindByConCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 立案对象Claim
 * <p>Title: 车险理赔样本立案action  </p>
 * <p>Description: 车险理赔样本立案action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuans
 * @version 1.0
 */
public class UIClaimAction{
	private static UIClaimAction uiClaimAction= new UIClaimAction();
	public static UIClaimAction getInstance(){
		return uiClaimAction;
	}
	/**
	 * 保存立案
	 * @param ClaimDto：立案对象DTO
	 * @throws Exception
	 */
	public void save(ClaimDto claimDto) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDto);
		claimSaveCommand.execute();
	}
	
	/**
	 * 保存立案带工作流
	 * @param ClaimDto：立案对象DTO
	 * @throws Exception
	 */
	public void save(ClaimDto claimDto,WorkFlowDto workFlowDto) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDto,workFlowDto);
		claimSaveCommand.execute();
	}
	/**
	 * 保存立案带工作流
	 * @param ClaimDto：立案对象DTO
	 * @throws Exception
	 */
	public void save(ArrayList claimDtoList,ArrayList workFlowDtoList,String comCode,String userCode) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDtoList,workFlowDtoList,comCode,userCode);
		claimSaveCommand.execute();
	}
	/**
	 * 删除立案
	 * @param claimNo：赔案号
	 * @throws Exception
	 */
	public void delete(String ClaimNo) throws SQLException,Exception
	{
		ClaimDeleteCommand claimDeleteCommand = new ClaimDeleteCommand(ClaimNo);
		claimDeleteCommand.execute();
	}
	
	/**
	 * 删除立案(带工作流的)
	 * @param claimNo：赔案号
	 * @throws Exception
	 */
	public void delete(String ClaimNo,WorkFlowDto workFlowDto) throws SQLException,Exception
	{
		ClaimDeleteCommand claimDeleteCommand = new ClaimDeleteCommand(ClaimNo,workFlowDto);
		claimDeleteCommand.execute();
	}
	
	/**
	 * 获得立案信息
	 * @param  claimNo：赔案号
	 * @return 立案对象
	 * @throws Exception
	 */
	public ClaimDto findByPrimaryKey(String claimNo) throws SQLException,UserException,Exception
	{
		ClaimFindByConCommand claimFindByConCommand = new ClaimFindByConCommand(claimNo);
		ClaimDto claimDto = (ClaimDto)claimFindByConCommand.execute();
		
	/*	if (claimDto == null)
		{
			throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+claimNo+")");
		}*/
		return claimDto;
	}
	
	/**
	 * 判断赔案号是否存在
	 * @param claimNo:赔案号
	 * @return 是/否
	 * @throws Exception
	 */
	public boolean isExist(String claimNo) throws SQLException,Exception
	{
		ClaimIsExistCommand claimIsExistCommand = new ClaimIsExistCommand(claimNo);
		return ((Boolean)claimIsExistCommand.execute()).booleanValue();
	}
	
	/**
	 * 获得报案信息
	 * @param  conditions：查询条件
	 * @return 报案对象
	 * @throws Exception
	 */
	
	public Collection findByConditions(String conditions) throws SQLException,Exception
	{
		PrpLclaimFindByConCommand prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
		
		return (Collection)prpLclaimFindByConCommand.execute();
	}
	
	/**
	 * 获得立案查询信息
	 * @param  conditions：查询条件
	 * @return 报案对象
	 * @throws Exception
	 * Add By sunhao 2004-08-24 Reason:增加新的查询条件
	 */
	
	public Collection findByQueryConditions(String conditions) throws SQLException,Exception
	{
		ClaimQueryCommand claimQueryCommand = new ClaimQueryCommand(conditions);
		
		return (Collection)claimQueryCommand.executeCommand();
	}
	
	/**
	 * 取得估损金额
	 * @param claimNo：赔案号
	 * @throws Exception
	 */
	public PrpLclaimLossDto getClaimLoss(String ClaimNo) throws SQLException,Exception
	{
		ClaimLossCommand claimLossCommand = new ClaimLossCommand(ClaimNo);
		return (PrpLclaimLossDto)claimLossCommand.execute();
	}
	
	
	/**
	 *取得未决查询列表
	 *@param iWherePart 查询条件(不包括排序字句)
	 *@param iOtherWherePart 附加查询条件
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection getNoEndCaseClaim(String iWherePart,String iOtherWherePart) throws SQLException,Exception
	{
		ClaimGetNoEndCaseCommand claimGetNoEndCaseCommand = new ClaimGetNoEndCaseCommand(iWherePart,iOtherWherePart);
		return (Collection)claimGetNoEndCaseCommand.execute();
	}
	
	/**
	 *取得已决查询列表
	 *@param iWherePart 查询条件(不包括排序字句)
	 *@param iOtherWherePart 附加查询条件
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection querySumEndCase(String iWherePart) throws SQLException,Exception
	{
		ClaimQuerySumEndCaseCommand claimQuerySumEndCaseCommand = new ClaimQuerySumEndCaseCommand(iWherePart);
		return (Collection)claimQuerySumEndCaseCommand.execute();
	}
	
	/**
	 *取得已决查询列表的清单信息
	 *@param iWherePart 查询条件(不包括排序字句)
	 *@param iOtherWherePart 附加查询条件
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection querySumEndCaseDetail(String iWherePart) throws SQLException,Exception
	{
		ClaimQuerySumEndCaseDetailCommand claimQuerySumEndCaseDetailCommand = new ClaimQuerySumEndCaseDetailCommand(iWherePart);
		return (Collection)claimQuerySumEndCaseDetailCommand.execute();
	}
	
//	modify by wangwei add start 2005-06-04
//	原因：增加一个方法
	/**
	 * 根据保单号取得立案信息
	 * @param policyNo 保单号
	 * @throws SQLException
	 * @throws Exception
	 * @return 返回一个立案信息的集合
	 * */
	public Collection findByPolicyNo(String policyNo) throws SQLException, Exception {
		ClaimFindByConCommand claimFindByConCommand = new ClaimFindByConCommand();
		return (Collection) claimFindByConCommand.findByPolicyNo(policyNo);
	}
	
	public Collection findByPolicyNo(String policyNo,String idcard) throws SQLException, Exception {
		ClaimFindByConCommand claimFindByConCommand = new ClaimFindByConCommand();
		return (Collection) claimFindByConCommand.findByPolicyNo(policyNo,idcard);
	}
//	modify by wangwei add end 2005-06-04
	
	//增加一个方法，用于返回保单prpcmain表的信息
	/**
	 * 根据保单号取得保单信息
	 * @param policyNo 保单号
	 * @throws SQLException, Exception
	 * @return 返回一个保单信息
	 * */
	public PrpCmainDto findByPolicyNoKey(String policyNo) throws SQLException, Exception {
		ClaimFindByConCommand claimFindByConCommand = new ClaimFindByConCommand();
		return claimFindByConCommand.findByPolicyNoKey(policyNo);
	}
	
	//modify by liuyanmei add 20051102 start
	public void updateEndCaseDate(String ClaimNo,Date endCaseDate) throws SQLException,Exception
	{
		ClaimUpdateEndCaseDateCommand claimUpdateEndCaseDateCommand = new ClaimUpdateEndCaseDateCommand(ClaimNo,endCaseDate);
		claimUpdateEndCaseDateCommand.execute();
	}

//	modify by  liuyanmei add 20051102 end 
	
	
	//add by zhaolu 20060802 start
	public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerRecord) throws Exception
	{
		ClaimQueryCommand claimQueryCommand = new ClaimQueryCommand(conditions,pageNo,recordPerRecord);
		return (PageRecord)claimQueryCommand.executeCommand();
	}
	//add by zhaolu 20060802 end
	
	//add by zhaolu 20060803 start
	//结案分页查询
	public PageRecord findByConditions(String conditions,int pageNo,int recordPerRecord) throws Exception
	{
		PrpLclaimFindByConCommand prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions,pageNo,recordPerRecord);
		return (PageRecord)prpLclaimFindByConCommand.executeCommand();
	}
	//add by zhaolu 20060803 end
	
}
