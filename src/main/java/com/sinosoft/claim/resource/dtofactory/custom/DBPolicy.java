package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCaddress;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcarDriver;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoins;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoinsDetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCengage;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCfee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsured;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemCar;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKind;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainCargo;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainLiab1;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainLoan;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainSub;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistRPolicy;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCplan;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofitDetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpClimit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemHouse;

import com.sinosoft.prpall.resource.dtofactory.domain.DBPrpCmainOrigin;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �������ݿ�������
 * <p>Title: �������Ᵽ�����ݹ���</p>
 * <p>Description: �������Ᵽ�����ݹ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBPolicy
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBPolicy()
  {

  }

  /**
   * �������淽��
   *@param policyDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,PolicyDto policyDto)
    throws SQLException,Exception
  {
    if (policyDto.getPrpCmainDto()==null)
      throw new Exception();

    //new DBFcoPolicy(dbManager).insert(policyDto.getFcoPolicyDto());

    //δ��ɣ����ⲿ�ֲ���Ҫ�������Ϣ
  }

  /**
   * ����ɾ��
   * @param fcoPolicyNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String policyNo)
    throws SQLException,Exception
  {
    String condition = " policyNo = " + "'" + StringUtils.rightTrim(policyNo) + "';";
    //ʾ��δ���
    String statement = " DELETE FROM prpCitemKind Where " + condition
                     + " DELETE FROM prpCitemCar Where " + condition
                     + " DELETE FROM prpCinsured Where " + condition
                     + " DELETE FROM prpCaddress Where " + condition
                     + " DELETE FROM prpCfee Where " + condition
                     + " DELETE FROM prpCplan Where " + condition
                     + " DELETE FROM prpCmain Where " + condition;
     dbManager.executeUpdate(statement);
  }

  /*
   * ������ѯ����
   *@param policyDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public PolicyDto findByPrimaryKey(DBManager dbManager,String policyNo)
    throws SQLException,Exception
  {
     PolicyDto policyDto = new PolicyDto();
     

     //ȡ���永����
     policyDto.setPrpCmainDto(new DBPrpCmain(dbManager).findByPrimaryKey(policyNo));
     policyDto.setPrpCfeeDto(new DBPrpCfee(dbManager).findByPrimaryKey(policyNo,"CNY"));
     String conditions = " policyNo = '" + policyNo + "'"; 
     policyDto.setPrpCitemKindDtoList((ArrayList)new DBPrpCitemKind(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCaddressDtoList((ArrayList)new DBPrpCaddress(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCinsuredDtoList((ArrayList)new DBPrpCinsured(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCitemCarDtoList((ArrayList)new DBPrpCitemCar(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCprofitDetailDtoList((ArrayList)new DBPrpCprofitDetail(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCprofitDtoList((ArrayList)new DBPrpCprofit(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCplanDtoList((ArrayList)new DBPrpCplan(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCengageDtoList((ArrayList)new DBPrpCengage(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCfeeDtoList((ArrayList)new DBPrpCfee(dbManager).findByConditions(conditions,0,0));
     policyDto.setLiabStartDate((DateTime)new DBPrpCmainLiab1(dbManager).findByPrimaryKeyStartDate(conditions));
     //ȡ�ü�ʻԱ��Ϣ
     policyDto.setPrpCcarDriverDtoList((ArrayList)new DBPrpCcarDriver(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(policyNo,"polic",0));
     
     //add by miaowenjun 20060430 ȡ�ø����շ�����Ϣ
     policyDto.setPrpCitemHouseDtoList((ArrayList)new DBPrpCitemHouse(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCmainLoanDtoList(new DBPrpCmainLoan(dbManager).findByPrimaryKey(policyNo));
     //add by miaowenjun 20060430
     
     //modify by wangwei add start 20050601
     policyDto.setPrpCmainCargoDto(new DBPrpCmainCargo(dbManager).findByPrimaryKey(policyNo));
     //modify by wangwei add end 20050601
     policyDto.setPrpCmainOriginDto(new DBPrpCmainOrigin(dbManager).findByPrimaryKey(policyNo));
     //modify by liuyanmei add start 20050601
        
     policyDto.setPrpClimitDtoList((ArrayList)new DBPrpClimit(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCcoinsDtoList((ArrayList)new DBPrpCcoins(dbManager).findByConditions(conditions,0,0));
     policyDto.setPrpCcoinsDetailDtoList((ArrayList)new DBPrpCcoinsDetail(dbManager).findByConditions(conditions,0,0));
     //modify by liuyanmei add end 20050601 

//add by lym 20060204  for ǿ�� ---- start >>>>>> 
     String conditions1 = "";
    
     conditions1 = " mainpolicyno= '" + policyNo +"' or  policyno= '"+policyNo+"'" ;
     policyDto.setPrpCmainSubDtoList((ArrayList)new DBPrpCmainSub(dbManager).findByConditions(conditions1,0,0));
     policyDto.setPrpLRegistRPolicyDtoList((ArrayList)new DBPrpLRegistRPolicy(dbManager).findByConditions(conditions,0,0));
    
     
//add by lym 20060204  for ǿ�� ---- end   >>>>>>   
     
     return policyDto;
  }
  /**
   * ���ݱ����Ż�ñ�������Ϣ
   * @param dbManager
   * @param policyNo
   * @return
   * @throws SQLException
   * @throws Exception
   */
  public PrpCmainDto findPrpCmainDtoByPrimaryKey(DBManager dbManager,String policyNo) throws SQLException,Exception{
	  return (PrpCmainDto)new DBPrpCmain(dbManager).findByPrimaryKey(policyNo);
  }
  
  
  public int findBySeriaNo(DBManager dbManager, String condition) throws SQLException,Exception {
  	  int seriaNo = 0;
  	 seriaNo = new DBPrpLacciPerson(dbManager).findBySeriaNo(condition);
  	  return seriaNo;
  }

  /**
   * ��������Ĳ���״̬�ķ���
   *@param claimDto ��������
   *@throws SQLException
   *@throws Exception
   *@return ��
   */
  public void updateClaimStatus(DBManager dbManager,PolicyDto policyDto)
    throws SQLException,Exception
{

 //ʾ��δ���
   String statement = "";


  if(policyDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(policyDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='polic' ";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);

      new DBPrpLclaimStatus(dbManager).insert(policyDto.getPrpLclaimStatusDto() );
   }
}

}
