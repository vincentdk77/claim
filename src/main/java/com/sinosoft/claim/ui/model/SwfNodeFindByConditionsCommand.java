package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfNodeFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeFindByConditionsCommand extends BaseCommand{
    private String conditions;
   /**
     *  构造方法,构造一个SwfNodeFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfNodeFindByConditionsCommand(String conditions) throws Exception {
    	this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLSwfNodeFacade bLSwfNodeFacade = new BLSwfNodeFacade();
      return bLSwfNodeFacade.findByConditions(this.conditions);
      
    }
}
