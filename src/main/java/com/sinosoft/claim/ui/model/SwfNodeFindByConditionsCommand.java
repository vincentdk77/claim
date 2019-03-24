package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfNodeFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeFindByConditionsCommand extends BaseCommand{
    private String conditions;
   /**
     *  ���췽��,����һ��SwfNodeFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfNodeFindByConditionsCommand(String conditions) throws Exception {
    	this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLSwfNodeFacade bLSwfNodeFacade = new BLSwfNodeFacade();
      return bLSwfNodeFacade.findByConditions(this.conditions);
      
    }
}
