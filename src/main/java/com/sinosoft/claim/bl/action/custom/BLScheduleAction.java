package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBSchedule;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.reference.DBManager;
//import com.sinosoft.claim.resource.dtofactory.domain.DBSM_Send_SM_List; 
/**
 * ���ⰸ�����ȴ���action
 * <p>Title: �������� ���ⰸ�����ȴ���acton</p>
 * <p>Description: �������� ���ⰸ�����ȴ���acton</p>
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
   * �������ⰸ�����ȴ���
   * @param scheduleDto���Զ������ⰸ�����ȴ������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
      DBSchedule dbSchedule = null;
      //ҵ�����
      dbSchedule = new DBSchedule();
      
      //�ж����������ı�������
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
  
  //���Ͷ���
  public void saveSmcInfo(DBManager dbManager,ScheduleDto scheduleDto)
  throws SQLException,Exception
  {
    
    if(scheduleDto.getSmSendSMListDtoList()!=null){
       // new DBSM_Send_SM_List(dbManager).insertAll(scheduleDto.getSmSendSMListDtoList());
     }

  }


 /**
   * �������ⰸ�����ȸ��ɴ���
   * @param scheduleDto���Զ������ⰸ�����ȴ������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void changeSave(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
      DBSchedule dbSchedule = null;
      //ҵ�����
      dbSchedule = new DBSchedule();
     	dbSchedule.getBackUpdate(dbManager,scheduleDto);
    
  }

  /**
   * ɾ�����ⰸ�����ȴ���
   * @param  scheduleNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int scheduleID,String registNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBSchedule().delete(dbManager,scheduleID,registNo);
  }

  /**
   * ������ⰸ�����ȴ���
   * @param  scheduleNo
   * @param dbManager  ��������
   * @return �Զ������ⰸ�����ȴ������
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
   * �ж����ⰸ�����ȴ�����Ƿ����
   * @param scheduleNo
   * @param dbManager  ��������
   * @return ��/��
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
   * ȡ���Ⱥ�
   * @param registNo
   * @param dbManager  ��������
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
   * ���Ƚ������ύ˫���ڵ�,����˫������Ʒ add by liyanjie 2005-12-08 
   * @param scheduleDto���Զ������ⰸ�����ȴ������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void applyCommiCase(DBManager dbManager,ScheduleDto scheduleDto)
    throws SQLException,Exception
  {
     //   ����Prplregist����˫����־�ֶ�
     String condition = " CommiFlag='1' Where RegistNo ='" + scheduleDto.getPrpLscheduleMainWFDto().getRegistNo() + "'";
     DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
     dbPrpLregist.updateByCondition(condition);
     //   ����Prplclaimstatus��İ���״̬
     DBSchedule dbSchedule = new DBSchedule();
     dbSchedule.updateClaimStatus(dbManager,scheduleDto);
  }

  
}
