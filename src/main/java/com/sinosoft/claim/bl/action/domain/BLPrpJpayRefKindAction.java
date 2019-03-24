package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrefkind收付费险别分摊表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRefKindAction extends BLPrpJpayRefKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRefKindAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJpayRefKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto,String mode) throws Exception{
    }
}
