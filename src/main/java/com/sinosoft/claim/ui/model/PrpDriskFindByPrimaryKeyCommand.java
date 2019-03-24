package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpDriskFacade的UI Command类<br>
 * 创建于 2004-08-25 16:51:31.656<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskFindByPrimaryKeyCommand extends BaseCommand{
    private String riskCode = "" ;  //条件
    /**
     *  构造方法,构造一个PrpDriskFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public PrpDriskFindByPrimaryKeyCommand(String riskCode) throws Exception {
    		this.riskCode = riskCode;
    }
    /**
     *  构造方法,构造一个PrpDriskFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    /*
    public PrpDriskFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }*/
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{

        BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        return blPrpDriskFacade.findByPrimaryKey(this.riskCode) ;

      }
}
