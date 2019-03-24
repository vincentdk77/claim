package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpDcompanyFacade��UI Command��<br>
 * ������ 2004-08-25 16:51:31.105<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyFindByConditionsCommand extends BaseCommand{
    private String conditions = "" ;
    /**
     *  ���췽��,����һ��PrpDcompanyFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public PrpDcompanyFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ���췽��,����һ��PrpDcompanyFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PrpDcompanyFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
        return blPrpDcompanyFacade.findByConditions(this.conditions) ;
    }
}
