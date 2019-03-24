package com.sinosoft.claim.ui.control.action;


//import com.sinosoft.function.workflow.ejb.client.SharkFactory;
//import com.sinosoft.function.workflow.ejb.shark.SharkClientInterface;
import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.ui.model.ScheduleObjectFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.ScheduleObjectSaveCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**   
 * �����������߼�
 * <p>Title: ��������</p>
 * <p>Description: �������⹤�����ӿڳ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Object: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class UIScheduleObjectAction
{
  /**
   * ������ⰸ�����ȴ�����Ϣ
   * @param  ScheduleNo�����ⰸ�����ȴ����
   * @return ���ⰸ�����ȴ���
   * @throws Exception
   */
  public ScheduleObjectDto findByPrimaryKey(String comCode) throws SQLException,UserException,Exception
  {
          ScheduleObjectFindByPrimaryKeyCommand scheduleObjectFindByPrimaryKeyCommand = new ScheduleObjectFindByPrimaryKeyCommand(comCode);
          ScheduleObjectDto scheduleObjectDto = (ScheduleObjectDto)scheduleObjectFindByPrimaryKeyCommand.execute();

    if (scheduleObjectDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+comCode+")");
    }
    return scheduleObjectDto;
  }
  
  
   /**
   * �������ⰸ�����ȴ���
   * @param ScheduleDto�����ⰸ�����ȴ���DTO
   * @throws Exception
   */
  public void save(ScheduleObjectDto scheduleObjectDto) throws SQLException,Exception
  {
          ScheduleObjectSaveCommand scheduleObjectSaveCommand = new ScheduleObjectSaveCommand(scheduleObjectDto);
          scheduleObjectSaveCommand.execute();
  }
}
