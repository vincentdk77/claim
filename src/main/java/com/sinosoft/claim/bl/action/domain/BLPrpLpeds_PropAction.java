package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PropDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Prop财产损失接口数据表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_PropAction extends BLPrpLpeds_PropActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_PropAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLpeds_PropAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpeds_PropDto prpLpeds_PropDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_PropDto prpLpeds_PropDto,String mode) throws Exception{
    }
}
