package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLosstgDto;

/**
 * 这是prplclaim立案基本信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimtg extends DBPrpLclaimtgBase{
    private static Log log = LogFactory.getLog(DBPrpLclaimtg.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimtg(DBManager dbManager){
        super(dbManager);
    }


    /**
     * 翻译代码
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
		statement = "Select claimno from prplclaimtg Where registno='" + businessCode + "'";
		}
		else
		{
		statement = "Select registno from prplclaimtg Where claimno='" + businessCode + "'";
		}


      log.debug(statement);
      ResultSet resultSet = dbManager.executeQuery(statement);
      while(resultSet.next())
      {
        buinessNo = resultSet.getString(1);
      }
      resultSet.close();
      log.info("DBPrpLclaimtg.translate() success!");
      return buinessNo;

    }

    /**
     * 按条件从prplclaim表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
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
						   "prplclaim.inputDate From (select * from PrpLClaimStatustg where NodeType='claim') b LEFT JOIN prplclaimtg ON prplclaim.ClaimNo = b.BusinessNo LEFT JOIN prplregist ON prplclaim.registNo = prplregist.registNo where" + conditions+" order by prplclaim.claimno" ;
//                             "b.Status,prplregist.LicenseNo  From (select * from PrpLClaimStatustg where NodeType='check') b LEFT JOIN PrpLcheck a ON prplclaim.RegistNo = b.BusinessNo left join prplregist c on prplregist.registno=b.BusinessNo where"+conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimtgDto prpLclaimtgDto = null;
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
            prpLclaimtgDto = new PrpLclaimtgDto();
            prpLclaimtgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimtgDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLclaimtgDto.setOperatorCode(dbManager.getString(resultSet,3));
            prpLclaimtgDto.setCaseType(dbManager.getString(resultSet,4));
            prpLclaimtgDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLclaimtgDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimtgDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLclaimtgDto.setReportDate(dbManager.getString(resultSet,9));
            prpLclaimtgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
/*
            if (prpLclaimtgDto.getStatus()==null||prpLclaimtgDto.getStatus().equals("") )
            {
               //	prpLclaimtgDto.setStatus("4");
               //过滤掉不能操作撤消的任务
               continue;
            }
*/ 
            collection.add(prpLclaimtgDto);
        }
        resultSet.close();
        log.info("DBPrpLclaimtg.findByConditions() success!");
        return collection;
    }

    /**
     * 取得估损金额
     * @param claim String
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public PrpLclaimLosstgDto getClaimLoss(String claimNo) throws Exception{
       String statement = "select sum(SumClaim) from prplclaimlosstg where claimno = '"+claimNo+"'";

        PrpLclaimLosstgDto prpLclaimLosstgDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            prpLclaimLosstgDto = new PrpLclaimLosstgDto();
            prpLclaimLosstgDto.setSumClaim(dbManager.getDouble(resultSet,1));
            prpLclaimLosstgDto.setClaimNo(claimNo);
        }
        resultSet.close();
        return prpLclaimLosstgDto;
    }


    /**
     * 预赔提交时回写立案的预赔金额
     * @param claim String
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public void updatePrepayPaid(PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        String statement = " update PrpLclaimtg set SumPaid="+ prpLclaimtgDto.getSumPaid() +" Where " +
                           " ClaimNo ='"+prpLclaimtgDto.getClaimNo()+"'";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLclaimtgBase.updatePrepayPaid() success!");
    }

    /**
   * 根据条件取得未决查询列表
   * @param iWherePart 查询条件(不包括排序字句)
   * @param iOtherWherePart 附加查询条件
   * @throws UserException
   * @throws Exception
  */
    public Collection querySumForNoEndCase(String iWherePart,String iOtherWherePart) throws Exception{

     //1.非主联共保和非临分业务

      String statement = "";
      PrpLclaimtgDto prpLclaimtgDto = null;
      String strFirst =iWherePart +" AND CoinsFlag!='1' AND ReinsFlag NOT IN ('1','2')";
      statement = " SELECT sum(PrpLclaimtg.SumClaim) as SumClaim,count(1) as Count,"
         + " PrpLclaimtg.ClassCode,PrpLclaimtg.RiskCode,PrpLclaimtg.Currency,PrpLclaimtg.StartDate,PrpLclaimtg.EndDate "
         + " FROM PrpLclaimtg,PrpCmain WHERE PrpLclaimtg.PolicyNo=PrpCmain.PolicyNo AND " + strFirst
         + " GROUP BY PrpLclaimtg.ClassCode,PrpLclaimtg.RiskCode,PrpLclaimtg.Currency,PrpLclaimtg.StartDate,PrpLclaimtg.EndDate"
         + iOtherWherePart     ;

        Collection prpLclaimtgDtoList = new ArrayList();
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            prpLclaimtgDto = new PrpLclaimtgDto();
            prpLclaimtgDto.setSumClaim(dbManager.getDouble(resultSet,1));
            prpLclaimtgDto.setCount(dbManager.getInt(resultSet,2));
            prpLclaimtgDto.setClassCode(dbManager.getString(resultSet,3));
            prpLclaimtgDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLclaimtgDto.setCurrency(dbManager.getString(resultSet,5));
            prpLclaimtgDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLclaimtgDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimtgDtoList.add(prpLclaimtgDto);
          }
        resultSet.close();
        return prpLclaimtgDtoList;
    }


    /**
      * 获取法定分保的自留比例
      * @Author     : 项目组
      * @param  iUwYear
      * @param  iTreatyType
      * @return dblRate  自留比例
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
         * 获取法定分保的自留比例
         * @Author     : 项目组
         * @param  iUwYear
         * @param  iTreatyType
         * @return RepolicyNo  再保号码
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
        * 获取再保比例
        * @Author     : 项目组
        * @param  conditions
        * @return dblRate  比例
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
     * 按条件从prpLclaim表,查询符合条件的已决赔款信息
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
                        + " FROM PrpLclaimtg WHERE "
                        + conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimtgDto prpLclaimtgDto = null;
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

            prpLclaimtgDto = new PrpLclaimtgDto();
            prpLclaimtgDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLclaimtgDto.setCurrency(dbManager.getString(resultSet,2));
            prpLclaimtgDto.setSumPaid(dbManager.getDouble(resultSet,3));
            collection.add(prpLclaimtgDto);
        }
        resultSet.close();
        log.info("DBPrpLclaimtg.findSumEndCaseByConditions() success!");
        return collection;
    }

//add by zhaolu 20060802 start
    public int getCount1(String conditions)throws Exception
    {
    	int count = -1;
    	String statement = "select count(DISTINCT prplclaim.ClaimNo) from (select * from PrpLClaimStatustg where NodeType='claim') b LEFT JOIN prplclaim ON prplclaim.ClaimNo = b.BusinessNo LEFT JOIN prplregist ON prplclaim.registNo = prplregist.registNo where" + conditions+" order by prplclaim.claimno" ;
    	  statement = SqlUtils.getWherePartForGetCount(statement);
    	log.debug(statement);
    	statement = SqlUtils.getWherePartForGetCount(statement);
    	ResultSet resultSet = dbManager.executeQuery(statement);
    	resultSet.next();
    	count = dbManager.getInt(resultSet,1);
    	resultSet.close();
    	log.info("DBPrpLclaimtg.getCount1() success!");
    	return count;
    }

//add b yzhaolu 20060802 end


 
}
