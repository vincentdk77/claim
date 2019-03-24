package com.sinosoft.claim.ui.control.action;


//import com.sinosoft.function.workflow.ejb.client.SharkFactory;
//import com.sinosoft.function.workflow.ejb.shark.SharkClientInterface;
import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.ui.model.ScheduleCompanyFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.ScheduleCompanySaveCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**   
 * �����������߼�
 * <p>Title: ��������</p>
 * <p>Description: �������⹤�����ӿڳ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class UIScheduleCompanyAction
{
  /**
   * ������ⰸ�����ȴ�����Ϣ
   * @param  ScheduleNo�����ⰸ�����ȴ����
   * @return ���ⰸ�����ȴ���
   * @throws Exception
   */
  public ScheduleCompanyDto findByPrimaryKey(String comCode) throws SQLException,UserException,Exception
  {
          ScheduleCompanyFindByPrimaryKeyCommand scheduleCompanyFindByPrimaryKeyCommand = new ScheduleCompanyFindByPrimaryKeyCommand(comCode);
          ScheduleCompanyDto scheduleCompanyDto = (ScheduleCompanyDto)scheduleCompanyFindByPrimaryKeyCommand.execute();

    if (scheduleCompanyDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+comCode+")");
    }
    return scheduleCompanyDto;
  }
  
  
   /**
   * �������ⰸ�����ȴ���
   * @param ScheduleDto�����ⰸ�����ȴ���DTO
   * @throws Exception
   */
  public void save(ScheduleCompanyDto scheduleCompanyDto) throws SQLException,Exception
  {
          ScheduleCompanySaveCommand scheduleCompanySaveCommand = new ScheduleCompanySaveCommand(scheduleCompanyDto);
          scheduleCompanySaveCommand.execute();
  }
}
