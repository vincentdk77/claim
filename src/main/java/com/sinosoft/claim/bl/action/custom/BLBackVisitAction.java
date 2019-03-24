package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBBackVisit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 回访action
 * <p>Title: 车险理赔 回访acton</p>
 * <p>Description: 车险理赔 回访acton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class BLBackVisitAction
{
  public BLBackVisitAction()
  {
  }

  /**
   * 保存回访
   * @param backVisitDto：自定义回访对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
  {
      DBBackVisit dbBackVisit = new DBBackVisit();
      dbBackVisit.insert(dbManager,backVisitDto);
  }

  /**
   * 删除回访对象
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
      new DBBackVisit().delete(dbManager,backVisitNo,registNo,backVisitType);
  }

  /**
   * 获得回访对象
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param  dbManager  数据连接
   * @return 自定义回访对象
   * @throws SQLException
   * @throws Exception
   */
  public BackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
    BackVisitDto backVisitDto = null;
    backVisitDto = new DBBackVisit().findByPrimaryKey(dbManager,backVisitNo,registNo,backVisitType);
    return backVisitDto;
  }

}
