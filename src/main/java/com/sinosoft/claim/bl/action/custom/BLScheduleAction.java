package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBSchedule;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.reference.DBManager;
//import com.sinosoft.claim.resource.dtofactory.domain.DBSM_Send_SM_List; 
/**
 * 理赔案件调度处理action
 * <p>Title: 车险理赔 理赔案件调度处理acton</p>
 * <p>Description: 车险理赔 理赔案件调度处理acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleAction
{
  public BLScheduleAction()
  {
  }

  /**
   * 保存理赔案件调度处理
   * @param scheduleDto：自定义理赔案件调度处理对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
      DBSchedule dbSchedule = null;
      //业务操作
      dbSchedule = new DBSchedule();
      
      //判断是哪种类别的保存的情况
      String saveType ="";
      saveType = scheduleDto.getPrpLscheduleMainWFDto().getSaveType();

      if (saveType.equals("GETBACKEDIT"))
      {
      	dbSchedule.getBackUpdate(dbManager,scheduleDto);
      }
      else
      {
      if (saveType.equals("cancel"))
      {
      }
      else
      {
      dbSchedule.insert(dbManager,scheduleDto);
      }
      }

  }
  
  //发送短信
  public void saveSmcInfo(DBManager dbManager,ScheduleDto scheduleDto)
  throws SQLException,Exception
  {
    
    if(scheduleDto.getSmSendSMListDtoList()!=null){
       // new DBSM_Send_SM_List(dbManager).insertAll(scheduleDto.getSmSendSMListDtoList());
     }

  }


 /**
   * 保存理赔案件调度改派处理
   * @param scheduleDto：自定义理赔案件调度处理对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void changeSave(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
      DBSchedule dbSchedule = null;
      //业务操作
      dbSchedule = new DBSchedule();
     	dbSchedule.getBackUpdate(dbManager,scheduleDto);
    
  }

  /**
   * 删除理赔案件调度处理
   * @param  scheduleNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBSchedule().delete(dbManager,scheduleID,registNo);
  }

  /**
   * 获得理赔案件调度处理
   * @param  scheduleNo
   * @param dbManager  数据连接
   * @return 自定义理赔案件调度处理对象
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
  {
    ScheduleDto scheduleDto = null;
    scheduleDto = new DBSchedule().findByPrimaryKey(dbManager,scheduleID,registNo);
    return scheduleDto;
  }
  /**
   * 判断理赔案件调度处理号是否存在
   * @param scheduleNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,int scheduleID,String registNo)throws SQLException,Exception
  {
     if (new DBSchedule().findByPrimaryKey(dbManager,scheduleID,registNo) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }


  /**
   * 取调度号
   * @param registNo
   * @param dbManager  数据连接
   * @return ScheduleID
   * @throws SQLException
   * @throws Exception
   */
  public int getNo(DBManager dbManager,String registNo)throws SQLException,Exception
  {
    DBSchedule dbSchedule= new DBSchedule();
    int scheduleID=-1;
    scheduleID= dbSchedule.getNo(dbManager,registNo) ;
     return scheduleID;
  }

  /**
   * 调度将案件提交双代节点,申请双代处理品 add by liyanjie 2005-12-08 
   * @param scheduleDto：自定义理赔案件调度处理对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void applyCommiCase(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
     //   更新Prplregist表案件双代标志字段
     String condition = " CommiFlag='1' Where RegistNo ='" + scheduleDto.getPrpLscheduleMainWFDto().getRegistNo() + "'";
     DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
     dbPrpLregist.updateByCondition(condition);
     //   更新Prplclaimstatus表的案件状态
     DBSchedule dbSchedule = new DBSchedule();
     dbSchedule.updateClaimStatus(dbManager,scheduleDto);
  }

  
}
