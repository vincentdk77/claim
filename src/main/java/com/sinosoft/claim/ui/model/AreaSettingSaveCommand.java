package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLAreaSettingFacade;
//import com.sinosoft.claim.bl.facade.BLJobManagerFacade;
import com.sinosoft.claim.dto.custom.AreaSettingDto;
//import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class AreaSettingSaveCommand extends BaseCommand{
	private AreaSettingDto areaSettingDto = null;

	public AreaSettingSaveCommand(AreaSettingDto areaSettingDto) throws Exception {
		this.areaSettingDto = areaSettingDto;
		// TODO Auto-generated constructor stub
	}

	public Object executeCommand() throws Exception {
		// TODO Auto-generated method stub
		BLAreaSettingFacade blAreaSettingFacade = new BLAreaSettingFacade();
		blAreaSettingFacade.save(areaSettingDto);
		return null;
	}

}
