package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertifyIsExistCommand extends BaseCommand
{
    private String certifyNo;

    public CertifyIsExistCommand(String certifyNo)  throws Exception
    {
       this.certifyNo = certifyNo;
    }
    public Object executeCommand() throws Exception
    {
       BLCertifyFacade bLCertifyFacade = new BLCertifyFacade();
       return new Boolean(bLCertifyFacade.isExist(certifyNo));
    }
}
