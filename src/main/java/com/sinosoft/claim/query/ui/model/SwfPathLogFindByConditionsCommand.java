package com.sinosoft.claim.query.ui.model;

import com.sinosoft.claim.query.bl.facade.BLSwfPathLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfPathLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.418<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogFindByConditionsCommand extends BaseCommand{
   private String conditions;

    /**
     *  ���췽��,����һ��SwfPathLogFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfPathLogFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLSwfPathLogFacade bLSwfPathLogFacade = new BLSwfPathLogFacade();
      return bLSwfPathLogFacade.findByConditions(this.conditions);
    }
}
