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
 * 实赔action
 * <p>Title: 车险理赔 实赔acton</p>
 * <p>Description: 车险理赔 实赔acton</p>
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
   * 保存实赔
   * @param compensateDto：自定义实赔对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void backToCerta(DBManager dbManager,String claimNo,PrpLverifyLossDto prpLverifyLossDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //业务操作
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
   * 保存实赔
   * @param compensateDto：自定义实赔对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CompensateDto compensateDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //业务操作
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
   * 改变实赔状态
   * @param compensateDto：自定义实赔对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,PrpLcompensateDto compensateDto)
    throws SQLException,Exception
  {
      DBCompensate dbCompensate = null;
      //业务操作
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
   * 删除实赔
   * @param  compensateNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String compensateNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBCompensate().delete(dbManager,compensateNo);
  }

  /**
   * 获得实赔
   * @param  compensateNo
   * @param dbManager  数据连接
   * @return 自定义实赔对象
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
   * 获得实赔
   * @param  compensateNo
   * @param dbManager  数据连接
   * @return 自定义实赔对象
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
   * 判断实赔通知号是否存在
   * @param compensateNo
   * @param dbManager  数据连接
   * @return 是/否
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
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcompensate.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * 按条件查询多条数据
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-09-07 Reason:实赔复核查询条件
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
   *  复核实赔
   * @param compensateNo：赔款计算书号码
   * @param userCode：复核员代码
   * @param underWriteFlag：核赔标志
   * @param dbManager  数据连接
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
   * 查询特别约定,赔偿限额/免赔额信息
   * @param  compensateDto
   * @param dbManager  数据连接
   * @return 自定义实赔对象
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
   *  获得立案对应的计算书信息
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   *  Add By wangli 2005-04-20 Reason:根据赔案号查询对应的计算书
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
   *  获得立案对应的核赔通过的计算书信息
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   *  Add By wangli 2005-04-20 Reason:根据赔案号查询对应的计算书
   */

  public Collection findPrpLcompensateOfValidUndwrtByClaimNo(DBManager dbManager,String claimNo) throws Exception{
    DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
    Collection collection = new ArrayList();

    String conditionAll = " underwriteflag in('1','3') and claimNo='"+claimNo+"' order by underwriteenddate asc";
    collection = dbPrpLcompensate.findByConditions(conditionAll);
    return collection;
  }
  
  
  
  /**
   * 根据赔案号得到已决赔款
   * @param claimNo 赔案号
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
      throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
    }
	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	return pageRecord;
  }
  //add by zhaolu 20060803 end
  
  
  /**
   * 是否允许删除理算书校验函数
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
	    //删除计算书时，增加计算书是否送收付判断
	    boolean payFlag = dbPrpLcompensate.checkCompensatePay(compensateNo);
	    if(payFlag){
	    	throw new UserException(1,3,"0000","计算书"+compensateNo+"删除失败，原因：理算书数据已送收付系统");
	    }else{
	    	if(flag){   
		        throw new UserException(1,3,"0000","计算书"+compensateNo+"删除失败，原因：理算书不是核赔退回或正处理状态"); 
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
