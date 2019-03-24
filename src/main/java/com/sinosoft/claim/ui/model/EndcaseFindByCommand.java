package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndcaseFindByCommand extends BaseCommand
{
    private String claimNo;

    public EndcaseFindByCommand(String claimNo)  throws Exception
    {
        this.claimNo = claimNo;
    }
    public Object executeCommand() throws Exception
    {
        BLEndcaseFacade bLEndcaseFacade = new BLEndcaseFacade();
        return bLEndcaseFacade.findByPrimaryKey(claimNo); 
    }
}
