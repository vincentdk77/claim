package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDpersonPay人员赔付标准金额表的业务对象扩展类<br>
 * 创建于 2004-09-20 14:11:31.382<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayAction extends BLPrpDpersonPayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayAction.class);

    /**
     * 构造函数
     */
    public BLPrpDpersonPayAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDpersonPayDto prpDpersonPayDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto,String mode) throws Exception{
    }
}
