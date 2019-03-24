package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertify;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertifyCombine;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyCollect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 单证action
 * <p>Title: 车险理赔 单证acton</p>
 * <p>Description: 车险理赔 单证acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertifyCombineAction
{
  public BLCertifyCombineAction()
  {
  }

  /**
   * 保存单证
   * @param certifyDto：自定义单证对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CertifyDto certifyDto)
    throws SQLException,Exception
  {
	  DBCertifyCombine dBCertifyCombine = null;
      //业务操作
	  dBCertifyCombine = new DBCertifyCombine();
	  dBCertifyCombine.insert(dbManager,certifyDto);

  }

  /**
   * 删除单证
   * @param  certifyNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String certifyNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBCertify().delete(dbManager,certifyNo);
  }

  /**
   * 获得单证
   * @param  certifyNo
   * @param dbManager  数据连接
   * @return 自定义单证对象
   * @throws SQLException
   * @throws Exception
   */
  public CertifyDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CertifyDto certifyDto = null;
    certifyDto = new DBCertify().findByPrimaryKey(dbManager,registNo);
    return certifyDto;
  }
  /**
   * 判断单证通知号是否存在
   * @param certifyNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String certifyNo)throws SQLException,Exception
  {
     if (new DBCertify().findByPrimaryKey(dbManager,certifyNo) == null)
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
    DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcertifyCollect.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
    }
  
  //add by zhaolu 20060803 start
  public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
      collection = dbPrpLcertifyCollect.findByQueryConditions(conditions,pageNo,rowsPerPage);
      int count = dbPrpLcertifyCollect.getCount1(SqlUtils.getWherePartForGetCount(conditions));
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      if(maxQueryCount!=0&&count>maxQueryCount){   
        throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
      }
      
	  PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	  return pageRecord;
	 
	    }
  //add by zhaolu 20060803 end

}
