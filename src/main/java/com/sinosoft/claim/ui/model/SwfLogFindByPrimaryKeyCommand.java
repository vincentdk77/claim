package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogFindByPrimaryKeyCommand extends BaseCommand{
    private String flowID="";
    private int logNo =0;
    /**
     *  构造方法,构造一个SwfLogFindByPrimaryKeyCommand对象
     * @param flowID 参数flowID
     * @param logNo 参数logNo
     * @throws Exception
     */
    public SwfLogFindByPrimaryKeyCommand(String flowID ,int logNo) throws Exception {
    		this.flowID = flowID;
    		this.logNo = logNo;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        return  blSwfLogFacade.findByPrimaryKey(flowID,logNo);
    }
    
    /**
     * 删除注销/拒赔任务（即为退回注销/拒赔任务）add 2005-11-24
     * @param flowID 流程号
     * @param logNo  序号
     * @throws Exception
     * */
    public void cancelBack() throws Exception {
        BLWorkFlowFacade blWorkFlowFacade = new BLWorkFlowFacade();
        blWorkFlowFacade.cancelBack(flowID, logNo);
        
    }
}
