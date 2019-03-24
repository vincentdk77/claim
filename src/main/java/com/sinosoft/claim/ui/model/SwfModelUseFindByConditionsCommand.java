package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelUseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelUseFacade��UI Command��<br>
 * ������ 2004-08-10 10:49:39.367<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseFindByConditionsCommand extends BaseCommand{
    String conditions=" 1=1";
      /**
     *  ���췽��,����һ��SwfModelUseFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfModelUseFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    	
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        
        BLSwfModelUseFacade bLSwfModelUseFacade = new BLSwfModelUseFacade();
        return  bLSwfModelUseFacade.findByConditions(conditions); 
       
    }
}
