package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertifyFindByConCommand extends BaseCommand
{
    private String certifyNo;

    public CertifyFindByConCommand(String certifyNo)  throws Exception
    {
        this.certifyNo = certifyNo;
    }
    public Object executeCommand() throws Exception
    {
        BLCertifyFacade bLCertifyFacade = new BLCertifyFacade();
        return bLCertifyFacade.findByPrimaryKey(certifyNo);
    }
}
