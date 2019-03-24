package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfNodeFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeFindByPrimaryKeyCommand extends BaseCommand{
    private int modelNo=0;
    private int nodeNo=0;
    /**
     *  构造方法,构造一个SwfNodeFindByPrimaryKeyCommand对象
     * @param modelNo 参数modelNo
     * @param nodeNo 参数nodeNo
     * @throws Exception
     */
    public SwfNodeFindByPrimaryKeyCommand(int modelNo ,int nodeNo) throws Exception {
    		this.modelNo= modelNo;
    		this.nodeNo = nodeNo;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
    
     BLSwfNodeFacade bLSwfNodeFacade = new BLSwfNodeFacade();
      return bLSwfNodeFacade.findByPrimaryKey(modelNo,nodeNo);
    }
}
