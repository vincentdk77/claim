package com.sinosoft.claim.query.ui.model;

import com.sinosoft.claim.query.bl.facade.BLSwfPathLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfPathLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.418<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogFindByConditionsCommand extends BaseCommand{
   private String conditions;

    /**
     *  构造方法,构造一个SwfPathLogFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfPathLogFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLSwfPathLogFacade bLSwfPathLogFacade = new BLSwfPathLogFacade();
      return bLSwfPathLogFacade.findByConditions(this.conditions);
    }
}
