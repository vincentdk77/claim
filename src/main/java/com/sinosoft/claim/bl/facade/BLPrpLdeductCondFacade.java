package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ����PrpLdeductCond-�����������������ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondFacade extends BLPrpLdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondFacade.class);
    private static BLPrpLdeductCondFacade blPrpLdeductCondFacade = new BLPrpLdeductCondFacade();
    public static BLPrpLdeductCondFacade getInstance(){
    	return blPrpLdeductCondFacade;
    }

    /**
     * ���캯��
     */
    public BLPrpLdeductCondFacade(){
        super();
    }
}
