package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpDcompanyFacade的UI Command类<br>
 * 创建于 2004-08-25 16:51:31.105<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyFindByConditionsCommand extends BaseCommand{
    private String conditions = "" ;
    /**
     *  构造方法,构造一个PrpDcompanyFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public PrpDcompanyFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  构造方法,构造一个PrpDcompanyFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpDcompanyFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
        return blPrpDcompanyFacade.findByConditions(this.conditions) ;
    }
}
