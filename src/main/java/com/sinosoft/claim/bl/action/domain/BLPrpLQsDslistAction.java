package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsDslistDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_Dslist地市通赔结算明细清单表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsDslistAction extends BLPrpLQsDslistActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsDslistAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLQsDslistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto,String mode) throws Exception{
    }
}
