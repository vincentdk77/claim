package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleNew;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔节点状态数据库管理对象
 * <p>Title: 车险理赔理赔节点状态数据管理</p>
 * <p>Description: 车险理赔理赔节点状态数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBScheduleNew
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBScheduleNew()
  {
  }

  /**
   * 理赔节点状态保存方法
   *@param scheduleNewDto 理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
    if (scheduleNewDto.getPrpLscheduleNewDto() ==null)
    {
             throw new Exception();
    }

    //首先删除原来的相关数据
   deleteSubInfo(dbManager,scheduleNewDto);
    new DBPrpLscheduleNew(dbManager).insert(scheduleNewDto.getPrpLscheduleNewDto());
  }

  /**
   * 理赔节点状态删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
    if(scheduleNewDto.getPrpLscheduleNewDto() !=null)
   {
   	statement = "DELETE FROM prpLscheduleNew Where registNo='"
   	           +scheduleNewDto.getPrpLscheduleNewDto().getRegistNo()
   	           +"' and surveyNo="+scheduleNewDto.getPrpLscheduleNewDto().getSurveyNo();
     //String condition3 = " BusinessNo='" + StringUtils.rightTrim(scheduleNewDto.getPrpLscheduleNewDto().getBusinessNo()) + "' "
     //                  + " AND NodeType ='"+StringUtils.rightTrim(scheduleNewDto.getPrpLscheduleNewDto().getNodeType())+"' ";
    //statement = " DELETE FROM prpLscheduleNew Where " + condition3;

    dbManager.executeUpdate(statement);
    }
  }

  /**
   * 状态删除
   * @param fcoScheduleNewNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
{
       //示例未完成
         String statement = "";

    String condition = " BusinessNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成
    //statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * 状态删除
   * @param fcoScheduleNewNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
{
       //示例未完成
         String statement = "";

    String condition = " BusinessNo = '" + StringUtils.rightTrim(registNo) + "'"
                       + " AND NodeType ="+surveyNo+" ";
    //示例未完成
    statement =  " DELETE FROM prpLScheduleNew Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * 理赔节点状态查询方法
   *@param scheduleNewDto 理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ScheduleNewDto findByPrimaryKey(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
  {
     String conditions = " BusinessNo = '"+registNo+"'";
     ScheduleNewDto scheduleNewDto = new ScheduleNewDto();
     scheduleNewDto.setPrpLscheduleNewDto(new DBPrpLscheduleNew(dbManager).findByPrimaryKey(registNo,surveyNo));

     return scheduleNewDto;
  }
}
