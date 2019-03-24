package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpLmenuFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLMenuFuncFacade的UI Command类<br>
 * 创建于 2005-01-26 10:59:44.500<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class MenuFuncFindByConditionsCommand extends BaseCommand{
    private String conditions;


    public MenuFuncFindByConditionsCommand(String conditions)  throws Exception
    {
        this.conditions = conditions;    }
    public Object executeCommand() throws Exception
    {
        BLPrpLmenuFacade blPrpDmenuFacade = new BLPrpLmenuFacade();
        return blPrpDmenuFacade.findByConditions(conditions);
    }
}
