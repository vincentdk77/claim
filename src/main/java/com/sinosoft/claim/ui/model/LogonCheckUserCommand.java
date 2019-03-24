package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLLogonFacade;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class LogonCheckUserCommand extends BaseCommand
{
	private String usercode;
	private String password;
	
	public LogonCheckUserCommand()throws Exception {
	}

	public LogonCheckUserCommand(String usercode,String password) throws Exception
	{
		this.usercode = usercode;
		this.password= password;
	}
	public Object executeCommand() throws Exception
	{
		BLLogonFacade bLLogonFacade = new BLLogonFacade();
		PrpDuserDto prpDuserDto = bLLogonFacade.checkUser(usercode,password);
	  return prpDuserDto;
	}
   
	public void updatePwd(PrpDuserDto prpDuserDto) throws Exception {
		BLLogonFacade bLLogonFacade = new BLLogonFacade();
		bLLogonFacade.updatePwd(prpDuserDto);
	} 
}
