package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJcommAllocDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjcommalloc手续费分摊表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJcommAllocAction extends BLPrpJcommAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJcommAllocAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJcommAllocAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJcommAllocDto prpJcommAllocDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto,String mode) throws Exception{
    }
}
