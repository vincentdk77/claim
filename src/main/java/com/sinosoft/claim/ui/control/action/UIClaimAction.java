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
 * ��������Claim
 * <p>Title: ����������������action  </p>
 * <p>Description: ����������������action</p>
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
	 * ��������
	 * @param ClaimDto����������DTO
	 * @throws Exception
	 */
	public void save(ClaimDto claimDto) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDto);
		claimSaveCommand.execute();
	}
	
	/**
	 * ����������������
	 * @param ClaimDto����������DTO
	 * @throws Exception
	 */
	public void save(ClaimDto claimDto,WorkFlowDto workFlowDto) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDto,workFlowDto);
		claimSaveCommand.execute();
	}
	/**
	 * ����������������
	 * @param ClaimDto����������DTO
	 * @throws Exception
	 */
	public void save(ArrayList claimDtoList,ArrayList workFlowDtoList,String comCode,String userCode) throws SQLException,Exception
	{
		ClaimSaveCommand claimSaveCommand = new ClaimSaveCommand(claimDtoList,workFlowDtoList,comCode,userCode);
		claimSaveCommand.execute();
	}
	/**
	 * ɾ������
	 * @param claimNo���ⰸ��
	 * @throws Exception
	 */
	public void delete(String ClaimNo) throws SQLException,Exception
	{
		ClaimDeleteCommand claimDeleteCommand = new ClaimDeleteCommand(ClaimNo);
		claimDeleteCommand.execute();
	}
	
	/**
	 * ɾ������(����������)
	 * @param claimNo���ⰸ��
	 * @throws Exception
	 */
	public void delete(String ClaimNo,WorkFlowDto workFlowDto) throws SQLException,Exception
	{
		ClaimDeleteCommand claimDeleteCommand = new ClaimDeleteCommand(ClaimNo,workFlowDto);
		claimDeleteCommand.execute();
	}
	
	/**
	 * ���������Ϣ
	 * @param  claimNo���ⰸ��
	 * @return ��������
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
	 * �ж��ⰸ���Ƿ����
	 * @param claimNo:�ⰸ��
	 * @return ��/��
	 * @throws Exception
	 */
	public boolean isExist(String claimNo) throws SQLException,Exception
	{
		ClaimIsExistCommand claimIsExistCommand = new ClaimIsExistCommand(claimNo);
		return ((Boolean)claimIsExistCommand.execute()).booleanValue();
	}
	
	/**
	 * ��ñ�����Ϣ
	 * @param  conditions����ѯ����
	 * @return ��������
	 * @throws Exception
	 */
	
	public Collection findByConditions(String conditions) throws SQLException,Exception
	{
		PrpLclaimFindByConCommand prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
		
		return (Collection)prpLclaimFindByConCommand.execute();
	}
	
	/**
	 * ���������ѯ��Ϣ
	 * @param  conditions����ѯ����
	 * @return ��������
	 * @throws Exception
	 * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
	 */
	
	public Collection findByQueryConditions(String conditions) throws SQLException,Exception
	{
		ClaimQueryCommand claimQueryCommand = new ClaimQueryCommand(conditions);
		
		return (Collection)claimQueryCommand.executeCommand();
	}
	
	/**
	 * ȡ�ù�����
	 * @param claimNo���ⰸ��
	 * @throws Exception
	 */
	public PrpLclaimLossDto getClaimLoss(String ClaimNo) throws SQLException,Exception
	{
		ClaimLossCommand claimLossCommand = new ClaimLossCommand(ClaimNo);
		return (PrpLclaimLossDto)claimLossCommand.execute();
	}
	
	
	/**
	 *ȡ��δ����ѯ�б�
	 *@param iWherePart ��ѯ����(�����������־�)
	 *@param iOtherWherePart ���Ӳ�ѯ����
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection getNoEndCaseClaim(String iWherePart,String iOtherWherePart) throws SQLException,Exception
	{
		ClaimGetNoEndCaseCommand claimGetNoEndCaseCommand = new ClaimGetNoEndCaseCommand(iWherePart,iOtherWherePart);
		return (Collection)claimGetNoEndCaseCommand.execute();
	}
	
	/**
	 *ȡ���Ѿ���ѯ�б�
	 *@param iWherePart ��ѯ����(�����������־�)
	 *@param iOtherWherePart ���Ӳ�ѯ����
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection querySumEndCase(String iWherePart) throws SQLException,Exception
	{
		ClaimQuerySumEndCaseCommand claimQuerySumEndCaseCommand = new ClaimQuerySumEndCaseCommand(iWherePart);
		return (Collection)claimQuerySumEndCaseCommand.execute();
	}
	
	/**
	 *ȡ���Ѿ���ѯ�б���嵥��Ϣ
	 *@param iWherePart ��ѯ����(�����������־�)
	 *@param iOtherWherePart ���Ӳ�ѯ����
	 *@throws UserException
	 *@throws Exception
	 */
	public Collection querySumEndCaseDetail(String iWherePart) throws SQLException,Exception
	{
		ClaimQuerySumEndCaseDetailCommand claimQuerySumEndCaseDetailCommand = new ClaimQuerySumEndCaseDetailCommand(iWherePart);
		return (Collection)claimQuerySumEndCaseDetailCommand.execute();
	}
	
//	modify by wangwei add start 2005-06-04
//	ԭ������һ������
	/**
	 * ���ݱ�����ȡ��������Ϣ
	 * @param policyNo ������
	 * @throws SQLException
	 * @throws Exception
	 * @return ����һ��������Ϣ�ļ���
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
	
	//����һ�����������ڷ��ر���prpcmain�����Ϣ
	/**
	 * ���ݱ�����ȡ�ñ�����Ϣ
	 * @param policyNo ������
	 * @throws SQLException, Exception
	 * @return ����һ��������Ϣ
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
	//�᰸��ҳ��ѯ
	public PageRecord findByConditions(String conditions,int pageNo,int recordPerRecord) throws Exception
	{
		PrpLclaimFindByConCommand prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions,pageNo,recordPerRecord);
		return (PageRecord)prpLclaimFindByConCommand.executeCommand();
	}
	//add by zhaolu 20060803 end
	
}
