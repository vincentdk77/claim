package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 这是PrpLdeductCond-计算书免赔条件表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondFacade extends BLPrpLdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondFacade.class);
    private static BLPrpLdeductCondFacade blPrpLdeductCondFacade = new BLPrpLdeductCondFacade();
    public static BLPrpLdeductCondFacade getInstance(){
    	return blPrpLdeductCondFacade;
    }

    /**
     * 构造函数
     */
    public BLPrpLdeductCondFacade(){
        super();
    }
}
