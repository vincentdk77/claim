package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertainLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 定损action
 * <p>Title: 车险理赔 定损acton</p>
 * <p>Description: 车险理赔 定损acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertainLossAction
{
  public BLCertainLossAction()
  {
  }

  /**
   * 保存定损
   * @param certainLossDto：自定义定损对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CertainLossDto certainLossDto)
    throws SQLException,Exception
  {
      DBCertainLoss dbCertainLoss = null;
      //业务操作
      dbCertainLoss = new DBCertainLoss();
      dbCertainLoss.insert(dbManager,certainLossDto);
  }

  /**
   * 删除定损
   * @param  registNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBCertainLoss().delete(dbManager,registNo);
  }

  /**
   * 获得定损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode)
    throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    certainLossDto = new DBCertainLoss().findByPrimaryKey(dbManager,registNo,lossItemCode);
    return certainLossDto;
  }

  /**
   * 判断报案号是否存在
   * @param registNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String registNo,String lossItemCode)throws SQLException,Exception
  {
           if (new DBCertainLoss().findByPrimaryKey(dbManager,registNo,lossItemCode) == null)
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
    DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcertainLoss.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * 获得定损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义定损对象
   * @throws SQLException
   * @throws Exception
   */

  public CertainLossDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    certainLossDto = new DBCertainLoss().findByPrimaryKey(dbManager,registNo);
    return certainLossDto;
  }
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
	    Collection collection = new ArrayList();
	    
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    //add by zhaolu 20060729 start
	    int count = dbPrpLcertainLoss.getCount1(SqlUtils.getWherePartForGetCount(conditions));
	    int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    if(maxQueryCount!=0&&count>maxQueryCount){   
	      throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
	    }
	    
	    collection = dbPrpLcertainLoss.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    //add by zhaolu 20060729 end
	    
	    
	    return pageRecord;
	  }
  //add by zhaolu 20060803 end

}
