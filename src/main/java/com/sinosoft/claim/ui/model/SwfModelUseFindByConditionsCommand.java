package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelUseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfModelUseFacade的UI Command类<br>
 * 创建于 2004-08-10 10:49:39.367<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseFindByConditionsCommand extends BaseCommand{
    String conditions=" 1=1";
      /**
     *  构造方法,构造一个SwfModelUseFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfModelUseFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    	
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        
        BLSwfModelUseFacade bLSwfModelUseFacade = new BLSwfModelUseFacade();
        return  bLSwfModelUseFacade.findByConditions(conditions); 
       
    }
}
