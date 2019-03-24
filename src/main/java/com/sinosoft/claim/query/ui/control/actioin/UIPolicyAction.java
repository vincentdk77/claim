package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.query.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.query.ui.model.PolicyCheckPayCommand;
import com.sinosoft.claim.ui.model.PolicyDeleteCommand;
import com.sinosoft.claim.query.ui.model.PolicyFindByConCommand;
import com.sinosoft.claim.ui.model.PolicyForRegistQueryCommand;
import com.sinosoft.claim.ui.model.PolicyIsExistCommand;
import com.sinosoft.claim.ui.model.PolicySaveCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * UI�����߼�
 * <p>Title: ���������������� ����action</p>
 * <p>Description: ���������������� ����action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author     weishixin
 * @version    1.0
 */
public class UIPolicyAction{
	
	private static UIPolicyAction uiPolicyAction= new UIPolicyAction();
	
	public static UIPolicyAction getInstance(){
		return uiPolicyAction;
	}
	/**
	 * ���汣��
	 * @param policyDto����������
	 * @throws Exception
	 */
	public void save(PolicyDto policyDto) throws SQLException,Exception
	{
		PolicySaveCommand policySaveCommand = new PolicySaveCommand(policyDto);
		policySaveCommand.execute();
	}
	
	/**
	 * ɾ������
	 * @param policyNo
	 * @throws Exception
	 */
	public void delete(String policyNo) throws SQLException,Exception
	{
		PolicyDeleteCommand policyDeleteCommand = new PolicyDeleteCommand(policyNo);
		policyDeleteCommand.execute();
	}
	
	/**
	 * ��ñ���
	 * @param policyNo ������
	 * @return ��������
	 * @throws Exception
	 */
	public PolicyDto findByPrimaryKey(String policyNo) throws SQLException,UserException,Exception
	{
		PolicyFindByConCommand policyFindByConCommand = new PolicyFindByConCommand(policyNo);
		
		PolicyDto policyDto = (PolicyDto)policyFindByConCommand.execute();
		
		if (policyDto == null)
		{
			throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+policyNo+")");
		}
		return policyDto;
	}
	
	/**
	 * ��ñ���
	 * @param policyNo ������
	 * @return ��������
	 * @throws Exception
	 */
	public PrpCmainDto findPrpCmainDtoByPrimaryKey(String policyNo) throws SQLException,UserException,Exception
	{
		BLPolicyFacade blPolicyFacade = new BLPolicyFacade();
		PrpCmainDto prpCmainDto = blPolicyFacade
		.findPrpCmainDtoByPrimaryKey(policyNo);
		if (prpCmainDto == null) {
			throw new UserException(-98, -1000, this.getClass().getName()
					+ ".findByPrimaryKey(" + policyNo + ")");
		}
		return prpCmainDto;
	}
	
	
	/**
	 * ��ñ���
	 * @param policyNo ������
	 * @return ��������
	 * @throws Exception
	 */
	public PrpCitemKindDto findPrpCitemKindDtoByConditions(String policyNo,String kindCode) throws SQLException,UserException,Exception
	{
		BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
		String conditions = " policyNo='"+policyNo+"' and kindcode='"+kindCode+"'";
		ArrayList prpCitemKindDtoList = new ArrayList();
		PrpCitemKindDto prpCitemKindDto =new PrpCitemKindDto(); 
		prpCitemKindDtoList = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
		if(prpCitemKindDtoList.size()>0)
			prpCitemKindDto = (PrpCitemKindDto)prpCitemKindDtoList.get(0);
		return prpCitemKindDto;
	}
	

	/**
	 * ��ñ���
	 * @param policyNo ������
	 * @return ��������
	 * @throws Exception
	 */
	public Collection findPrpCinsuredDtoByConditions(String conditions) throws SQLException,UserException,Exception
	{
		BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
		Collection prpCinsuredDtoList = (ArrayList)blPrpCinsuredFacade.findByConditions(conditions);
		if (prpCinsuredDtoList == null) {
			throw new UserException(-98, -1000, this.getClass().getName()
					+ ".findByConditions(" + prpCinsuredDtoList + ")");
		}
		return prpCinsuredDtoList;
	}
	/**
	 * ��prpcvirturlitem����ȡ������ֻ��ĵ���Ϣ
	 * @param conditions ���������ŵĲ�ѯ����
	 * @return �˱�����������������ֻ���Ϣ�Ķ���
	 * @throws Exception
	 */
	public Collection findPrpCinsuredViturlItemDtoByConditions(String conditions) throws SQLException,UserException,Exception
	{
		BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
		Collection prpCinsuredVirturlItemDtoList = (ArrayList)blPrpCinsuredFacade.findVirturlItemByConditions(conditions);
		if (prpCinsuredVirturlItemDtoList == null) {
			throw new UserException(-98, -1000, this.getClass().getName()
					+ ".findByConditions(" + prpCinsuredVirturlItemDtoList + ")");
		}
		return prpCinsuredVirturlItemDtoList;
	}
	
	/**
	 * ��prpcvirturlItem����ȡ���ɲ���ϱ�������
	 * @param conditions
	 * @return
	 * @throws SQLException
	 * @throws UserException
	 * @throws Exception
	 */
	public Collection findViturlItemDtoByConditions(String conditions) throws SQLException,UserException,Exception
	{
		BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
		Collection prpCinsuredVirturlItemDtoList = (ArrayList)blPrpCinsuredFacade.findViturlItemDtoByConditions(conditions);
		if (prpCinsuredVirturlItemDtoList == null) {
			throw new UserException(-98, -1000, this.getClass().getName()
					+ ".findByConditions(" + prpCinsuredVirturlItemDtoList + ")");
		}
		return prpCinsuredVirturlItemDtoList;
	}
	//modify by wangwei add start 2005-06-16
	//ԭ�򣺴ӳ�����Ա��Ϣ�� PrpLacciPerson�в�ѯ��Ϣ
	public int findBySeriaNo(String condition) throws SQLException,UserException,Exception
	{
		PolicyFindByConCommand policyFindByConCommand = new PolicyFindByConCommand();
		
		int seriaNo = policyFindByConCommand.findBySeriaNo(condition);
		return seriaNo;
	}
	//modify by wangwei add end 2005-06-16
	
	/**
	 * �жϱ����Ƿ����
	 * @param policyNo
	 * @return ��/��
	 * @throws Exception
	 */
	public boolean isExist(String policyNo) throws SQLException,Exception
	{
		PolicyIsExistCommand policyIsExistCommand = new PolicyIsExistCommand(policyNo);
		return ((Boolean)policyIsExistCommand.execute()).booleanValue();
	}
	
	/**
	 * ��ñ���¼��ǰ���ݳ��ƺ����������ñ��������б���Ϣ
	 * @param  conditions����ѯ����
	 * @return ��������
	 * @throws Exception 
	 */
	
	public PageRecord findForRegistConditions(String conditions,String pageNo,String recordPerPage) throws SQLException,Exception
	{
		PolicyForRegistQueryCommand policyForRegistQueryCommand = new PolicyForRegistQueryCommand(conditions,pageNo,recordPerPage);
		
		return (PageRecord)policyForRegistQueryCommand.execute();
	}
	
	/**
	 * ���ɷ����
	 * @param policyNo
	 * @return 0,1,-1
	 * @throws Exception
	 */
	public int checkPay(String conditions) throws SQLException,Exception
	{
		PolicyCheckPayCommand policyCheckPayCommand = new PolicyCheckPayCommand(conditions);
		return  ((Integer)policyCheckPayCommand.execute()).intValue() ;
	}
	/**
	 * ���ɷ����
	 * @param policyNo
	 * @return 0,1,-1
	 * @throws Exception
	 */
	public int[] getDelinquentfeeTime(String conditions) throws SQLException,Exception
	{
		BLPolicyFacade blPolicyFacade = new BLPolicyFacade(); 
		return blPolicyFacade.getDelinquentfeeTime(conditions);  
	}  
}
