package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNotionFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNotionMaxLineNoCommand extends BaseCommand{
    private String flowID="";
    private int logNo=0;
    /**
     *  ���췽��,����һ��SwfLogGetMaxLogNoCommand����
     * @param flowID ����flowID
     * @throws Exception
     */
    public SwfNotionMaxLineNoCommand(String flowID,int logNo) throws Exception {
    		this.flowID= flowID;
        this.logNo= logNo;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfNotionFacade blSwfNotionFacade = new BLSwfNotionFacade();
        return  new Integer(blSwfNotionFacade.getMaxLineNo(flowID,logNo));
    }
}
