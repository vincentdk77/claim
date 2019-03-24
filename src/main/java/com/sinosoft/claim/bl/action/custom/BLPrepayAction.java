package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBPrepay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 预赔action
 * <p>Title: 车险理赔 预赔acton</p>
 * <p>Description: 车险理赔 预赔acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLPrepayAction
{
  public BLPrepayAction()
  {
  }

  /**
   * 保存预赔
   * @param prepayDto：自定义预赔对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,PrepayDto prepayDto)
    throws SQLException,Exception
  {
      DBPrepay dbPrepay = null;
      //业务操作
      dbPrepay = new DBPrepay();
      //if (this.isExist(prepayDto.getPrpLprepayDto().getPrpLprepayPrepayNo()))
      //{
        //dbPrepay.delete(prepayDto.getPrpLprepayDto().getPrpLprepayPrepayNo());
      //}
      dbPrepay.insert(dbManager,prepayDto);

  }

  /**
   * 删除预赔
   * @param  prepayNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBPrepay().delete(dbManager,prepayNo);
  }

  /**
   * 获得预赔
   * @param  prepayNo
   * @param dbManager  数据连接
   * @return 自定义预赔对象
   * @throws SQLException
   * @throws Exception
   */
  public PrepayDto findByPrimaryKey(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
    PrepayDto prepayDto = null;
    prepayDto = new DBPrepay().findByPrimaryKey(dbManager,prepayNo);
    return prepayDto;
  }
  /**
   * 判断预赔通知号是否存在
   * @param prepayNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String prepayNo)throws SQLException,Exception
  {
     if (new DBPrepay().findByPrimaryKey(dbManager,prepayNo) == null)
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
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLprepay.findByQueryConditions(conditions,pageNo,rowsPerPage);
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
  public Collection findByApproveQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLprepay.findByApproveQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * 保存预赔
   * @param prepayDto：自定义预赔对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void approve(DBManager dbManager,String prepayNo,String userCode,String underWriteFlag)
    throws SQLException,Exception
  {
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    dbPrpLprepay.approve(prepayNo,userCode,underWriteFlag);
  }
}
