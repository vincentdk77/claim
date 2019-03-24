package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLext的业务对象扩展类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLextAction extends BLPrpLextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLextAction.class);

    /**
     * 构造函数
     */
    public BLPrpLextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLextDto prpLextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLextDto prpLextDto,String mode) throws Exception{
    }
}
