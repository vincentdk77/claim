package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWorkFlowFacade的UI Command类<br> 目前没有使用
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowDeleteByConditionsCommand extends BaseCommand{
    private String conditions="1=2 ";
    /**
     *  构造方法,构造一个WorkFlowDeleteByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public WorkFlowDeleteByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLWorkFlowFacade bLWorkFlowFacade = new BLWorkFlowFacade();
       //bLWorkFlowFacade.(conditions);
       return null;

    }
}
