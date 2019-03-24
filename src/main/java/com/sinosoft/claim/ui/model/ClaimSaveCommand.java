package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimSaveCommand extends BaseCommand
{

  private Class[] paramTypes;
  private Object[] params;
  public ClaimSaveCommand(ClaimDto claimDto)  throws Exception
	{
		this.params = new Object[]{claimDto};
  		this.paramTypes = new Class[]{ClaimDto.class };
	}
 
	public ClaimSaveCommand(ClaimDto claimDto,WorkFlowDto workFlowDto)  throws Exception
	{

		this.params = new Object[]{claimDto,workFlowDto};
  		this.paramTypes = new Class[]{ClaimDto.class,WorkFlowDto.class };
	}

	public ClaimSaveCommand(ArrayList claimDtoList,ArrayList workFlowDtoList,String comCode,String userCode)  throws Exception
	{

		this.params = new Object[]{claimDtoList,workFlowDtoList,comCode, userCode};
  		this.paramTypes = new Class[]{ArrayList.class,ArrayList.class,String.class,String.class };
	}
	  /**
	   *  Ö´ÐÐ·½·¨
	   *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
	   */
	  public Object executeCommand() throws Exception{
	      Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLClaimFacade");
	      Object object = loaderClass.newInstance(); 
	      Method method = loaderClass.getMethod("save",paramTypes);
	      return method.invoke(object,params);
	  } 
}
