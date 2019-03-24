package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleNew;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����°�����ʾaction
 * <p>Title: �������� �����°�����ʾacton</p>
 * <p>Description: �������� �����°�����ʾacton</p>
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
   * ���������°�����ʾ
   * @param scheduleNewDto���Զ��������°�����ʾ����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleNewDto scheduleNewDto)
    throws SQLException,Exception
  {
      DBScheduleNew dbScheduleNew = null;
      //ҵ�����
      dbScheduleNew = new DBScheduleNew();
      //if (this.isExist(scheduleNewDto.getPrpLscheduleNewDto().getPrpLscheduleNewRegistNo()))
      //{
        //dbScheduleNew.delete(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo());
      //}
      dbScheduleNew.insert(dbManager,scheduleNewDto);

  }

  /**
   * ɾ�������°�����ʾ
   * @param  scheduleNewNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,int surveyNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBScheduleNew().delete(dbManager,registNo,surveyNo);
  }

  /**
   * ��������°�����ʾ
   * @param  scheduleNewNo
   * @param dbManager  ��������
   * @return �Զ��������°�����ʾ����
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
   * �ж������°�����ʾ���Ƿ����
   * @param scheduleNewNo
   * @param dbManager  ��������
   * @return ��/��
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
