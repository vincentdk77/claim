package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonTrace 人伤跟踪表的业务对象扩展类<br>
 * 创建于 2005-02-18 10:21:28.781<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonTraceAction extends BLPrpLpersonTraceActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonTraceAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto,String mode) throws Exception{
    }
}
