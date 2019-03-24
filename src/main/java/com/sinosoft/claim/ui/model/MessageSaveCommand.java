package com.sinosoft.claim.ui.model;

import com.sinosoft.sysframework.web.model.BaseCommand;
import com.sinosoft.claim.bl.facade.BLPrpLmessageFacade;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;



public class MessageSaveCommand extends BaseCommand
{
    private PrpLmessageDto prpLmessageDto;

    public MessageSaveCommand(PrpLmessageDto prpLmessageDto)  throws Exception
    {
        this.prpLmessageDto = prpLmessageDto;
    }
    public Object executeCommand() throws Exception
    {
        BLPrpLmessageFacade bLPrpLmessageFacade = new BLPrpLmessageFacade();
        bLPrpLmessageFacade.save(prpLmessageDto);
        return null;
    }
}
