package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfConditionFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfConditionFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionFindByConditionsCommand extends BaseCommand{
    private String conditions ;
    /**
     *  构造方法,构造一个SwfConditionFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public SwfConditionFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  构造方法,构造一个SwfConditionFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfConditionFindByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfConditionFacade blSwfConditionFacade = new BLSwfConditionFacade();
        return blSwfConditionFacade.findByConditions(this.conditions) ;
    }
}
