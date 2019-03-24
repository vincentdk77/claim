package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplthirdparty理赔车辆信息的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLthirdPartyAction extends BLPrpLthirdPartyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLthirdPartyAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLthirdPartyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdPartyDto prpLthirdPartyDto,String mode) throws Exception{
    }
}
