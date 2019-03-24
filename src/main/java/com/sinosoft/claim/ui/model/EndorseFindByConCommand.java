package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndorseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndorseFindByConCommand extends BaseCommand
{
	private String endorseNo;

	public EndorseFindByConCommand(String endorseNo) throws Exception
	{
		this.endorseNo = endorseNo; 
	}
	public Object executeCommand() throws Exception
	{
    BLEndorseFacade blEndorseFacade = new BLEndorseFacade();
    return blEndorseFacade.findByPrimaryKey(endorseNo); 
	}

}
