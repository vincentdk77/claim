package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 查勘action
 * <p>Title: 车险理赔 查勘acton</p>
 * <p>Description: 车险理赔 查勘acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCheckAction
{
  public BLCheckAction()
  {
  }

  /**
   * 保存查勘
   * @param checkDto：自定义查勘对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CheckDto checkDto)
    throws SQLException,Exception
  {
      DBCheck dbCheck = null;
      //业务操作
      dbCheck = new DBCheck();
      /*
      if (this.isExist(dbManager,checkDto.getPrpLcheckDto().getCheckNo()))
      {
        dbCheck.delete(dbManager,checkDto.getPrpLcheckDto().getCheckNo());
      }
      */
      dbCheck.insert(dbManager,checkDto);
  }

  /**
   * 删除查勘
   * @param  checkNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String checkNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBCheck().delete(dbManager,checkNo);
  }

  /**
   * 获得查勘
   * @param  checkNo
   * @param dbManager  数据连接
   * @return 自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public CheckDto findByPrimaryKey(DBManager dbManager,String checkNo)
    throws SQLException,Exception
  {
    CheckDto checkDto = null;
    checkDto = new DBCheck().findByPrimaryKey(dbManager,checkNo);
    return checkDto;
  }

  /**
   * 判断查勘通知号是否存在
   * @param checkNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String checkNo)throws SQLException,Exception
  {   DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
       String conStr ="registNo='"+checkNo+"'";
       if (dbPrpLcheck.getCount(conStr)<1)
      {
        return false;
      }else
      {
        return true;
      }
  }

  /**
   * 获得需要查勘的调度过来的任务
   * @param conditons
   * @param dbManager  数据连接
   * @return 查询出来的scheduleDto的集合
   * @throws SQLException
   * @throws Exception
   */
  public Collection findNewScheduleTaskList(DBManager dbManager,String conditions)throws SQLException,Exception
  {
        return new DBCheck().findNewScheduleTaskList(dbManager,conditions);
  }

  /**
    * 保存查勘调度
    * @param scheduleDto：自定义查勘调度对象
    * @param dbManager  数据连接
    * @throws SQLException
    * @throws Exception
    */
   public void saveSchedule(DBManager dbManager,ScheduleDto scheduleDto)
     throws SQLException,Exception
   {
       DBCheck dbCheck = null;
       //业务操作
       dbCheck = new DBCheck();

       dbCheck.saveSchedule(dbManager,scheduleDto);
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
    DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcheck.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
}

  //modify by wangwei add start 2005-06-18
  //原因：用于查询意健险信息
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
  public Collection findByQueryConditionsAcci(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcheck.findByQueryConditionsAcci(conditions,pageNo,rowsPerPage);
    return collection;
    //modify by wamgwei add end 205-06-18
}
  //add by zhaolu 20060802 start
  public PageRecord findByConditionsAcci(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception
  {
	  DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
	  Collection collection = new ArrayList();
	  if(conditions.trim().length()==0){
			conditions = "1=1";
		}
	  collection = dbPrpLcheck.findByQueryConditionsAcci(conditions,pageNo,rowsPerPage);
	  int count = dbPrpLcheck.getCount2(SqlUtils.getWherePartForGetCount(conditions));
	  int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	  if(maxQueryCount!=0&&count>maxQueryCount){   
	  throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
	  }
	 
	  PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	  return pageRecord;
  }
   
  public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)throws Exception
  {
	  DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    collection = dbPrpLcheck.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    int count = dbPrpLcheck.getCount1(SqlUtils.getWherePartForGetCount(conditions));
	    int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
		if(maxQueryCount!=0&&count>maxQueryCount){   
		throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
		  }
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		return pageRecord;
  }
  //add by zhaolu 20060802 end
  
}
