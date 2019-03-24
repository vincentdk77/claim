package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelMainFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelMainFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelMainFindByConditionsCommand extends BaseCommand{
    private String conditions = "";
    /**
     *  ���췽��,����һ��SwfModelMainFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public SwfModelMainFindByConditionsCommand(String conditions) throws Exception {
       this.conditions = conditions;
    }
    /**
     *  ���췽��,����һ��SwfModelMainFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    /*
    public SwfModelMainFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }*/
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfModelMainFacade blSwfModelMainFacade = new BLSwfModelMainFacade();
        return blSwfModelMainFacade.findByConditions(this.conditions) ;
    }
}
