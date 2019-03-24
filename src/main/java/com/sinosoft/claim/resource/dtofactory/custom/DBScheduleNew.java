package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleNew;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ڵ�״̬���ݿ�������
 * <p>Title: ������������ڵ�״̬���ݹ���</p>
 * <p>Description: ������������ڵ�״̬���ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBScheduleNew
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBScheduleNew()
  {
  }

  /**
   * ����ڵ�״̬���淽��
   *@param scheduleNewDto ����ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
    if (scheduleNewDto.getPrpLscheduleNewDto() ==null)
    {
             throw new Exception();
    }

    //����ɾ��ԭ�����������
   deleteSubInfo(dbManager,scheduleNewDto);
    new DBPrpLscheduleNew(dbManager).insert(scheduleNewDto.getPrpLscheduleNewDto());
  }

  /**
   * ����ڵ�״̬ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
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

    String condition = " BusinessNo = '" + StringUtils.rightTrim(registNo) + "'";
    //ʾ��δ���
    //statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * ״̬ɾ��
   * @param fcoScheduleNewNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
{
       //ʾ��δ���
         String statement = "";

    String condition = " BusinessNo = '" + StringUtils.rightTrim(registNo) + "'"
                       + " AND NodeType ="+surveyNo+" ";
    //ʾ��δ���
    statement =  " DELETE FROM prpLScheduleNew Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * ����ڵ�״̬��ѯ����
   *@param scheduleNewDto ����ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   *@return ��
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
