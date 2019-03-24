package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLED_AGENT_INFOFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class AgentIsExistCommand extends BaseCommand
{
	private String agentid;
	private String password;

	public AgentIsExistCommand(String agentid,String password)  throws Exception
	{
		this.agentid = agentid;
		this.password = password;
	}
	public Object executeCommand() throws Exception
	{
		BLED_AGENT_INFOFacade blED_AGENT_INFOFacade = new BLED_AGENT_INFOFacade();
		return new Boolean(blED_AGENT_INFOFacade.isExist(agentid,password));
	}

}
