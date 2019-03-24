package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
//import com.sinosoft.claim.resource.dtofactory.domain.DBSMCComCodeInfo;
//import com.sinosoft.claim.resource.dtofactory.domain.DBSM_Send_SM_List; 
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔调度任务处理数据库管理对象
 * <p>Title: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Description: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBSchedule
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBSchedule()
  {
  }


  /**
   * 理赔调度任务处理取消的方法
   *@param scheduleDto 理赔调度任务处理任务取消的对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void cancelSchedule(DBManager dbManager,ScheduleDto scheduleDto)
   throws SQLException,Exception
  {
  	 cancelInfo(dbManager,scheduleDto);
  	 updateScheduleNew(dbManager,scheduleDto,"0");
  }

  /**
   * 理赔调度任务处理任务取回并保存的方法
   *@param scheduleDto 理赔调度任务处理任务取回并保存的对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void getBackUpdate(DBManager dbManager,ScheduleDto scheduleDto)
   throws SQLException,Exception
  {
  	 if (scheduleDto.getPrpLscheduleMainWFDto() !=null)
     {
     	 new DBPrpLscheduleMainWF(dbManager).delete(scheduleDto.getPrpLscheduleMainWFDto().getScheduleID(),scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  );
     	 new DBPrpLscheduleMainWF(dbManager).insert( scheduleDto.getPrpLscheduleMainWFDto() );
     
     }
  	 
  	if (scheduleDto.getPrpLscheduleItemDto () !=null)
    {
    	 new DBPrpLscheduleItem(dbManager).delete(scheduleDto.getPrpLscheduleItemDto().getScheduleID(),scheduleDto.getPrpLscheduleItemDto().getRegistNo() ,scheduleDto.getPrpLscheduleItemDto().getItemNo()  );
    	 new DBPrpLscheduleItem(dbManager).insert( scheduleDto.getPrpLscheduleItemDto() );
    
    }
  
  	//发送短信 begin
    if(scheduleDto.getSmcComCodeInfoDtoList()!=null){
    	//new DBSMCComCodeInfo(dbManager).insertAll(scheduleDto.getSmcComCodeInfoDtoList());
    }
    //发送短信 end
  	 
  }

  /**
   * 理赔调度任务处理保存方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
    if (scheduleDto.getPrpLscheduleMainWFDto() ==null)
    {
             throw new Exception();
    }

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,scheduleDto);
   String scheduleType = scheduleDto.getPrpLscheduleMainWFDto().getSaveType();
   
   //只有定损，没有查勘的情况下，所使用的保存方式
   if (scheduleType.equals("schel") ){

    if (scheduleDto.getPrpLscheduleItemDtoList()!=null)
    {
      new DBPrpLscheduleItem(dbManager).insertAll(scheduleDto.getPrpLscheduleItemDtoList()) ;
    }
   }else{
    if(scheduleDto.getPrpLscheduleMainWFDto()!=null)
    {
    	//add by liyanjie 2005-12-17 start 双代案件,出险地调度首次提交调度保存时,记录此时间为双代提交时间
    	
        if("1".equals(scheduleDto.getPrpLscheduleMainWFDto().getCommiFlag()))
        {
            String condition = " CommiTime='" + new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()+ "'"    
 				+ " Where RegistNo ='" + scheduleDto.getPrpLscheduleMainWFDto().getRegistNo() + "'"
 				+ " and (CommiTime is null or CommiTime ='') " ;
        	new DBPrpLregist(dbManager).updateByCondition(condition);
        }
        //add by liyanjie 2005-12-17 end
	    if (!scheduleDto.getPrpLscheduleMainWFDto().getScheduleType().equals("NOCK")){
	       new DBPrpLscheduleMainWF(dbManager).update(scheduleDto.getPrpLscheduleMainWFDto());
	    }
        
    }
    
    if (scheduleDto.getPrpLscheduleItemDtoList()!=null)
    {
      new DBPrpLscheduleItem(dbManager).insertAll(scheduleDto.getPrpLscheduleItemDtoList()) ;
    }
    }
   //扩展信息 
   if(scheduleDto.getPrpLregistExtDtoList()!=null)
   {
      new DBPrpLregistExt(dbManager).insertAll(scheduleDto.getPrpLregistExtDtoList());
   }
   
   //发送短信 begin
   
   if(scheduleDto.getSmcComCodeInfoDtoList()!=null){
    // new DBSMCComCodeInfo(dbManager).insertAll(scheduleDto.getSmcComCodeInfoDtoList());
   }
 //回访信息
   if(scheduleDto.getPrplreturnvisitswflogDto() != null){
  	 new DBPrplreturnvisitswflog(dbManager).insert(scheduleDto.getPrplreturnvisitswflogDto());
   }
 
   //发送短信 end
   
  //进行节点状态的改变

    updateClaimStatus(dbManager,scheduleDto);

    //进行新案件提示表的案件状态改变

    //updateScheduleNew(dbManager,scheduleDto,"1");
  }

  /**
   * 理赔调度任务处理删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
	   String scheduleType = scheduleDto.getScheduleType();
    if(scheduleDto.getPrpLscheduleMainWFDto() !=null)
   {
    if (scheduleType.equals("sched")){
    }else
    {
      //remark by liyanjie2005-12-12,start改为做插入前删除本条再插入,因为双代的问题,不同定损项可能由不同的调度提交
      //String condition3 = " registNo='" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  ) + "' ";
      //statement = " DELETE FROM prpLscheduleItem Where " + condition3;
      //dbManager.executeUpdate(statement);
      //remark by liyanjie2005-12-12 end
    }

    //删除扩展信息
    String condition = " registNo = '" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()) + "'";
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);
     //先删除scheduleItem的内容

/*
     String condition3 = " registNo='" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  ) + "' "
                       + " AND scheduleId ="+scheduleDto.getPrpLscheduleMainWFDto().getScheduleID() +" ";
     statement = " DELETE FROM prpLscheduleItem Where " + condition3;
     dbManager.executeUpdate(statement);

     statement = " DELETE FROM prpLcheckItem Where " + condition3;
     dbManager.executeUpdate(statement);

     statement = " DELETE FROM prpLscheduleMainWFWF Where " + condition3;
     dbManager.executeUpdate(statement);
  */

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

    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成
    //statement =  " DELETE FROM prpLScheduleMaint Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * 状态删除
   * @param fcoScheduleMainticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
{
       //示例未完成
         String statement = "";

    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'"
                       + " AND scheduleId ="+scheduleID+" ";
    //示例未完成
    statement =  " DELETE FROM prpLScheduleMainWF Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * 理赔调度任务处理查询方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ScheduleDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
  {
     String conditions = " registNo= '"+registNo+"' AND scheduleID="+scheduleID ;
     String conditions2 = " registNo= '"+registNo+"' AND scheduleID="+scheduleID+" order by itemno desc";
     ScheduleDto scheduleDto = new ScheduleDto();
     scheduleDto.setPrpLscheduleMainWFDto(new DBPrpLscheduleMainWF(dbManager).findByPrimaryKey(scheduleID,registNo));
     //modify by liyanjie 2005-12-06 add start 读取案件双代标识 后边还会按当前调度任务的双代标志重新置此标志位
     PrpLregistDto prpLregistDto = (PrpLregistDto)new DBPrpLregist(dbManager).findByPrimaryKey(registNo);
     //scheduleDto.getPrpLscheduleMainWFDto().setCommiFlag(prpLregistDto.getCommiFlag());
     //modify by liyanjie 2005-12-06 add end
     scheduleDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,"sched",scheduleID));
     scheduleDto.setPrpLscheduleItemDtoList((ArrayList)new DBPrpLscheduleItem(dbManager).findByConditions(conditions2));
     scheduleDto.setPrpLcheckItemDtoList((ArrayList)new DBPrpLcheckItem(dbManager).findByConditions(conditions));

     conditions = " registNo = '"+registNo+"'";
     scheduleDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
     return scheduleDto; 
  }


  /*
   * 调度号取得方法
   *@param registNo 报案号
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public int getNo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
       return new DBPrpLscheduleMainWF(dbManager).getNo(registNo);
  }


 /**
   * 变更调度的操作状态的方法
   *@param scheduleDto 调度对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
{

 //示例未完成
   String statement = "";


  if(scheduleDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(scheduleDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       +  " AND  SerialNo="+ scheduleDto.getPrpLclaimStatusDto().getSerialNo()
                       + " AND NodeType ='sched' ";

    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);

      new DBPrpLclaimStatus(dbManager).insert(scheduleDto.getPrpLclaimStatusDto() );
   }


}


/**
   * 变更调度后的新案件提示表状态的方法
   *@param scheduleDto 调度对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateScheduleNew(DBManager dbManager,ScheduleDto scheduleDto,String scheduleFlag)
    throws SQLException,Exception
{

 //示例未完成
   String statement = " Update prplscheduleNew set ScheduleFlag='"+scheduleFlag
                    + "' Where registNo='" +scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  +"' AND surveyNo="+ scheduleDto.getPrpLscheduleMainWFDto().getSurveyNo() ;
    dbManager.executeUpdate(statement);
   }

 /**
   * 理赔调度任务处理撤消子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void cancelInfo(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
    if(scheduleDto.getPrpLscheduleMainWFDto() !=null)
   {
     //先删除scheduleItem的内容
     String condition3 = " registNo='" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  ) + "' "
                       + " AND scheduleId ="+scheduleDto.getPrpLscheduleMainWFDto().getScheduleID() +" ";
     statement = " DELETE FROM prpLscheduleItem Where " + condition3;
     dbManager.executeUpdate(statement);

     statement = " DELETE FROM prpLcheckItem Where " + condition3;
     dbManager.executeUpdate(statement);

     statement = " DELETE FROM prpLscheduleMainWFWF Where " + condition3;
     dbManager.executeUpdate(statement);

     String condition4 = " BusinessNo='" + StringUtils.rightTrim(scheduleDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       +  " AND SerialNo ="+ scheduleDto.getPrpLclaimStatusDto().getSerialNo()
                       + " AND NodeType ='sched' ";

    statement = " DELETE FROM prpLclaimStatus Where " + condition4;

    dbManager.executeUpdate(statement);

     }
  }
 
  
}
