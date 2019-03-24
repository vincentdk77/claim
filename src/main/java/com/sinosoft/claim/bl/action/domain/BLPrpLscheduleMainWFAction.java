package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMainWF的业务对象扩展类<br>
 * 创建于 2005-03-18 16:42:21.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainWFAction extends BLPrpLscheduleMainWFActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainWFAction.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleMainWFAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleMainWFDto prpLscheduleMainWFDto,String mode) throws Exception{
    }
}
