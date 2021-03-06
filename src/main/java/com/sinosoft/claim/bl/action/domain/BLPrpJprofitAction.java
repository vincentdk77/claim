package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjprofit优惠记录表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJprofitAction extends BLPrpJprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpJprofitAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJprofitAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJprofitDto prpJprofitDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJprofitDto prpJprofitDto,String mode) throws Exception{
    }
}
