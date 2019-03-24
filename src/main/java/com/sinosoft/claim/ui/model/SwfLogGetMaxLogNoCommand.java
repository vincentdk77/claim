package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogGetMaxLogNoCommand extends BaseCommand{
    private String flowID="";
    /**
     *  ���췽��,����һ��SwfLogGetMaxLogNoCommand����
     * @param flowID ����flowID
     * @throws Exception
     */
    public SwfLogGetMaxLogNoCommand(String flowID) throws Exception {
    		this.flowID= flowID;

    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        return  new Integer(blSwfLogFacade.getMaxLogNo(flowID));
    }
}
