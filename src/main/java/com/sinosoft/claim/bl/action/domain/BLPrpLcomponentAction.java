package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcomponent换件项目清单的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:47.765<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcomponentAction extends BLPrpLcomponentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomponentAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcomponentAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcomponentDto prpLcomponentDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcomponentDto prpLcomponentDto,String mode) throws Exception{
    }
}
