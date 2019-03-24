
package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * <p>Title: ScheduleAddCertainLossCommand</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2005</p>
 * @author ����������Ŀ�� wangli
 * @version 1.0
 * <br>
 */
public class ScheduleAddCertainLossCommand extends BaseCommand{
	
	  private CheckDto checkDto=null;
	  private WorkFlowDto workFlowDto=null;
	  
	  public ScheduleAddCertainLossCommand(CheckDto checkDto)  throws Exception
	  {
	     this.checkDto = checkDto;
	  }
	  public ScheduleAddCertainLossCommand(CheckDto checkDto,WorkFlowDto workFlowDto)  throws Exception
	  {
	     this.checkDto = checkDto;
	     this.workFlowDto = workFlowDto;
	  }
	  
	  public Object executeCommand() throws Exception
	  {
	  	BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
	  	bLPrpLthirdPartyFacade.save(checkDto,workFlowDto); 
	    return null;
	  }

}
