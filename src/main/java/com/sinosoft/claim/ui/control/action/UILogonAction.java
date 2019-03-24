package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.ui.model.AgentIsExistCommand;
import com.sinosoft.claim.ui.model.LogonCheckUserCommand;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * UI登录逻辑
 * <p>Title: claim</p>
 * <p>Description: 理赔系统样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品组
 * @version 1.0
 */
public class UILogonAction
{
  /**
   * 检查用户
   * @param usercode：用户代码
   * @param password：用户密码（明文）
   * @return 有效/无效
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
   * 修改用户密码
   * @param userDto 用户Dto
   * @throws Exception
   * @throws SQLException
   * */
  public void updatePwd(PrpDuserDto prpDuserDto) throws SQLException, Exception {
  	LogonCheckUserCommand logonCheckUserCommand = new LogonCheckUserCommand();
  	logonCheckUserCommand.updatePwd(prpDuserDto);
  }
  
  /**
   * 判断工号与密码是否输入正确
   * @param 工号:报案号
   * @param 密码
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String agentid,String password) throws SQLException,Exception
  {
  	AgentIsExistCommand agentIsExistCommand = new AgentIsExistCommand(agentid,password);
  	return ((Boolean)agentIsExistCommand.execute()).booleanValue();
  }
  
}
