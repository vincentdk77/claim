package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogGetNodeMaxLogNoCommand extends BaseCommand{
    private String flowID="";
    private String nodeType="";
    private String businessNo="";
    /**
     *  构造方法,构造一个SwfLogGetMaxLogNoCommand对象
     * @param flowID 参数flowID
     * @throws Exception
     */
    public SwfLogGetNodeMaxLogNoCommand(String flowID,String nodeType,String businessNo) throws Exception {
    		this.flowID= flowID;
    		this.nodeType= nodeType;
    		this.businessNo=businessNo;

    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        return  new Integer(blSwfLogFacade.getMaxNodeLogNo(flowID,nodeType,businessNo));
    }
}
