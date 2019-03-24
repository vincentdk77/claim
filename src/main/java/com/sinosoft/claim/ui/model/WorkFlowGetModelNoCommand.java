package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowGetModelNoCommand extends BaseCommand{
   private String riskCode="";
   private String comCode="";
    /**
     *  ���췽��,����һ��WorkFlowGetCountCommand����
     * @param conditions ����conditions
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
