package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreclaimDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplreclaim损余回收信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLreclaimAction extends BLPrpLreclaimActionBase{
    private static Log log = LogFactory.getLog(BLPrpLreclaimAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLreclaimAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLreclaimDto prpLreclaimDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLreclaimDto prpLreclaimDto,String mode) throws Exception{
    }
}
