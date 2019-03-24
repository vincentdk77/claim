package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyCombineFacade;
import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class CertifyCombineSaveCommand extends BaseCommand
{
  private CertifyDto certifyDto=null;
  private WorkFlowDto workFlowDto=null;
  
	public CertifyCombineSaveCommand(CertifyDto certifyDto)  throws Exception
	{
     this.certifyDto= certifyDto;
  
	}

	public CertifyCombineSaveCommand(CertifyDto certifyDto,WorkFlowDto workFlowDto)  throws Exception
	{
      this.certifyDto= certifyDto;
     this.workFlowDto = workFlowDto;
	}
	public Object executeCommand() throws Exception
	{
	BLCertifyCombineFacade bLCertifyCombineFacade = new BLCertifyCombineFacade();
	bLCertifyCombineFacade.save(certifyDto,workFlowDto); 
    return null;
	}
}
