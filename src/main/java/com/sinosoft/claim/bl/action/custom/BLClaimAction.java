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
 * ����action
 * <p>Title: �������� ����acton</p>
 * <p>Description: �������� ����acton</p>
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
   * ��������
   * @param claimDto���Զ�����������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ClaimDto claimDto)
    throws SQLException,Exception
  {
      DBClaim dbClaim = null;
      //ҵ�����
      dbClaim = new DBClaim();
      //if (this.isExist(claimDto.getPrpLclaimDto().getPrpLclaimClaimNo()))
      //{
        //dbClaim.delete(claimDto.getPrpLclaimDto().getPrpLclaimClaimNo());
      //}
      //����������������ע����savecancel�ķ���
      String strCaseType="";
      strCaseType=claimDto.getPrpLclaimDto().getCaseType();
      if (strCaseType.equals("1")|| strCaseType.equals("0"))
      {
         dbClaim.saveCancel(dbManager,claimDto);
      }
        else
        {//����������ӻ����޸���ô��insert
          dbClaim.insert(dbManager,claimDto);
        }
  }

  /**
   * ɾ������
   * @param  claimNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBClaim().delete(dbManager,claimNo);
  }

  /**
   * �������
   * @param  claimNo
   * @param dbManager  ��������
   * @return �Զ�����������
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
   * �ж�����֪ͨ���Ƿ����
   * @param claimNo
   * @param dbManager  ��������
   * @return ��/��
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
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
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
   * ȡ�ù�����
   * @param  claimNo
   * @param dbManager  ��������
   * @return �Զ�����������
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
   * ��������ȡ��δ����ѯ�б�
   * @param dbManager DBManager
   * @param iWherePart ��ѯ����(�����������־�)
   * @param iOtherWherePart ���Ӳ�ѯ����
   * @throws UserException
   * @throws Exception
  */
  public Collection getNoEndCaseClaim(DBManager dbManager,String iWherePart,String iOtherWherePart) throws Exception{
    //��action����д��Ӧ�ļ�����̺��㷨��Ŀǰֻ�������ˡ�

    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
    DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
    Collection collection = new ArrayList();           //���շ��ؽ���ļ�¼
    ArrayList collection1 = new ArrayList();           //��һ����ͼ��㷵�ؽ���ļ�¼
    ArrayList collection2 = new ArrayList();           //�ڶ�����ͼ��㷵�ؽ���ļ�¼
    Collection sumForNoEndCaseList = new ArrayList();  //�����������ͷ��ٷ�ҵ��Ĳ�ѯ�������
    Collection sumForEndCaseList = new ArrayList();    //�����������ٷ�ҵ��Ĳ�ѯ�������
    String nowRiskCode="";
    String nowCurrency="";
    String oldRiskCode="";
    String oldCurrency="";

    String strWherePart = "";
    String currency = "";
    double dblSumClaim  = 0.0;   //������
    double dblSumDefLoss = 0.0;  //���ι�����
    double dblShareRate = 100.0;
    int intCount = 0;

     //1.�����������ͷ��ٷ�ҵ��
    sumForNoEndCaseList = dbPrpLclaim.querySumForNoEndCase(iWherePart,iOtherWherePart);
    Iterator it = sumForNoEndCaseList.iterator() ;

    //��ʱ����prpLclaimDto����������ͺ�����ݣ�������Щ���ݷ���collection
    //������ϵ���ʾ�������������ʵ�ֵ�
    PrpLclaimDto prpLclaimDtoTemp = new PrpLclaimDto();

    while (it.hasNext() )
     {    PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
          prpLclaimDto = (PrpLclaimDto) it.next() ;
          dblSumClaim = 0.0;
          dblSumDefLoss = 0.0;

          //�����������ͷ��ٷ�ҵ����Ը���������ڷ��ֱ���
          dblShareRate = dbPrpLclaim.getRetentionRate(prpLclaimDto.getStartDate().getYear()  ,"11");
          //�Ը����ι�����
          dblSumClaim =prpLclaimDto.getSumClaim();
          prpLclaimDto.setSumDefLoss(dblSumClaim*dblShareRate/100);

          //�������ֱұ����
          nowRiskCode=prpLclaimDto.getRiskCode() ;
          nowCurrency = prpLclaimDto.getCurrency() ;

          if(nowRiskCode.equals(oldRiskCode)&& nowCurrency.equals(oldCurrency)  )
          { //����
            dblSumClaim  = prpLclaimDto.getSumClaim()
                             + prpLclaimDtoTemp.getSumClaim();
            //�������
            prpLclaimDtoTemp.setSumClaim(dblSumClaim);
            dblSumDefLoss  = prpLclaimDtoTemp.getSumAmount()
                             + prpLclaimDto.getSumDefLoss();
            prpLclaimDtoTemp.setSumAmount(dblSumDefLoss);
            intCount    = prpLclaimDtoTemp.getCount()
                             + prpLclaimDto.getCount() ;
            prpLclaimDtoTemp.setCount(intCount);

            //����Ѿ������һ�У���ѽ������
            if(!it.hasNext() ) collection1.add(prpLclaimDtoTemp);
          }
          else
          {
            //������ǵ�һ�У���ѽ������
            if(!prpLclaimDtoTemp.getRiskCode().equals("")) collection1.add(prpLclaimDtoTemp);
            //�����ֺͱұ�ͬ��
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


        //2.�����������ٷ�ҵ��
        strWherePart =iWherePart+" AND PolicyNo IN (Select PolicyNo From PrpCmain WHERE (CoinsFlag='1' OR ReinsFlag IN ('1','2'))) order by riskcode,currency";
        //��Ϊ���ϵ�sql �ж��ǰ���riskcode��currency�Ź����еģ����ԲŻ��������㷨��
        sumForEndCaseList=dbPrpLclaim.findByConditions(strWherePart) ;
        it=null;
        it =  sumForEndCaseList.iterator() ;
        //��ʼ����
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
          //��ȡ�Ը������??
          dblShareRate = getShareRate(dbManager,prpCmainDto);

          //�Ը����ι�����
          dblSumClaim = prpLclaimDto.getSumClaim();
          prpLclaimDto.setSumDefLoss(dblSumClaim*dblShareRate/100);

          //�������ֱұ����
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

              //����Ѿ������һ�У���ѽ������
            if(!it.hasNext() ) collection2.add(prpLclaimDtoTemp);
            }
         else
         {
           //������ǵ�һ�У���ѽ������
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
       //������һ���õ��Ľ�����Ϻϲ���һ���г����յĽ������
       int i=0;
       int j=0;
       int levelequals=0;
       //����������϶��м�¼
       if (collection1.size()>0&&collection2.size()>0)
       {
         //����collection���ϲ�SumClaim,SumAmount,Count
         for (i=0;i<collection1.size();i++)
         {
           PrpLclaimDto prpLclaimDto1 = new PrpLclaimDto();
           prpLclaimDto1 = (PrpLclaimDto)collection1.get(i) ;
           for (j=0;j<collection2.size();j++)
           {
             PrpLclaimDto prpLclaimDto2 = new PrpLclaimDto();
             prpLclaimDto2 = (PrpLclaimDto)collection2.get(j) ;

             //�ж�1��2���Ƿ�����ȵļ���
             if (prpLclaimDto1.getRiskCode().equals(prpLclaimDto2.getRiskCode())
                 &&prpLclaimDto1.getCurrency().equals(prpLclaimDto2.getCurrency()))
                {
                  //�ҵ�collection2������ͬ�����ֺ���ͬ�ұ�ļ�¼�����û�еĻ����ͼ���
                  prpLclaimDto1.setSumClaim(prpLclaimDto1.getSumClaim()+prpLclaimDto2.getSumClaim());
                  prpLclaimDto1.setSumAmount(prpLclaimDto1.getSumAmount()+prpLclaimDto2.getSumAmount());
                  prpLclaimDto1.setCount(prpLclaimDto1.getCount()+prpLclaimDto2.getCount() );
                  //ȥ��collection2�кϼƹ�������
                  collection2.remove(j);
                  break;
                }
             }
            collection.add(prpLclaimDto1) ;
         }

         //�ж��Ƿ���collection2�ļ�¼û�м���

         for (j=0;j<collection2.size();j++)
         {   PrpLclaimDto prpLclaimDto2 = new PrpLclaimDto();
             prpLclaimDto2 = (PrpLclaimDto)collection2.get(j) ;
             collection.add(prpLclaimDto2) ;
         }
          //���ʵ�����е�˳����?
       }
       else
       {
          //ֱ�Ӻϲ�,��Ϊ����������Ϊ0
          if (collection1.size()>0) collection=collection1;
          if (collection2.size()>0) collection=collection2;
       }



    return collection;
  }

  /**
 * @Author     : ��Ŀ��
 * @desc  ��ȡ��������������
 * @param iPolicyNo ������
 * @return dblShareRate ��������
 */
public double getShareRate(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception
{
  double dblShareRate = 100.0;
  double dblCoinsRate = 1;    //��������
  String strWherePart = "";
  DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
  DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
  Collection prpCcoinsList = new ArrayList();
  try
  {
    //1. ȡ��������
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

    //2. ��ȡ�ٷ���������
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
   * ��������ѯ�Ѿ���Ϣ
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
    * ��������ѯ�Ѿ���Ϣ����ϸ�嵥����Ҫ�ӱ�prplcfee�в�ѯ
    * @param dbManager DBManager
    * @param conditions String
    * @throws Exception
    * @return Collection
    */
   public Collection querySumEndCaseDetail(DBManager dbManager,String conditions) throws Exception{

   //����prplclaimDto����������ݵĴ���

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

      //��ȡ��Ӧ��������Ϣ��Ȼ������prplclaimDto�У�����ӳ�collection
      prpLcompensateDto =dbPrpLcompensate.findByPrimaryKey(prpLcfeeDto.getCompensateNo()) ;
      prpCmainDto=   dbPrpCmain.findByPrimaryKey(prpLcfeeDto.getPolicyNo() );
      //����prpLclaimDto
      prpLclaimDto.setPolicyNo(prpLcfeeDto.getPolicyNo()) ;
      prpLclaimDto.setRiskCode(prpLcfeeDto.getRiskCode());
      prpLclaimDto.setSumPaid(prpLcfeeDto.getSumPaid()   );
      prpLclaimDto.setCurrency(prpLcfeeDto.getCurrency()   );
      prpLclaimDto.setCompensateNo(prpLcfeeDto.getCompensateNo() );
      prpLclaimDto.setClaimNo(prpLcompensateDto.getClaimNo() );
      prpLclaimDto.setInsuredCode(prpCmainDto.getInsuredCode()  );
      prpLclaimDto.setInsuredName(prpCmainDto.getInsuredName()  );
      //���뼯��
      collection.add(prpLclaimDto);
    }
    return collection;
 }


  /**
   * @param claimNo
   * @param dbManager  ��������
   * @return ��/��
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
   * �����������ļ���
   * @param  policyNo
   * @param dbManager  ��������
   * @return �Զ����������϶���
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
	      throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
	    }
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
	}
  //add by zhaolu 20060802 end
}
