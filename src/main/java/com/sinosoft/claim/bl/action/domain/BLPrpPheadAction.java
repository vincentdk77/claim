package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpphead批改信息表的业务对象扩展类<br>
 * 创建于 2004-11-22 15:24:30.890<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPheadAction extends BLPrpPheadActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPheadAction.class);

    /**
     * 构造函数
     */
    public BLPrpPheadAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpPheadDto prpPheadDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPheadDto prpPheadDto,String mode) throws Exception{
    }
}
