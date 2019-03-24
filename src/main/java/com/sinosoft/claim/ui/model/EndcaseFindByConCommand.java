package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndcaseFindByConCommand extends BaseCommand
{
    private String caseNo;
    private String claimNo;
    private String certiNo;
    private String certiType;

    public EndcaseFindByConCommand(String caseNo,String claimNo,String certiNo,String certiType)  throws Exception
    {
        this.caseNo = caseNo;
        this.claimNo = claimNo;
        this.certiNo = certiNo;
        this.certiType = certiType;
    }
    public Object executeCommand() throws Exception
    {
        BLEndcaseFacade bLEndcaseFacade = new BLEndcaseFacade();
        return bLEndcaseFacade.findByPrimaryKey(caseNo,claimNo,certiNo,certiType);
    }
}
