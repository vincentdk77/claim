package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertifyDeleteCommand extends BaseCommand
{
    private String certifyNo;

    public CertifyDeleteCommand(String certifyNo)  throws Exception
    {
        this.certifyNo = certifyNo;
    }
    public Object executeCommand() throws Exception
    {
        BLCertifyFacade bLCertifyFacade = new BLCertifyFacade();
        bLCertifyFacade.delete(certifyNo);
        return null;
    }
}
