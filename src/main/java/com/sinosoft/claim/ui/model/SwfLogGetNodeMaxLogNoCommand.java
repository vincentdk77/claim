package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogGetNodeMaxLogNoCommand extends BaseCommand{
    private String flowID="";
    private String nodeType="";
    private String businessNo="";
    /**
     *  ���췽��,����һ��SwfLogGetMaxLogNoCommand����
     * @param flowID ����flowID
     * @throws Exception
     */
    public SwfLogGetNodeMaxLogNoCommand(String flowID,String nodeType,String businessNo) throws Exception {
    		this.flowID= flowID;
    		this.nodeType= nodeType;
    		this.businessNo=businessNo;

    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        return  new Integer(blSwfLogFacade.getMaxNodeLogNo(flowID,nodeType,businessNo));
    }
}
