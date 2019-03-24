package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLscheduleObject调度对象表的业务对象扩展类<br>
 * 创建于 2004-07-16 09:32:43.664<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleObjectAction extends BLPrpLscheduleObjectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleObjectAction.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleObjectAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto,String mode) throws Exception{
    }
}
