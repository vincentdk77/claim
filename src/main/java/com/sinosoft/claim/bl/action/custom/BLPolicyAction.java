package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBPolicy;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRec;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 保单逻辑
 * <p>Title: 车险理赔样本程序</p>
 * <p>Description: 车险理赔样本程序保单action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔项目组
 * @version 1.0
 */
public class BLPolicyAction
{
	public BLPolicyAction()
	{
	}
	
	/**
	 * 保存保单
	 * @param policyDto：自定义保单对象
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(DBManager dbManager,PolicyDto policyDto)
	throws SQLException,Exception
	{
		DBPolicy dbPolicy = null;
		//业务操作
		dbPolicy = new DBPolicy();
		if (this.isExist(dbManager,policyDto.getPrpCmainDto().getPolicyNo()))
		{
			dbPolicy.delete(dbManager,policyDto.getPrpCmainDto().getPolicyNo());
		}
		dbPolicy.insert(dbManager,policyDto);
		
	}
	
	/**
	 * 删除保单
	 * @param fcoPolicyNoticeNo：分保通知号
	 * @throws SQLException
	 * @throws Exception
	 */
	public void delete(DBManager dbManager,String policyNo)
	throws SQLException,Exception
	{
		new DBPolicy().delete(dbManager,policyNo);
	}
	
	/**
	 * 获得保单
	 * @param fcoPolicyNoticeNo
	 * @return 自定义保单对象
	 * @throws SQLException
	 * @throws Exception
	 */
	public PolicyDto findByPrimaryKey(DBManager dbManager,String policyNo)
	throws SQLException,Exception
	{
		PolicyDto policyDto = null;
		
		policyDto = new DBPolicy().findByPrimaryKey(dbManager,policyNo);
		return policyDto;
	}
	/**
	 * 根据保单号获得保单主信息
	 * @param dbManager
	 * @param policyNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public PrpCmainDto findPrpCmainDtoByPrimaryKey(DBManager dbManager,String policyNo) throws SQLException,Exception{
		return (PrpCmainDto)new DBPolicy().findPrpCmainDtoByPrimaryKey(dbManager,policyNo);
	}
	
	public int findBySeriaNo(DBManager dbManager,String condition) throws SQLException,Exception {
		int seriaNo = 0;
		seriaNo = new DBPolicy().findBySeriaNo(dbManager,condition);
		return seriaNo;
	}
	/**
	 * 判断保单通知号是否存在
	 * @param policyNo
	 * @return 是/否
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean isExist(DBManager dbManager,String policyNo)
	throws SQLException,Exception
	{
		
		if (new DBPolicy().findPrpCmainDtoByPrimaryKey(dbManager,policyNo) == null)
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
	public PageRecord findForRegistConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
		DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
			conditions = "1=1";
		}
		collection = dbPrpCmain.findForRegistConditions(conditions,pageNo,rowsPerPage);
		int count = dbPrpCmain.getCount1(SqlUtils.getWherePartForGetCount(conditions));
		PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		return pageRecord;
		/*
		 DBPrpDmenu dbPrpDmenu = new DBPrpDmenu(dbManager);
		 Collection collection = new ArrayList();
		 
		 if(conditions.trim().length()==0){
		 conditions = "1=1";
		 }
		 
		 int count = dbPrpDmenu.getCount(SqlUtils.getWherePartForGetCount(conditions));
		 collection = dbPrpDmenu.findByConditions(conditions,pageNo,rowsPerPage);
		 PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		 return pageRecord;
		 */
	}
	
	/**
	 * 判断保单通知号是否存在
	 * @param policyNo
	 * @return 是/否
	 * @throws SQLException
	 * @throws Exception
	 */
	public int checkPay(DBManager dbManager,String conditions) throws SQLException,Exception{		
		int intReturn = new DBPrpJpayRec(dbManager).checkPay(conditions);
		return intReturn;
	}
	
    /**
     * 获得未缴费的期数
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public int[] getDelinquentfeeTime(DBManager dbManager,String conditions) throws Exception{
    	return new DBPrpJpayRec(dbManager).getDelinquentfeeTime(conditions);
    }
}
