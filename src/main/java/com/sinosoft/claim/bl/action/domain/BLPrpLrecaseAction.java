package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplrecase重开赔案表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLrecaseAction extends BLPrpLrecaseActionBase{
    private static Log log = LogFactory.getLog(BLPrpLrecaseAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLrecaseAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLrecaseDto prpLrecaseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLrecaseDto prpLrecaseDto,String mode) throws Exception{
    }
}
