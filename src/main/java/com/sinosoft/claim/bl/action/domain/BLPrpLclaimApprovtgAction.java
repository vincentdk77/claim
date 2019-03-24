package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovtgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimApprov代赔数据转出确认表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimApprovtgAction extends BLPrpLclaimApprovtgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimApprovtgAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimApprovtgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto,String mode) throws Exception{
    }
}
