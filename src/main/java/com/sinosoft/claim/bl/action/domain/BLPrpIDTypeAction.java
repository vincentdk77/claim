package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDTypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpidtype接口代码类型表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDTypeAction extends BLPrpIDTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDTypeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpIDTypeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpIDTypeDto prpIDTypeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpIDTypeDto prpIDTypeDto,String mode) throws Exception{
    }
}
