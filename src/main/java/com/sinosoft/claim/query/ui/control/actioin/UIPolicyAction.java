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
 * UI保单逻辑
 * <p>Title: 车险理赔样本程序 保单action</p>
 * <p>Description: 车险理赔样本程序 保单action</p>
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
	 * 保存保单
	 * @param policyDto：保单对象
	 * @throws Exception
	 */
	public void save(PolicyDto policyDto) throws SQLException,Exception
	{
		PolicySaveCommand policySaveCommand = new PolicySaveCommand(policyDto);
		policySaveCommand.execute();
	}
	
	/**
	 * 删除保单
	 * @param policyNo
	 * @throws Exception
	 */
	public void delete(String policyNo) throws SQLException,Exception
	{
		PolicyDeleteCommand policyDeleteCommand = new PolicyDeleteCommand(policyNo);
		policyDeleteCommand.execute();
	}
	
	/**
	 * 获得保单
	 * @param policyNo 保单号
	 * @return 保单对象
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
	 * 获得保单
	 * @param policyNo 保单号
	 * @return 保单对象
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
	 * 获得保单
	 * @param policyNo 保单号
	 * @return 保单对象
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
	 * 获得保单
	 * @param policyNo 保单号
	 * @return 保单对象
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
	 * 从prpcvirturlitem表里取出理赔分户的的信息
	 * @param conditions 包含保单号的查询条件
	 * @return 此保单包含的所有理赔分户信息的对象
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
	 * 从prpcvirturlItem表中取乡村干部组合保险数据
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
	//原因：从出险人员信息表 PrpLacciPerson中查询信息
	public int findBySeriaNo(String condition) throws SQLException,UserException,Exception
	{
		PolicyFindByConCommand policyFindByConCommand = new PolicyFindByConCommand();
		
		int seriaNo = policyFindByConCommand.findBySeriaNo(condition);
		return seriaNo;
	}
	//modify by wangwei add end 2005-06-16
	
	/**
	 * 判断保单是否存在
	 * @param policyNo
	 * @return 是/否
	 * @throws Exception
	 */
	public boolean isExist(String policyNo) throws SQLException,Exception
	{
		PolicyIsExistCommand policyIsExistCommand = new PolicyIsExistCommand(policyNo);
		return ((Boolean)policyIsExistCommand.execute()).booleanValue();
	}
	
	/**
	 * 获得报案录入前根据车牌号码等条件获得保单号码列表信息
	 * @param  conditions：查询条件
	 * @return 报案对象
	 * @throws Exception 
	 */
	
	public PageRecord findForRegistConditions(String conditions,String pageNo,String recordPerPage) throws SQLException,Exception
	{
		PolicyForRegistQueryCommand policyForRegistQueryCommand = new PolicyForRegistQueryCommand(conditions,pageNo,recordPerPage);
		
		return (PageRecord)policyForRegistQueryCommand.execute();
	}
	
	/**
	 * 检查缴费情况
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
	 * 检查缴费情况
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
