package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLReCaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class RecaseGetMaxSerialNoCommand extends BaseCommand{
    private String claimNo="";
    /**
     *  ���췽��,����һ��SwfLogGetMaxLogNoCommand����
     * @param flowID ����flowID
     * @throws Exception
     */
    public RecaseGetMaxSerialNoCommand(String claimNo) throws Exception {
    		this.claimNo=claimNo;

    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLReCaseFacade blReCaseFacade = new BLReCaseFacade();
        return  new Integer(blReCaseFacade.getMaxSerialNo(claimNo));
    }
}