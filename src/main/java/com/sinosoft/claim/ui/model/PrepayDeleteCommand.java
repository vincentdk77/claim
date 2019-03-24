package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrepayDeleteCommand extends BaseCommand
{
    private String prepayNo;

    public PrepayDeleteCommand(String prepayNo)  throws Exception
    {
        this.prepayNo = prepayNo;
    }
    public Object executeCommand() throws Exception
    {
        BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
        bLPrepayFacade.delete(prepayNo);
        return null;
    }
}
