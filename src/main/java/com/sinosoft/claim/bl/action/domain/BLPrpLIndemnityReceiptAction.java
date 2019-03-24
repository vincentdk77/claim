package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是赔款收据的业务对象扩展类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLIndemnityReceiptAction extends BLPrpLIndemnityReceiptActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLIndemnityReceiptAction.class);

    /**
     * 构造函数
     */
    public BLPrpLIndemnityReceiptAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLIndemnityReceiptDto prpLIndemnityReceiptDto,String mode)
            throws Exception{
    }
}
