package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDscrapTermDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdscrapterm汽车报废标准表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDscrapTermAction extends BLPrpDscrapTermActionBase{
    private static Log log = LogFactory.getLog(BLPrpDscrapTermAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDscrapTermAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDscrapTermDto prpDscrapTermDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto,String mode) throws Exception{
    }
}
