package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBRegist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.prpall.blsvr.lp.BLPrpLclaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 报案action
 * <p>Title: 车险理赔 报案acton</p>
 * <p>Description: 车险理赔 报案acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class BLRegistAction
{
  public BLRegistAction()
  {
  }

  /**
   * 保存报案
   * @param registDto：自定义报案对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
      DBRegist dbRegist = null;
      //业务操作
      dbRegist = new DBRegist();
      if (this.isExist(dbManager,registDto.getPrpLregistDto().getRegistNo()))
      {
        dbRegist.delete(dbManager,registDto.getPrpLregistDto().getRegistNo());
      }
      dbRegist.insert(dbManager,registDto);

  }

  /**
   * 删除报案
   * @param  registNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
      //业务操作
     new DBRegist().delete(dbManager,registNo);


  }

  /**
   * 获得报案
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义报案对象
   * @throws SQLException
   * @throws Exception
   */
  public RegistDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    RegistDto registDto = null;
    registDto = new DBRegist().findByPrimaryKey(dbManager,registNo);
    return registDto;
  }

  /**
   * 判断报案通知号是否存在
   * @param registNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String registNo)throws SQLException,Exception
  {   DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
      String strSql ="registNo='"+ registNo+"'";
      if(dbPrpLregist.getCount(strSql)<1)
      //     if (new DBPrpLregist().getCount(dbManager,registNo) == null)
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
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.findByQueryConditions(conditions,pageNo,rowsPerPage);
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
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findSamePolicyRegist(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.findSamePolicyRegist(conditions,pageNo,rowsPerPage);
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
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection getWorkFlowList(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.getWorkFlowList(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * 获得相关的节点信息
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义报案对象
   * @throws SQLException
   * @throws Exception
   */
  public CaseRelateNodeDto relateNode(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CaseRelateNodeDto raseRelateNodeDto = null;
    raseRelateNodeDto = new DBRegist().relateNode(dbManager,registNo);
    return raseRelateNodeDto;
  }

  
  /**
   * 保存报案注销信息带工作流处理的过程
   * @param registDto：自定义报案对象
   * @param workFlowDto：工作流对象
   * @throws SQLException
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLRegistAction().saveRegistCancel(dbManager,registDto);

      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }

      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }

  /**
   * 保存报案注销信息
   * @param registDto：自定义报案对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void saveRegistCancel(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
      DBRegist dbRegist = null;
      //业务操作
      dbRegist = new DBRegist();
      dbRegist.insertRegistCancel(dbManager,registDto);
  }
  
  

	//add by zhaolu 20060801 start
   //按条件查询多条数据
  public PageRecord findForRegistConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
			conditions = "1=1";
		}
		collection = dbPrpLregist.findByQueryConditions(conditions,pageNo,rowsPerPage);
		int count = dbPrpLregist.getCount1(SqlUtils.getWherePartForGetCount(conditions));
		int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
		if(maxQueryCount!=0&&count>maxQueryCount){   
	      throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
	    }
		PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		return pageRecord;
  }
  // add by zhaolu 20060801 end
  

  /**
   * 根据相关规则查询该保单是否有符合条件的报案号
   * @param registDto：自定义报案对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public Collection findForPrpLclaimConditions(DBManager dbManager,String strPolicyNo)
    throws SQLException,Exception{
	  DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
      Collection collection = new ArrayList();
      String strSql =  strPolicyNo;
      collection = dbPrpLregist.findByQueryConditionsForPolicyno(strSql,0,0);
      return collection;
  }
}

  

