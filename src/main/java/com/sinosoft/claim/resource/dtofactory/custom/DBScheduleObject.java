package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleObject;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������������ݿ�������
 * <p>Title: ������������������������ݹ���</p>
 * <p>Description: ������������������������ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBScheduleObject
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBScheduleObject()
  {
  }


  /**
   * ��������������淽��
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,ScheduleObjectDto scheduleObjectDto)
    throws SQLException,Exception
  {
    if (scheduleObjectDto.getPrpdcompanyDto() ==null)
    {
             throw new Exception();
    }

    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,scheduleObjectDto);
 
    if (scheduleObjectDto.getPrpdcompanyDto()!=null)
    {
      
    	//modify by lixiang start 2005-11-11
    	//reason:��������ݣ����Ǹ��£����û���ݣ����ǲ���
    	int count =new DBPrpDcompany(dbManager).getCount(" comcode='"+scheduleObjectDto.getPrpdcompanyDto().getComCode() +"'");
    	
    	if (count<1){
    	  new DBPrpDcompany(dbManager).insert(scheduleObjectDto.getPrpdcompanyDto ()) ;
        
    	} else{
    	  new DBPrpDcompany(dbManager).update (scheduleObjectDto.getPrpdcompanyDto ()) ;
            	
    	}
    	
    }
    
   
   
    if(scheduleObjectDto.getPrpLscheduleObjectDto()!=null)
    {
       new DBPrpLscheduleObject(dbManager).insert(scheduleObjectDto.getPrpLscheduleObjectDto());
    }
   }

  /**
   * �������������ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleObjectDto scheduleObjectDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
	   String statement = "";
	   if(scheduleObjectDto.getPrpdcompanyDto() !=null)
   {
    
    	String condition3 = " comcode='" + StringUtils.rightTrim(scheduleObjectDto.getPrpdcompanyDto().getComCode() ) + "' ";
     String condition1 = " scheduleobjectid='" + StringUtils.rightTrim(scheduleObjectDto.getPrpdcompanyDto().getComCode() ) + "' ";
     
     statement = " DELETE FROM prpLscheduleObject Where " + condition1;
     dbManager.executeUpdate(statement);
    //ɾ����չ��Ϣ
    // statement = " DELETE FROM prpdcompany Where " + condition3;
   //  dbManager.executeUpdate(statement);
    
    }
  
  }
  /*
   * ��������������ѯ����
   *@param scheduleDto ����������������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public ScheduleObjectDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
    
     ScheduleObjectDto scheduleObjectDto = new ScheduleObjectDto();
     scheduleObjectDto.setPrpLscheduleObjectDto(new DBPrpLscheduleObject(dbManager).findByPrimaryKey(comCode));
     scheduleObjectDto.setPrpdcompanyDto (new DBPrpDcompany(dbManager).findByPrimaryKey(comCode));
     return scheduleObjectDto; 
  }

}
