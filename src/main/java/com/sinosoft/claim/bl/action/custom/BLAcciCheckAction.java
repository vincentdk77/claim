package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBAcciCheck;
import com.sinosoft.claim.resource.dtofactory.custom.DBRegist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
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
public class BLAcciCheckAction
{
  public BLAcciCheckAction()
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
  public AcciCheckDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
  	AcciCheckDto acciCheckDto = null;
  	acciCheckDto = new DBAcciCheck().findByPrimaryKey(dbManager,registNo);
    return acciCheckDto;
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

}
