package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfConditionFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfConditionFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionFindByConditionsCommand extends BaseCommand{
    private String conditions ;
    /**
     *  ���췽��,����һ��SwfConditionFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public SwfConditionFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ���췽��,����һ��SwfConditionFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfConditionFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfConditionFacade blSwfConditionFacade = new BLSwfConditionFacade();
        return blSwfConditionFacade.findByConditions(this.conditions) ;
    }
}
