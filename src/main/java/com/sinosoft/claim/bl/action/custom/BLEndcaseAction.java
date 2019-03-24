package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBEndcase;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcaseNo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 结案action
 * <p>Title: 车险理赔 结案acton</p>
 * <p>Description: 车险理赔 结案acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLEndcaseAction
{
  public BLEndcaseAction()
  {
  }

  /**
   * 保存结案
   * @param endcaseDto：自定义结案对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,EndcaseDto endcaseDto)
    throws SQLException,Exception
  {
      DBEndcase dbEndcase = null;
      //业务操作
      dbEndcase = new DBEndcase();
      dbEndcase.insert(dbManager,endcaseDto);
  }

  /**
   * 删除结案
   * @param  caseNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String caseNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBEndcase().delete(dbManager,caseNo);
  }

  /**
   * 获得结案
   * @param  caseNo
   * @param dbManager  数据连接
   * @return 自定义结案对象
   * @throws SQLException
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(DBManager dbManager,String caseNo,String claimNo,String certiNo,String certiType)
    throws SQLException,Exception
  {
    EndcaseDto endcaseDto = null;
    endcaseDto = new DBEndcase().findByPrimaryKey(dbManager,caseNo,claimNo,certiNo,certiType);
    return endcaseDto;
  }
  /**
   * 获得结案
   * @param dbManager  数据连接
   * @return 自定义结案对象
   * @throws SQLException
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
    EndcaseDto endcaseDto = null;
    endcaseDto = new DBEndcase().findByPrimaryKey(dbManager,claimNo);
    return endcaseDto;
  }
  /**
   * 判断结案号是否存在
   * @param caseNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String caseNo,String claimNo,String certiNo,String certiType) throws SQLException,Exception
  {
    if (new DBEndcase().findByPrimaryKey(dbManager,caseNo,claimNo,certiNo,certiType) == null)
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
    DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcaseNo.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
}

}
