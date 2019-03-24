package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcfee赔款计算金额表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcfeeAction extends BLPrpLcfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcfeeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLcfeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcfeeDto prpLcfeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcfeeDto prpLcfeeDto,String mode) throws Exception{
    }
}
