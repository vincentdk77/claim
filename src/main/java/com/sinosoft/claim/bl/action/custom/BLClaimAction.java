package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBClaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoins;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 立案action
 * <p>Title: 车险理赔 立案acton</p>
 * <p>Description: 车险理赔 立案acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuan
 * @version 1.0
 */
public class BLClaimAction
{
  public BLClaimAction()
  {
  }

  /**
   * 保存立案
   * @param claimDto：自定义立案对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ClaimDto claimDto)
    throws SQLException,Exception
  {
      DBClaim dbClaim = null;
      //业务操作
      dbClaim = new DBClaim();
      //if (this.isExist(claimDto.getPrpLclaimDto().getPrpLclaimClaimNo()))
      //{
        //dbClaim.delete(claimDto.getPrpLclaimDto().getPrpLclaimClaimNo());
      //}
      //如果是立案拒赔或者注销用savecancel的方法
      String strCaseType="";
      strCaseType=claimDto.getPrpLclaimDto().getCaseType();
      if (strCaseType.equals("1")|| strCaseType.equals("0"))
      {
         dbClaim.saveCancel(dbManager,claimDto);
      }
        else
        {//如果是新增加或者修改那么用insert
          dbClaim.insert(dbManager,claimDto);
        }
  }

  /**
   * 删除立案
   * @param  claimNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBClaim().delete(dbManager,claimNo);
  }

  /**
   * 获得立案
   * @param  claimNo
   * @param dbManager  数据连接
   * @return 自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public ClaimDto findByPrimaryKey(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
    ClaimDto claimDto = null;
    claimDto = new DBClaim().findByPrimaryKey(dbManager,claimNo);
    return claimDto;
  }

  /**
   * 判断立案通知号是否存在
   * @param claimNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String claimNo)throws SQLException,Exception
  {
     if (new DBClaim().findByPrimaryKey(dbManager,claimNo) == null)
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
  public Collection findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLclaim.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
}

  /**
   * 取得估损金额
   * @param  claimNo
   * @param dbManager  数据连接
   * @return 自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public PrpLclaimLossDto getClaimLoss(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
    PrpLclaimLossDto prpLclaimLossDto = null;
    prpLclaimLossDto = dbPrpLclaim.getClaimLoss(claimNo);
    return prpLclaimLossDto;
  }


   /**
   * 根据条件取得未决查询列表
   * @param dbManager DBManager
   * @param iWherePart 查询条件(不包括排序字句)
   * @param iOtherWherePart 附加查询条件
   * @throws UserException
   * @throws Exception
  */
  public Collection getNoEndCaseClaim(DBManager dbManager,String iWherePart,String iOtherWherePart) throws Exception{
    //在action里面写相应的计算过程和算法，目前只能这样了。

    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
    DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
    Collection collection = new ArrayList();           //最终返回结果的记录
    ArrayList collection1 = new ArrayList();           //第一步求和计算返回结果的记录
    ArrayList collection2 = new ArrayList();           //第二步求和计算返回结果的记录
    Collection sumForNoEndCaseList = new ArrayList();  //非主联共保和非临分业务的查询结果集合
    Collection sumForEndCaseList = new ArrayList();    //主联共保和临分业务的查询结果集合
    String nowRiskCode="";
    String nowCurrency="";
    String oldRiskCode="";
    String oldCurrency="";

    String strWherePart = "";
    String currency = "";
    double dblSumClaim  = 0.0;   //估损金额
    double dblSumDefLoss = 0.0;  //责任估损金额
    double dblShareRate = 100.0;
    int intCount = 0;

     //1.非主联共保和非临分业务
    sumForNoEndCaseList = dbPrpLclaim.querySumForNoEndCase(iWherePart,iOtherWherePart);
    Iterator it = sumForNoEndCaseList.iterator() ;

    //暂时利用prpLclaimDto来整理新求和后的数据，并把这些数据放入collection
    //结果集合的显示就是利用这个来实现的
    PrpLclaimDto prpLclaimDtoTemp = new PrpLclaimDto();

    while (it.hasNext() )
     {    PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
          prpLclaimDto = (PrpLclaimDto) it.next() ;
          dblSumClaim = 0.0;
          dblSumDefLoss = 0.0;

          //非主联共保和非临分业务的自负额比例等于法分比例
          dblShareRate = dbPrpLclaim.getRetentionRate(prpLclaimDto.getStartDate().getYear()  ,"11");
          //自负责任估损金额
          dblSumClaim =prpLclaimDto.getSumClaim();
          prpLclaimDto.setSumDefLoss(dblSumClaim*dblShareRate/100);

          //按照险种币别汇总
          nowRiskCode=prpLclaimDto.getRiskCode() ;
          nowCurrency = prpLclaimDto.getCurrency() ;

          if(nowRiskCode.equals(oldRiskCode)&& nowCurrency.equals(oldCurrency)  )
          { //计算
            dblSumClaim  = prpLclaimDto.getSumClaim()
                             + prpLclaimDtoTemp.getSumClaim();
            //计算求和
            prpLclaimDtoTemp.setSumClaim(dblSumClaim);
            dblSumDefLoss  = prpLclaimDtoTemp.getSumAmount()
                             + prpLclaimDto.getSumDefLoss();
            prpLclaimDtoTemp.setSumAmount(dblSumDefLoss);
            intCount    = prpLclaimDtoTemp.getCount()
                             + prpLclaimDto.getCount() ;
            prpLclaimDtoTemp.setCount(intCount);

            //如果已经是最后一行，则把结果加入
            if(!it.hasNext() ) collection1.add(prpLclaimDtoTemp);
          }
          else
          {
            //如果不是第一行，则把结果加入
            if(!prpLclaimDtoTemp.getRiskCode().equals("")) collection1.add(prpLclaimDtoTemp);
            //当险种和币别不同的
            prpLclaimDtoTemp=null;
            prpLclaimDtoTemp = new PrpLclaimDto();
            prpLclaimDtoTemp.setClassCode(prpLclaimDto.getClassCode());
            prpLclaimDtoTemp.setRiskCode(prpLclaimDto.getRiskCode());
            prpLclaimDtoTemp.setCurrency(prpLclaimDto.getCurrency());
            prpLclaimDtoTemp.setSumClaim(prpLclaimDto.getSumClaim());
            prpLclaimDtoTemp.setSumAmount(prpLclaimDto.getSumDefLoss());
            prpLclaimDtoTemp.setCount(prpLclaimDto.getCount() );
          }

          oldRiskCode = nowRiskCode;
          oldCurrency = nowCurrency;
     }


        //2.主联共保和临分业务
        strWherePart =iWherePart+" AND PolicyNo IN (Select PolicyNo From PrpCmain WHERE (CoinsFlag='1' OR ReinsFlag IN ('1','2'))) order by riskcode,currency";
        //因为以上的sql 中都是按照riskcode和currency排过序列的，所以才会有以下算法。
        sumForEndCaseList=dbPrpLclaim.findByConditions(strWherePart) ;
        it=null;
        it =  sumForEndCaseList.iterator() ;
        //初始变量
        oldRiskCode="";
        oldCurrency ="";
        prpLclaimDtoTemp =null;
        prpLclaimDtoTemp = new PrpLclaimDto();
        while (it.hasNext() )
        {
          PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
          prpLclaimDto=(PrpLclaimDto)it.next() ;
          dblSumClaim  = 0.0;
          dblSumDefLoss = 0.0;

          PrpCmainDto prpCmainDto = new PrpCmainDto();
          prpCmainDto =dbPrpCmain.findByPrimaryKey(prpLclaimDto.getPolicyNo()) ;
          //获取自负额比例??
          dblShareRate = getShareRate(dbManager,prpCmainDto);

          //自负责任估损金额
          dblSumClaim = prpLclaimDto.getSumClaim();
          prpLclaimDto.setSumDefLoss(dblSumClaim*dblShareRate/100);

          //按照险种币别汇总
          nowRiskCode=prpLclaimDto.getRiskCode() ;
          nowCurrency = prpLclaimDto.getCurrency() ;

          if(nowRiskCode.equals(oldRiskCode)&& nowCurrency.equals(oldCurrency)  )
          {
              dblSumClaim = prpLclaimDtoTemp.getSumClaim()
                  + prpLclaimDto.getSumClaim();
              prpLclaimDtoTemp.setSumClaim(dblSumClaim);
              dblSumDefLoss = prpLclaimDtoTemp.getSumAmount()
                  + prpLclaimDto.getSumDefLoss();
              prpLclaimDtoTemp.setSumAmount(dblSumDefLoss);
              intCount    =prpLclaimDtoTemp.getCount() + 1;
              prpLclaimDtoTemp.setCount(intCount);

              //如果已经是最后一行，则把结果加入
            if(!it.hasNext() ) collection2.add(prpLclaimDtoTemp);
            }
         else
         {
           //如果不是第一行，则把结果加入
          if(!prpLclaimDtoTemp.getRiskCode().equals("")) collection2.add(prpLclaimDtoTemp);
           prpLclaimDtoTemp =null;
           prpLclaimDtoTemp = new PrpLclaimDto();
           prpLclaimDtoTemp.setClassCode(prpLclaimDto.getClassCode());
           prpLclaimDtoTemp.setRiskCode(prpLclaimDto.getRiskCode());
           prpLclaimDtoTemp.setCurrency(prpLclaimDto.getCurrency());
           prpLclaimDtoTemp.setSumClaim(prpLclaimDto.getSumClaim());
           prpLclaimDtoTemp.setSumAmount(prpLclaimDto.getSumDefLoss());
           prpLclaimDtoTemp.setCount(1);

         }

         oldRiskCode = nowRiskCode;
         oldCurrency = nowCurrency;
       }
       //并将第一步得到的结果集合合并在一起，行成最终的结果集合
       int i=0;
       int j=0;
       int levelequals=0;
       //如果两个集合都有记录
       if (collection1.size()>0&&collection2.size()>0)
       {
         //利用collection来合并SumClaim,SumAmount,Count
         for (i=0;i<collection1.size();i++)
         {
           PrpLclaimDto prpLclaimDto1 = new PrpLclaimDto();
           prpLclaimDto1 = (PrpLclaimDto)collection1.get(i) ;
           for (j=0;j<collection2.size();j++)
           {
             PrpLclaimDto prpLclaimDto2 = new PrpLclaimDto();
             prpLclaimDto2 = (PrpLclaimDto)collection2.get(j) ;

             //判断1和2中是否有相等的集合
             if (prpLclaimDto1.getRiskCode().equals(prpLclaimDto2.getRiskCode())
                 &&prpLclaimDto1.getCurrency().equals(prpLclaimDto2.getCurrency()))
                {
                  //找到collection2中有相同的险种和相同币别的记录，如果没有的话，就继续
                  prpLclaimDto1.setSumClaim(prpLclaimDto1.getSumClaim()+prpLclaimDto2.getSumClaim());
                  prpLclaimDto1.setSumAmount(prpLclaimDto1.getSumAmount()+prpLclaimDto2.getSumAmount());
                  prpLclaimDto1.setCount(prpLclaimDto1.getCount()+prpLclaimDto2.getCount() );
                  //去掉collection2中合计过的数据
                  collection2.remove(j);
                  break;
                }
             }
            collection.add(prpLclaimDto1) ;
         }

         //判断是否还有collection2的记录没有加完

         for (j=0;j<collection2.size();j++)
         {   PrpLclaimDto prpLclaimDto2 = new PrpLclaimDto();
             prpLclaimDto2 = (PrpLclaimDto)collection2.get(j) ;
             collection.add(prpLclaimDto2) ;
         }
          //如何实现排列的顺序呢?
       }
       else
       {
          //直接合并,因为另个结果集合为0
          if (collection1.size()>0) collection=collection1;
          if (collection2.size()>0) collection=collection2;
       }



    return collection;
  }

  /**
 * @Author     : 项目组
 * @desc  获取保单的自留比例
 * @param iPolicyNo 保单号
 * @return dblShareRate 自留比例
 */
public double getShareRate(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception
{
  double dblShareRate = 100.0;
  double dblCoinsRate = 1;    //共保比例
  String strWherePart = "";
  DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
  DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
  Collection prpCcoinsList = new ArrayList();
  try
  {
    //1. 取共保比例
    if(prpCmainDto.getCoinsFlag().equals("1"))
    {
      strWherePart = " CoinsType='1' And PolicyNo='" + prpCmainDto.getPolicyNo() + "'";
      prpCcoinsList = dbPrpCcoins.findByConditions(strWherePart) ;
      Iterator it = prpCcoinsList.iterator() ;
      PrpCcoinsDto prpCcoinsDto = new PrpCcoinsDto();
      if(it.hasNext() )
      {
        prpCcoinsDto=(PrpCcoinsDto)it.next();
        dblCoinsRate = prpCcoinsDto.getCoinsRate()/100;
      }
   }

    //2. 获取临分自留比例
    if (prpCmainDto.getReinsFlag().equals("2")  || prpCmainDto.getReinsFlag().equals("1"))
    {
      strWherePart   = " PolicyNo = '"+prpCmainDto.getPolicyNo()+"'" ;
      String  strRepolicyNo="";
      strRepolicyNo=dbPrpLclaim.getFcoRepolicy(strWherePart);
      if (strRepolicyNo.equals("") )
      {
        dblShareRate = 100;
      }
      else
      {
        strWherePart = " RePolicyNo ='"+ strRepolicyNo+"'";
        dblShareRate =dbPrpLclaim.getFcoAbstractShareRate(strWherePart);
        }
      }
     if(dblShareRate==100)
      dblShareRate -= (100 - dbPrpLclaim.getRetentionRate(prpCmainDto.getStartDate().getYear()  ,"11"));
      dblShareRate = dblShareRate * dblCoinsRate;
  }
  catch(Exception e)
  {
    throw e;
  }
  return dblShareRate;
}

 /**
   * 按条件查询已决信息
   * @param dbManager DBManager
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection querySumEndCase(DBManager dbManager,String conditions) throws Exception{



    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLclaim.findSumEndCaseByConditions(conditions,0,0);
    return collection;
}

  /**
    * 按条件查询已决信息的详细清单，需要从表prplcfee中查询
    * @param dbManager DBManager
    * @param conditions String
    * @throws Exception
    * @return Collection
    */
   public Collection querySumEndCaseDetail(DBManager dbManager,String conditions) throws Exception{

   //利用prplclaimDto这个来做数据的传递

     DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
     DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
     DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
     Collection collection = new ArrayList();
     Collection prpLcfeeDtoList = new ArrayList();


     if(conditions.trim().length()==0){
         conditions = "1=1";
     }

     prpLcfeeDtoList = dbPrpLcfee.findByConditions(conditions,0,0);

     Iterator it = prpLcfeeDtoList.iterator() ;
     while (it.hasNext() )
     {
      PrpLcfeeDto prpLcfeeDto  = new PrpLcfeeDto ();
      prpLcfeeDto  = (PrpLcfeeDto )it.next();
      PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
      PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
      PrpCmainDto prpCmainDto = new PrpCmainDto();

      //获取相应的其他信息，然后整理到prplclaimDto中，最后扔出collection
      prpLcompensateDto =dbPrpLcompensate.findByPrimaryKey(prpLcfeeDto.getCompensateNo()) ;
      prpCmainDto=   dbPrpCmain.findByPrimaryKey(prpLcfeeDto.getPolicyNo() );
      //整理prpLclaimDto
      prpLclaimDto.setPolicyNo(prpLcfeeDto.getPolicyNo()) ;
      prpLclaimDto.setRiskCode(prpLcfeeDto.getRiskCode());
      prpLclaimDto.setSumPaid(prpLcfeeDto.getSumPaid()   );
      prpLclaimDto.setCurrency(prpLcfeeDto.getCurrency()   );
      prpLclaimDto.setCompensateNo(prpLcfeeDto.getCompensateNo() );
      prpLclaimDto.setClaimNo(prpLcompensateDto.getClaimNo() );
      prpLclaimDto.setInsuredCode(prpCmainDto.getInsuredCode()  );
      prpLclaimDto.setInsuredName(prpCmainDto.getInsuredName()  );
      //加入集合
      collection.add(prpLclaimDto);
    }
    return collection;
 }


  /**
   * @param claimNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public void UpdCaseType(DBManager dbManager,String claimNo)throws SQLException,Exception
  {
	new DBClaim().UpdCaseType(dbManager,claimNo);
  }
  
  public void UpdSumClaim(DBManager dbManager,ClaimDto claimDto,String claimNo,double sumClaim)throws SQLException,Exception
  {
	new DBClaim().UpdSumClaim(dbManager,claimDto,claimNo,sumClaim);
  }
  //modify by liuyanmei add start 20051102 
  public void updateEndCaseDate(DBManager dbManager,String claimNo,Date endCaseDate)
  throws SQLException,Exception
{
   
    new DBClaim().updateEndCaseDate(dbManager,claimNo,endCaseDate);
}
  //modify by liuyanmei  add start 20051102
  
  //modify by wangwei add start 2005-06-04
  /**
   * 获得立案对象的集合
   * @param  policyNo
   * @param dbManager  数据连接
   * @return 自定义立案集合对象
   * @throws SQLException
   * @throws Exception
   */
  public Object findByPolicyNo(DBManager dbManager,String policyNo)
    throws SQLException,Exception {
  	Object prpLclaimDtoList = null;
    prpLclaimDtoList = new DBClaim().findByPolicyNo(dbManager,policyNo);
    return prpLclaimDtoList;
  }
  
  public Object findByPolicyNo(DBManager dbManager,String policyNo,String idcard)
  throws SQLException,Exception {
	Object prpLclaimDtoList = null;
  prpLclaimDtoList = new DBClaim().findByPolicyNo(dbManager,policyNo,idcard);
  return prpLclaimDtoList;
}
  //modify by wangwei add end 2005-06-04
  
  
  
  //add by zhaolu 20060802 start
  public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
      
	    collection = dbPrpLclaim.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    int count = dbPrpLclaim.getCount1(SqlUtils.getWherePartForGetCount(conditions));
	    int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    if(maxQueryCount!=0&&count>maxQueryCount){   
	      throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
	    }
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
	}
  //add by zhaolu 20060802 end
}
