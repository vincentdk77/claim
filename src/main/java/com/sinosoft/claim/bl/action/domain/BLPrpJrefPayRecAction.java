package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPayRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefpayrec付费和收费联系记录表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPayRecAction extends BLPrpJrefPayRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPayRecAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJrefPayRecAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefPayRecDto prpJrefPayRecDto,String mode) throws Exception{
    }
}
