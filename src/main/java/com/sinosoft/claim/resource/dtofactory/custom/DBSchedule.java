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
 * ����������������ݿ�������
 * <p>Title: ������������������������ݹ���</p>
 * <p>Description: ������������������������ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBSchedule
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBSchedule()
  {
  }


  /**
   * �������������ȡ���ķ���
   *@param scheduleDto �����������������ȡ���Ķ���
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void cancelSchedule(DBManager dbManager,ScheduleDto scheduleDto)
   throws SQLException,Exception
  {
  	 cancelInfo(dbManager,scheduleDto);
  	 updateScheduleNew(dbManager,scheduleDto,"0");
  }

  /**
   * �����������������ȡ�ز�����ķ���
   *@param scheduleDto �����������������ȡ�ز�����Ķ���
   * @throws SQLException
   * @throws Exception
   *@return ��
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
  
  	//���Ͷ��� begin
    if(scheduleDto.getSmcComCodeInfoDtoList()!=null){
    	//new DBSMCComCodeInfo(dbManager).insertAll(scheduleDto.getSmcComCodeInfoDtoList());
    }
    //���Ͷ��� end
  	 
  }

  /**
   * ��������������淽��
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
    if (scheduleDto.getPrpLscheduleMainWFDto() ==null)
    {
             throw new Exception();
    }

    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,scheduleDto);
   String scheduleType = scheduleDto.getPrpLscheduleMainWFDto().getSaveType();
   
   //ֻ�ж���û�в鿱������£���ʹ�õı��淽ʽ
   if (scheduleType.equals("schel") ){

    if (scheduleDto.getPrpLscheduleItemDtoList()!=null)
    {
      new DBPrpLscheduleItem(dbManager).insertAll(scheduleDto.getPrpLscheduleItemDtoList()) ;
    }
   }else{
    if(scheduleDto.getPrpLscheduleMainWFDto()!=null)
    {
    	//add by liyanjie 2005-12-17 start ˫������,���յص����״��ύ���ȱ���ʱ,��¼��ʱ��Ϊ˫���ύʱ��
    	
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
   //��չ��Ϣ 
   if(scheduleDto.getPrpLregistExtDtoList()!=null)
   {
      new DBPrpLregistExt(dbManager).insertAll(scheduleDto.getPrpLregistExtDtoList());
   }
   
   //���Ͷ��� begin
   
   if(scheduleDto.getSmcComCodeInfoDtoList()!=null){
    // new DBSMCComCodeInfo(dbManager).insertAll(scheduleDto.getSmcComCodeInfoDtoList());
   }
 //�ط���Ϣ
   if(scheduleDto.getPrplreturnvisitswflogDto() != null){
  	 new DBPrplreturnvisitswflog(dbManager).insert(scheduleDto.getPrplreturnvisitswflogDto());
   }
 
   //���Ͷ��� end
   
  //���нڵ�״̬�ĸı�

    updateClaimStatus(dbManager,scheduleDto);

    //�����°�����ʾ��İ���״̬�ı�

    //updateScheduleNew(dbManager,scheduleDto,"1");
  }

  /**
   * �������������ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
	   String statement = "";
	   String scheduleType = scheduleDto.getScheduleType();
    if(scheduleDto.getPrpLscheduleMainWFDto() !=null)
   {
    if (scheduleType.equals("sched")){
    }else
    {
      //remark by liyanjie2005-12-12,start��Ϊ������ǰɾ�������ٲ���,��Ϊ˫��������,��ͬ����������ɲ�ͬ�ĵ����ύ
      //String condition3 = " registNo='" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  ) + "' ";
      //statement = " DELETE FROM prpLscheduleItem Where " + condition3;
      //dbManager.executeUpdate(statement);
      //remark by liyanjie2005-12-12 end
    }

    //ɾ����չ��Ϣ
    String condition = " registNo = '" + StringUtils.rightTrim(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()) + "'";
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);
     //��ɾ��scheduleItem������

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
   * ״̬ɾ��
   * @param fcoScheduleNewNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
{
       //ʾ��δ���
         String statement = "";

    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //ʾ��δ���
    //statement =  " DELETE FROM prpLScheduleMaint Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * ״̬ɾ��
   * @param fcoScheduleMainticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
{
       //ʾ��δ���
         String statement = "";

    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'"
                       + " AND scheduleId ="+scheduleID+" ";
    //ʾ��δ���
    statement =  " DELETE FROM prpLScheduleMainWF Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * ��������������ѯ����
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public ScheduleDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
  {
     String conditions = " registNo= '"+registNo+"' AND scheduleID="+scheduleID ;
     String conditions2 = " registNo= '"+registNo+"' AND scheduleID="+scheduleID+" order by itemno desc";
     ScheduleDto scheduleDto = new ScheduleDto();
     scheduleDto.setPrpLscheduleMainWFDto(new DBPrpLscheduleMainWF(dbManager).findByPrimaryKey(scheduleID,registNo));
     //modify by liyanjie 2005-12-06 add start ��ȡ����˫����ʶ ��߻��ᰴ��ǰ���������˫����־�����ô˱�־λ
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
   * ���Ⱥ�ȡ�÷���
   *@param registNo ������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public int getNo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
       return new DBPrpLscheduleMainWF(dbManager).getNo(registNo);
  }


 /**
   * ������ȵĲ���״̬�ķ���
   *@param scheduleDto ���ȶ���
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void updateClaimStatus(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
{

 //ʾ��δ���
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
   * ������Ⱥ���°�����ʾ��״̬�ķ���
   *@param scheduleDto ���ȶ���
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void updateScheduleNew(DBManager dbManager,ScheduleDto scheduleDto,String scheduleFlag)
    throws SQLException,Exception
{

 //ʾ��δ���
   String statement = " Update prplscheduleNew set ScheduleFlag='"+scheduleFlag
                    + "' Where registNo='" +scheduleDto.getPrpLscheduleMainWFDto().getRegistNo()  +"' AND surveyNo="+ scheduleDto.getPrpLscheduleMainWFDto().getSurveyNo() ;
    dbManager.executeUpdate(statement);
   }

 /**
   * ����������������ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void cancelInfo(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
	   String statement = "";
    if(scheduleDto.getPrpLscheduleMainWFDto() !=null)
   {
     //��ɾ��scheduleItem������
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
