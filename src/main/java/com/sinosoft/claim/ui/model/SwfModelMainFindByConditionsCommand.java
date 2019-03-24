package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelMainFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfModelMainFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelMainFindByConditionsCommand extends BaseCommand{
    private String conditions = "";
    /**
     *  构造方法,构造一个SwfModelMainFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public SwfModelMainFindByConditionsCommand(String conditions) throws Exception {
       this.conditions = conditions;
    }
    /**
     *  构造方法,构造一个SwfModelMainFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    /*
    public SwfModelMainFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }*/
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfModelMainFacade blSwfModelMainFacade = new BLSwfModelMainFacade();
        return blSwfModelMainFacade.findByConditions(this.conditions) ;
    }
}
