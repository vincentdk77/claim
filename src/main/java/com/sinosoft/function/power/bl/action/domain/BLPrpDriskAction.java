package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDrisk险种代码表的业务对象扩展类<br>
 * 创建于 2004-11-09 10:40:54.679<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskAction extends BLPrpDriskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskAction.class);

    /**
     * 构造函数
     */
    public BLPrpDriskAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDriskDto prpDriskDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDriskDto prpDriskDto,String mode) throws Exception{
    }
}
