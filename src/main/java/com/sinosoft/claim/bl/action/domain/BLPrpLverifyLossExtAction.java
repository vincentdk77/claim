package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLossExt的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLverifyLossExtAction extends BLPrpLverifyLossExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossExtAction.class);

    /**
     * 构造函数
     */
    public BLPrpLverifyLossExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto,String mode)
            throws Exception{
    }
}
