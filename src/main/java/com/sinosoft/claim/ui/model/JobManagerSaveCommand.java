package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLJobManagerFacade;
import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class JobManagerSaveCommand extends BaseCommand{
	
	private JobManagerDto jobManagerDto = null;

	public JobManagerSaveCommand(JobManagerDto jobManagerDto) throws Exception {
		this.jobManagerDto = jobManagerDto;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object executeCommand() throws Exception {
		// TODO Auto-generated method stub
		BLJobManagerFacade blJobManagerFacade = new BLJobManagerFacade();
		blJobManagerFacade.save(jobManagerDto);
		return null;
	}

}
