package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleNew;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔新案件提示action
 * <p>Title: 车险理赔 理赔新案件提示acton</p>
 * <p>Description: 车险理赔 理赔新案件提示acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleNewAction
{
  public BLScheduleNewAction()
  {
  }

  /**
   * 保存理赔新案件提示
   * @param scheduleNewDto：自定义理赔新案件提示对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
      DBScheduleNew dbScheduleNew = null;
      //业务操作
      dbScheduleNew = new DBScheduleNew();
      //if (this.isExist(scheduleNewDto.getPrpLscheduleNewDto().getPrpLscheduleNewRegistNo()))
      //{
        //dbScheduleNew.delete(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo());
      //}
      dbScheduleNew.insert(dbManager,scheduleNewDto);

  }

  /**
   * 删除理赔新案件提示
   * @param  scheduleNewNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBScheduleNew().delete(dbManager,registNo,surveyNo);
  }

  /**
   * 获得理赔新案件提示
   * @param  scheduleNewNo
   * @param dbManager  数据连接
   * @return 自定义理赔新案件提示对象
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleNewDto findByPrimaryKey(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
  {
    ScheduleNewDto scheduleNewDto = null;
    scheduleNewDto = new DBScheduleNew().findByPrimaryKey(dbManager,registNo,surveyNo);
    return scheduleNewDto;
  }
  /**
   * 判断理赔新案件提示号是否存在
   * @param scheduleNewNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String registNo,int surveyNo)throws SQLException,Exception
  {
     if (new DBScheduleNew().findByPrimaryKey(dbManager,registNo,surveyNo) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }

}
