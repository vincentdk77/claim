package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的业务对象扩展类<br>
 * 创建于 2005-08-17 15:04:01.050<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleCompanyAction extends BLPrpLscheduleCompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleCompanyAction.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleCompanyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto,String mode) throws Exception{
    }
}
