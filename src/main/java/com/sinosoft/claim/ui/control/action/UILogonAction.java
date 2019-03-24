package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.ui.model.AgentIsExistCommand;
import com.sinosoft.claim.ui.model.LogonCheckUserCommand;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * UI��¼�߼�
 * <p>Title: claim</p>
 * <p>Description: ����ϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ��
 * @version 1.0
 */
public class UILogonAction
{
  /**
   * ����û�
   * @param usercode���û�����
   * @param password���û����루���ģ�
   * @return ��Ч/��Ч
   * @throws SQLException
   * @throws Exception
   */
  public PrpDuserDto checkUser(String usercode,String password) throws SQLException,Exception
  {
        AppConfig appConfig = new AppConfig();
  	LogonCheckUserCommand logonCheckUserCommand = new LogonCheckUserCommand(usercode,password);
  	PrpDuserDto prpDuserDto = (PrpDuserDto)logonCheckUserCommand.execute();
  	
  	return prpDuserDto;
  }
  
  /**
   * �޸��û�����
   * @param userDto �û�Dto
   * @throws Exception
   * @throws SQLException
   * */
  public void updatePwd(PrpDuserDto prpDuserDto) throws SQLException, Exception {
  	LogonCheckUserCommand logonCheckUserCommand = new LogonCheckUserCommand();
  	logonCheckUserCommand.updatePwd(prpDuserDto);
  }
  
  /**
   * �жϹ����������Ƿ�������ȷ
   * @param ����:������
   * @param ����
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String agentid,String password) throws SQLException,Exception
  {
  	AgentIsExistCommand agentIsExistCommand = new AgentIsExistCommand(agentid,password);
  	return ((Boolean)agentIsExistCommand.execute()).booleanValue();
  }
  
}
