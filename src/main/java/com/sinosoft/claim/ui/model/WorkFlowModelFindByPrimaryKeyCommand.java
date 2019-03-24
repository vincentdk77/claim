package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWorkFlowModelFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowModelFindByPrimaryKeyCommand extends BaseCommand{
    int modelNo = 0 ;
    /**
     *  构造方法,构造一个WorkFlowModelFindByPrimaryKeyCommand对象
     * @param modelNo 参数modelNo
     * @param pathNo 参数pathNo
     * @param conditionNo 参数conditionNo
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public WorkFlowModelFindByPrimaryKeyCommand(int modelNo) throws Exception {
    		this.modelNo = modelNo;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLWorkFlowModelFacade blWorkFlowModelFacade = new BLWorkFlowModelFacade();
        return (Object)blWorkFlowModelFacade.findByPrimaryKey(this.modelNo ) ;
    }
}
