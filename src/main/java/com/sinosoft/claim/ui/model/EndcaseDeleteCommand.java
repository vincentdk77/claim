package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndcaseDeleteCommand extends BaseCommand
{
    private String caseNo;

    public EndcaseDeleteCommand(String caseNo)  throws Exception
    {
        this.caseNo = caseNo;
    }
    public Object executeCommand() throws Exception
    {
        BLEndcaseFacade bLEndcaseFacade = new BLEndcaseFacade();
        bLEndcaseFacade.delete(caseNo);
        return null;
    }
}
