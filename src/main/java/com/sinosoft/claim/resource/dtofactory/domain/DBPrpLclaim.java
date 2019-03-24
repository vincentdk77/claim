package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;

/**
 * ����prplclaim����������Ϣ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaim extends DBPrpLclaimBase{
    private static Log log = LogFactory.getLog(DBPrpLclaim.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaim(DBManager dbManager){
        super(dbManager);
    }


    /**
     * �������
     * @param userCode String
     * @param isChinese boolean
     * @throws Exception
     * @return String
     */
    public String translateCode(String businessCode,boolean isSearchClaimNo) throws Exception
    {
      String buinessNo  = "" ;
      if(businessCode==null)
      {
        buinessNo = "" ;
        return buinessNo;
      }
      else
      {
          if(businessCode.trim().equals(""))
          {
            buinessNo = "";
            return buinessNo;
          }
      }
		String statement = null;
		if(isSearchClaimNo)
		{
		statement = "Select claimno from prplclaim Where registno='" + businessCode + "'";
		}
		else
		{
		statement = "Select registno from prplclaim Where claimno='" + businessCode + "'";
		}


      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        buinessNo = resultSet.getString(1);
      }
      resultSet.close();
      log.info("DBPrpLclaim.translate() success!");
      return buinessNo;

    }

    /**
     * ��������prplclaim��,prplregist���prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT prplclaim.ClaimNo,"+
                           "prplclaim.RegistNo, "+
                           "prplclaim.OperatorCode, "+
                           "prplclaim.CaseType, "+
                           "b.OperateDate," +
                           "b.Status, "+
                           "b.RiskCode, "+
                           "prplregist.LicenseNo, "+
						   "prplregist.reportDate," +
						   "prplclaim.inputDate From (select * from PrpLClaimStatus where NodeType='claim') b LEFT JOIN prplclaim ON prplclaim.ClaimNo = b.BusinessNo LEFT JOIN prplregist ON prplclaim.registNo = prplregist.registNo where" + conditions+" order by prplclaim.claimno" ;
//                             "b.Status,prplregist.LicenseNo  From (select * from PrpLClaimStatus where NodeType='check') b LEFT JOIN PrpLcheck a ON prplclaim.RegistNo = b.BusinessNo left join prplregist c on prplregist.registno=b.BusinessNo where"+conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimDto prpLclaimDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0; 
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                } 
            }
            prpLclaimDto = new PrpLclaimDto();
            prpLclaimDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLclaimDto.setOperatorCode(dbManager.getString(resultSet,3));
            prpLclaimDto.setCaseType(dbManager.getString(resultSet,4));
            prpLclaimDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLclaimDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLclaimDto.setReportDate(dbManager.getString(resultSet,9));
            prpLclaimDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
/*
            if (prpLclaimDto.getStatus()==null||prpLclaimDto.getStatus().equals("") )
            {
               //	prpLclaimDto.setStatus("4");
               //���˵����ܲ�������������
               continue;
            }
*/ 
            collection.add(prpLclaimDto);
        }
        resultSet.close();
        log.info("DBPrpLclaim.findByConditions() success!");
        return collection;
    }

    /**
     * ȡ�ù�����
     * @param claim String
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public PrpLclaimLossDto getClaimLoss(String claimNo) throws Exception{
       String statement = "select sum(SumClaim) from prplclaimloss where claimno = '"+claimNo+"'";

        PrpLclaimLossDto prpLclaimLossDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            prpLclaimLossDto = new PrpLclaimLossDto();
            prpLclaimLossDto.setSumClaim(dbManager.getDouble(resultSet,1));
            prpLclaimLossDto.setClaimNo(claimNo);
        }
        resultSet.close();
        return prpLclaimLossDto;
    }


    /**
     * Ԥ���ύʱ��д������Ԥ����
     * @param claim String
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public void updatePrepayPaid(PrpLclaimDto prpLclaimDto) throws Exception{
        String statement = " update PrpLclaim set SumPaid="+ prpLclaimDto.getSumPaid() +" Where " +
                           " ClaimNo ='"+prpLclaimDto.getClaimNo()+"'";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLclaimBase.updatePrepayPaid() success!");
    }

    /**
   * ��������ȡ��δ����ѯ�б�
   * @param iWherePart ��ѯ����(�����������־�)
   * @param iOtherWherePart ���Ӳ�ѯ����
   * @throws UserException
   * @throws Exception
  */
    public Collection querySumForNoEndCase(String iWherePart,String iOtherWherePart) throws Exception{

     //1.�����������ͷ��ٷ�ҵ��

      String statement = "";
      PrpLclaimDto prpLclaimDto = null;
      String strFirst =iWherePart +" AND CoinsFlag!='1' AND ReinsFlag NOT IN ('1','2')";
      statement = " SELECT sum(PrpLclaim.SumClaim) as SumClaim,count(1) as Count,"
         + " PrpLclaim.ClassCode,PrpLclaim.RiskCode,PrpLclaim.Currency,PrpLclaim.StartDate,PrpLclaim.EndDate "
         + " FROM PrpLclaim,PrpCmain WHERE PrpLclaim.PolicyNo=PrpCmain.PolicyNo AND " + strFirst
         + " GROUP BY PrpLclaim.ClassCode,PrpLclaim.RiskCode,PrpLclaim.Currency,PrpLclaim.StartDate,PrpLclaim.EndDate"
         + iOtherWherePart     ;

        Collection prpLclaimDtoList = new ArrayList();
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            prpLclaimDto = new PrpLclaimDto();
            prpLclaimDto.setSumClaim(dbManager.getDouble(resultSet,1));
            prpLclaimDto.setCount(dbManager.getInt(resultSet,2));
            prpLclaimDto.setClassCode(dbManager.getString(resultSet,3));
            prpLclaimDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLclaimDto.setCurrency(dbManager.getString(resultSet,5));
            prpLclaimDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLclaimDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimDtoList.add(prpLclaimDto);
          }
        resultSet.close();
        return prpLclaimDtoList;
    }


    /**
      * ��ȡ�����ֱ�����������
      * @Author     : ��Ŀ��
      * @param  iUwYear
      * @param  iTreatyType
      * @return dblRate  ��������
      * @throws Exception
      */
     public double getRetentionRate(int iUwYear,String iTreatyType)
         throws Exception{
         double dblRate = 100;
         String strSQL = "SELECT RetentionRate FROM FhTreaty WHERE "
                       + "UwYear='" + iUwYear + "' AND TreatyType='" + iTreatyType + "'";
         try
         {
           ResultSet resultSet = dbManager.executeQuery(strSQL);
           if(resultSet.next()){
             dblRate = resultSet.getDouble(1);
             resultSet.close();
           }
           if(dblRate==0) dblRate = 100;
         }
         catch(Exception e)
         {
           dblRate = 100.0;
         }
     
         return dblRate;
     }

        /**
         * ��ȡ�����ֱ�����������
         * @Author     : ��Ŀ��
         * @param  iUwYear
         * @param  iTreatyType
         * @return RepolicyNo  �ٱ�����
         * @throws Exception
         */
        public String  getFcoRepolicy(String conditions)
            throws Exception{
          String  FcoRepolicy = "";
          String strSQL = "SELECT RepolicyNo FROM FcoRepolicy WHERE "
                        + conditions;
          try
          {
            ResultSet resultSet = dbManager.executeQuery(strSQL);
            if(resultSet.next()){
              FcoRepolicy = resultSet.getString(1);
              resultSet.close();
            }
       
          }
          catch(Exception e)
          {
            FcoRepolicy = "";
          }
       
            return FcoRepolicy;
        }


      /**
        * ��ȡ�ٱ�����
        * @Author     : ��Ŀ��
        * @param  conditions
        * @return dblRate  ����
        * @throws Exception
        */
       public double getFcoAbstractShareRate(String conditions)
           throws Exception{
           double dblRate = 100.0;
           String strSQL = "SELECT ReinsMode, ShareRate FROM FcoAbstract WHERE "
                         + conditions ;
           try
           {
             ResultSet resultSet = dbManager.executeQuery(strSQL);
             while(resultSet.next()){
               if (resultSet.getString(1).equals("1") )
               {
               dblRate = resultSet.getDouble(2);
               break;
               }
             }
             resultSet.close();
           }
           catch(Exception e)
           {
             dblRate = 100.0;
           }
      
           return dblRate;
       }
                     
   /**
     * ��������prpLclaim��,��ѯ�����������Ѿ������Ϣ
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
      */
    public Collection findSumEndCaseByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = " SELECT RiskCode,"
                        + " Currency,"
                        + " sum(SumPaid) as SumPaid "
                        + " FROM PrpLclaim WHERE "
                        + conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimDto prpLclaimDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLclaimDto = new PrpLclaimDto();
            prpLclaimDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLclaimDto.setCurrency(dbManager.getString(resultSet,2));
            prpLclaimDto.setSumPaid(dbManager.getDouble(resultSet,3));
            collection.add(prpLclaimDto);
        }
        resultSet.close();
        log.info("DBPrpLclaim.findSumEndCaseByConditions() success!");
        return collection;
    }

//add by zhaolu 20060802 start
    public int getCount1(String conditions)throws Exception
    {
    	int count = -1;
    	String statement = "select count(DISTINCT prplclaim.ClaimNo) from (select * from PrpLClaimStatus where NodeType='claim') b LEFT JOIN prplclaim ON prplclaim.ClaimNo = b.BusinessNo LEFT JOIN prplregist ON prplclaim.registNo = prplregist.registNo where" + conditions+" order by prplclaim.claimno" ;
    	  statement = SqlUtils.getWherePartForGetCount(statement);
    	log.debug(statement);
    	statement = SqlUtils.getWherePartForGetCount(statement);
    	ResultSet resultSet = dbManager.executeQuery(statement);
    	resultSet.next();
    	count = dbManager.getInt(resultSet,1);
    	resultSet.close();
    	log.info("DBPrpLclaim.getCount1() success!");
    	return count;
    }

//add b yzhaolu 20060802 end


 
}
