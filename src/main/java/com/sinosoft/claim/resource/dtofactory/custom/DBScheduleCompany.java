package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompanyMobile;
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
public class DBScheduleCompany
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBScheduleCompany()
  {
  }


  /**
   * ��������������淽��
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
    if (scheduleCompanyDto.getPrpLscheduleCompanyDto() ==null)
    {
             throw new Exception();
    }

    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,scheduleCompanyDto);
 
    if (scheduleCompanyDto.getPrpLschecduleCompanyMobileDtoList ()!=null)
    {
      new DBPrpLscheduleCompanyMobile(dbManager).insertAll(scheduleCompanyDto.getPrpLschecduleCompanyMobileDtoList ()) ;
    }
   
   
    if(scheduleCompanyDto.getPrpLscheduleCompanyDto()!=null)
    {
       new DBPrpLscheduleCompany(dbManager).insert(scheduleCompanyDto.getPrpLscheduleCompanyDto());
    }
   }

  /**
   * �������������ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
	   String statement = "";
	   if(scheduleCompanyDto.getPrpLscheduleCompanyDto() !=null)
   {
    
    	String condition3 = " comcode='" + StringUtils.rightTrim(scheduleCompanyDto.getPrpLscheduleCompanyDto().getComCode() ) + "' ";
     statement = " DELETE FROM prpLscheduleCompany Where " + condition3;
     dbManager.executeUpdate(statement);
    //ɾ����չ��Ϣ
     statement = " DELETE FROM prpLscheduleCompanyMobile Where " + condition3;
     dbManager.executeUpdate(statement);
    
    }
  
  }
  /*
   * ��������������ѯ����
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public ScheduleCompanyDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
     String conditions = " comcode= '"+comCode+"'";
     
     ScheduleCompanyDto scheduleCompanyDto = new ScheduleCompanyDto();
     scheduleCompanyDto.setPrpLscheduleCompanyDto(new DBPrpLscheduleCompany(dbManager).findByPrimaryKey(comCode));
     scheduleCompanyDto.setPrpLschecduleCompanyMobileDtoList (new DBPrpLscheduleCompanyMobile(dbManager).findByConditions(conditions ));
     return scheduleCompanyDto; 
  }

}
