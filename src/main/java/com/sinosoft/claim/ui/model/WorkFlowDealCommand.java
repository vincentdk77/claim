package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWorkFlowFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowDealCommand extends BaseCommand{
    private WorkFlowDto workFlowDto=null;
    /**
     *  构造方法,构造一个WorkFlowGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public WorkFlowDealCommand(WorkFlowDto workFlowDto) throws Exception {
    		 this.workFlowDto = workFlowDto;
    	    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
       BLWorkFlowFacade bLWorkFlowFacade = new BLWorkFlowFacade();
       bLWorkFlowFacade.deal(workFlowDto); 
       return null;


    }
}
