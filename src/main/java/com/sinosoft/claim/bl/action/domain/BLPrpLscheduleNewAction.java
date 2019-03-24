package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLscheduleNew新案件提示表的业务对象扩展类<br>
 * 创建于 2004-07-16 09:32:43.554<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleNewAction extends BLPrpLscheduleNewActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleNewAction.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleNewAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto,String mode) throws Exception{
    }
}
