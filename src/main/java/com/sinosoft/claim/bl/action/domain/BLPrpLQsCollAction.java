package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsCollDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_coll清算中心通赔结算汇总表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsCollAction extends BLPrpLQsCollActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsCollAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLQsCollAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLQs_collDto prpLQs_collDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsCollDto prpLQs_collDto,String mode) throws Exception{
    }
}
