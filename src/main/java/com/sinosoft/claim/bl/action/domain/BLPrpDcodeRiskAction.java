package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeRiskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcoderisk通用代码险种对照表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeRiskAction extends BLPrpDcodeRiskActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeRiskAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDcodeRiskAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto,String mode) throws Exception{
    }
}
