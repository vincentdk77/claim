package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNotionFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNotionMaxLineNoCommand extends BaseCommand{
    private String flowID="";
    private int logNo=0;
    /**
     *  构造方法,构造一个SwfLogGetMaxLogNoCommand对象
     * @param flowID 参数flowID
     * @throws Exception
     */
    public SwfNotionMaxLineNoCommand(String flowID,int logNo) throws Exception {
    		this.flowID= flowID;
        this.logNo= logNo;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfNotionFacade blSwfNotionFacade = new BLSwfNotionFacade();
        return  new Integer(blSwfNotionFacade.getMaxLineNo(flowID,logNo));
    }
}
