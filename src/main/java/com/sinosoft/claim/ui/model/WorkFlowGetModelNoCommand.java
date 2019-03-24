package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWorkFlowFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowGetModelNoCommand extends BaseCommand{
   private String riskCode="";
   private String comCode="";
    /**
     *  构造方法,构造一个WorkFlowGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public WorkFlowGetModelNoCommand(String riskCode,String comCode) throws Exception {
            this.riskCode = riskCode;
            this.comCode = comCode;
    }
    public Object executeCommand() throws Exception
    {
        BLWorkFlowFacade BLWorkFlowFacade = new BLWorkFlowFacade();
        return new Integer(BLWorkFlowFacade.getModelNo(riskCode,comCode));

    }

}
