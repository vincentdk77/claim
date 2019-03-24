package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcheckext查勘/代查勘扩展表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcheckExtAction extends BLPrpLcheckExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcheckExtAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLcheckExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcheckExtDto prpLcheckExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto,String mode) throws Exception{
    }
}
