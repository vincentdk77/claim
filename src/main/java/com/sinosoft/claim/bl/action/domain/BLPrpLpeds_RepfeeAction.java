package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_RepfeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Repfee修理费用清单接口数据表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_RepfeeAction extends BLPrpLpeds_RepfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_RepfeeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLpeds_RepfeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_RepfeeDto prpLpeds_RepfeeDto,String mode) throws Exception{
    }
}
