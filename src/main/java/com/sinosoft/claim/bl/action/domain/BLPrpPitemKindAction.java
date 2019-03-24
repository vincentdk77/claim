package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppitemkind标的子险信息的业务对象扩展类<br>
 * 创建于 2004-11-22 15:24:31.187<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPitemKindAction extends BLPrpPitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPitemKindAction.class);

    /**
     * 构造函数
     */
    public BLPrpPitemKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpPitemKindDto prpPitemKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPitemKindDto prpPitemKindDto,String mode) throws Exception{
    }
}
