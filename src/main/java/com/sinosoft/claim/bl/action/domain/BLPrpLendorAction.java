package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLendor的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorAction extends BLPrpLendorActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorAction.class);

    /**
     * 构造函数
     */
    public BLPrpLendorAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLendorDto prpLendorDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLendorDto prpLendorDto,String mode)
            throws Exception{
    }
}
