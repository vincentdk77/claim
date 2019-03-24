package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplloss赔付标的信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLlossActionFG extends BLPrpLlossActionBaseFG{
    private static Log log = LogFactory.getLog(BLPrpLlossActionFG.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLlossActionFG(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLlossDto prpLlossDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLlossDto prpLlossDto,String mode) throws Exception{
    }
}
