package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.claim.dto.domain.PrpLpropDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplprop财产核定损明细清单表的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:45.913<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpropAction extends BLPrpLpropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpropAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpropAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpropDto prpLpropDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpropDto prpLpropDto,String mode) throws Exception{
    }
}
