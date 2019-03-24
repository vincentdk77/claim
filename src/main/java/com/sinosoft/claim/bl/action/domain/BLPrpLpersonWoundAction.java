package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonWound 伤情信息表的业务对象扩展类<br>
 * 创建于 2005-02-18 10:21:28.781<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonWoundAction extends BLPrpLpersonWoundActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonWoundAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonWoundAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto,String mode) throws Exception{
    }
}
