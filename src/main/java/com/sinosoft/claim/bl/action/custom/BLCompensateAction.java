package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCompensate;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ʵ��action
 * <p>Title: �������� ʵ��acton</p>
 * <p>Description: �������� ʵ��acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCompensateAction
{
  public BLCompensateAction()
  {
  }

  /**
   * ����ʵ��
   * @param compensateDto���Զ���ʵ�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void backToCerta(DBManager dbManager,String claimNo,PrpLverifyLossDto prpLverifyLossDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //ҵ�����
      dbCompensate = new DBCompensate();
      /*
      if (this.isExist(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo()))
      {
        dbCompensate.delete(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo());
      }
      */
      dbCompensate.backToCerta(dbManager,claimNo,prpLverifyLossDto);

  }

  
  /**
   * ����ʵ��
   * @param compensateDto���Զ���ʵ�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CompensateDto compensateDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //ҵ�����
      dbCompensate = new DBCompensate();
      /*
      if (this.isExist(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo()))
      {
        dbCompensate.delete(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo());
      }
      */
      dbCompensate.insert(dbManager,compensateDto);

  }
  /**
   * �ı�ʵ��״̬
   * @param compensateDto���Զ���ʵ�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,PrpLcompensateDto compensateDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //ҵ�����
      dbCompensate = new DBCompensate();
      /*
      if (this.isExist(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo()))
      {
        dbCompensate.delete(dbManager,compensateDto.getPrpLcompensateDto().getCompensateNo());
      }
      */
      dbCompensate.insert(dbManager,compensateDto);

  }

  /**
   * ɾ��ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String compensateNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBCompensate().delete(dbManager,compensateNo);
  }

  /**
   * ���ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByPrimaryKey(DBManager dbManager,String compensateNo)
    throws SQLException,Exception
  {
    CompensateDto compensateDto = null;
    compensateDto = new DBCompensate().findByPrimaryKey(dbManager,compensateNo);
    return compensateDto;
  }

  // add by lym for InderectFee group by kindCode-------------Start
	public Collection findByCompensateNo(DBManager dbManager,String compensateNo) throws SQLException, Exception {
		Collection derectFeeList = new ArrayList();
		derectFeeList = (ArrayList) new DBCompensate().findByCompensateNo(
				dbManager, compensateNo);
		return derectFeeList;
	}

	// add by lym for InderectFee group by kindCode-------------end
  
  
  
  /**
   * ���ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByPrimaryKey(DBManager dbManager,String compensateNo,String caseType)
    throws SQLException,Exception
  {
    CompensateDto compensateDto = null;
    compensateDto = new DBCompensate().findByPrimaryKey(dbManager,compensateNo,caseType);
    return compensateDto;
  }
  /**
   * �ж�ʵ��֪ͨ���Ƿ����
   * @param compensateNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String compensateNo)throws SQLException,Exception
  {
           if (new DBCompensate().findByPrimaryKey(dbManager,compensateNo) == null)
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
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcompensate.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-09-07 Reason:ʵ�⸴�˲�ѯ����
   */

  public Collection findByApproveQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcompensate.findByApproveQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   *  ����ʵ��
   * @param compensateNo�������������
   * @param userCode������Ա����
   * @param underWriteFlag�������־
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void approve(DBManager dbManager,String compensateNo,String userCode,String underWriteFlag)
    throws SQLException,Exception
  {
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    dbPrpLcompensate.approve(compensateNo,userCode,underWriteFlag);
  }

  /**
   * ��ѯ�ر�Լ��,�⳥�޶�/�������Ϣ
   * @param  compensateDto
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByAppendInformation(DBManager dbManager,CompensateDto compensateDto)
    throws SQLException,Exception
  {
    //CompensateDto compensateDto = null;
    compensateDto = new DBCompensate().findByAppendInformation(dbManager,compensateDto);
    return compensateDto;
  }
  
  //modify by wangli add start 20050420
  /**
   *  ���������Ӧ�ļ�������Ϣ
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   *  Add By wangli 2005-04-20 Reason:�����ⰸ�Ų�ѯ��Ӧ�ļ�����
   */

  public Collection findByClaimNo(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcompensate.findByConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }
  
  
  //modify by wangli add start 20050420
  /**
   *  ���������Ӧ�ĺ���ͨ���ļ�������Ϣ
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   *  Add By wangli 2005-04-20 Reason:�����ⰸ�Ų�ѯ��Ӧ�ļ�����
   */

  public Collection findPrpLcompensateOfValidUndwrtByClaimNo(DBManager dbManager,String claimNo) throws Exception{
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    String conditionAll = " underwriteflag in('1','3') and claimNo='"+claimNo+"' order by underwriteenddate asc";
    collection = dbPrpLcompensate.findByConditions(conditionAll);
    return collection;
  }
  
  
  
  /**
   * �����ⰸ�ŵõ��Ѿ����
   * @param claimNo �ⰸ��
   * @author wangli 
   * @return
   * @throws Exception
   */
  public CompensateFeeDto findCompensateFeeByClaimNo(DBManager dbManager,String claimNo) throws Exception{
  	DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
  	CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
  	
  	compensateFeeDto = dbPrpLcompensate.findCompensateFeeByClaimNo(claimNo);
  
  	return compensateFeeDto;
  }
  //modify by wangli add end 20050529 
  
  
  //add by zhaolu 20060803 start
  public PageRecord findByQueryCondition(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception
  {
  
	DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
	Collection collection = new ArrayList();
	
	if(conditions.trim().length()==0){
		conditions = "1=1";
	}
	collection = dbPrpLcompensate.findByQueryConditions(conditions,pageNo,rowsPerPage);
	int count = dbPrpLcompensate.getCount1(SqlUtils.getWherePartForGetCount(conditions));
	int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
    if(maxQueryCount!=0&&count>maxQueryCount){   
      throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
    }
	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	return pageRecord;
  }
  //add by zhaolu 20060803 end
  
  
  /**
   * �Ƿ�����ɾ��������У�麯��
   */
  public void  checkCompensateNo(DBManager dbManager,String compensateNo) throws Exception{	  
	    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
	    String riskCode="";
	    String settlelistcode="";
	    String settlelistcodeForMedical="";
	    BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
	    BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical = new BLSettlemainlistFacadeForMedical();
	    String str=" compensateNo='"+compensateNo+"'";
	    ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
	    ArrayList arrForMedical = (ArrayList)blSettlemainlistFacadeForMedical.findByConditions(str);
	    SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
	    SettlemainlistDto settlemainlistDtoForMedical = new SettlemainlistDto();
	    if(arr.size()>0){
	    	settlemainlistDto=(SettlemainlistDto)arr.get(0);
	    	settlelistcode=settlemainlistDto.getSettlelistcode();
	    }
	    if(arrForMedical.size()>0){
	    	settlemainlistDtoForMedical=(SettlemainlistDto)arrForMedical.get(0);
	    	settlelistcodeForMedical=settlemainlistDtoForMedical.getSettlelistcode();
	    }
	    String condition="update plantingSettlelist set validity='4' where settlelistcode='"+settlelistcode+"' and validity='1' and nodetype='compe'";
	    String condition0311="update temblorSettlelist set validity='4' where settlelistcode='"+settlelistcode+"' and validity='1' and nodetype='compe'";
	    String condition1="update settlemainlist set compensateNo='' where compensateNo='"+compensateNo+"' and validity='2'";
	    String condition2="update medicalSettlelist set validity='4' where settlelistcode='"+settlelistcodeForMedical+"' and validity='1' and nodetype='compe'";
	    PrpLcompensateDto prpLcompensateDto=dbPrpLcompensate.findByPrimaryKey(compensateNo);
	    if(!"".equals(prpLcompensateDto)&&null!=prpLcompensateDto){
	    	riskCode=prpLcompensateDto.getRiskCode();
	    }
	    boolean flag =   dbPrpLcompensate.checkCompensateNo(compensateNo);
	    //ɾ��������ʱ�����Ӽ������Ƿ����ո��ж�
	    boolean payFlag = dbPrpLcompensate.checkCompensatePay(compensateNo);
	    if(payFlag){
	    	throw new UserException(1,3,"0000","������"+compensateNo+"ɾ��ʧ�ܣ�ԭ�����������������ո�ϵͳ");
	    }else{
	    	if(flag){   
		        throw new UserException(1,3,"0000","������"+compensateNo+"ɾ��ʧ�ܣ�ԭ�������鲻�Ǻ����˻ػ�������״̬"); 
		    }else{
		    if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3149,3150,3148,3151,3197,3185,3166,3184,3165,3174,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(riskCode) > -1)){	
		    DBManager dbManager1 = new DBManager();
	      try{
	          dbManager1.open("NXDADataSource");
	          dbManager1.executeUpdate(condition);
	          dbManager1.executeUpdate(condition1);
	      }catch(Exception exception){
	          throw exception;
	      }finally{
	          dbManager1.close();
	      }
		    }
		    else if("2801".indexOf(riskCode) > -1 || "2607".indexOf(riskCode) > -1 || "2605".indexOf(riskCode) > -1 || "2606".indexOf(riskCode) > -1)
		    {
			    DBManager dbManager2 = new DBManager();
			      try{
			    	  dbManager2.open("JKXDataSource");
			    	  dbManager2.executeUpdate(condition2);
			    	  dbManager2.executeUpdate(condition1);
			      }catch(Exception exception){
			          throw exception;
			      }finally{
			    	  dbManager2.close();
			      }
		    }
		    else if("0311".indexOf(riskCode) > -1 )
		    {
			    DBManager dbManager3 = new DBManager();
			      try{
			    	  dbManager3.open("NXDADataSource");
			    	  dbManager3.executeUpdate(condition0311);
			    	  dbManager3.executeUpdate(condition1);
			      }catch(Exception exception){
			          throw exception;
			      }finally{
			    	  dbManager3.close();
			      }
		    }

		    }
	    }
}
  
}
