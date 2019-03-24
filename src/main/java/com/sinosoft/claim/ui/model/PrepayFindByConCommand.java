package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrepayFindByConCommand extends BaseCommand
{
    private String prepayNo;

    public PrepayFindByConCommand(String prepayNo)  throws Exception
    {
        this.prepayNo = prepayNo;
    }
    public Object executeCommand() throws Exception
    {
        BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
        return bLPrepayFacade.findByPrimaryKey(prepayNo);
    }

}
