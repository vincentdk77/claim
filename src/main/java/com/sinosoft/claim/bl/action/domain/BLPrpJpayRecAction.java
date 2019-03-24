package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrec收费登记表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRecAction extends BLPrpJpayRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRecAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJpayRecAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJpayRecDto prpJpayRecDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpayRecDto prpJpayRecDto,String mode) throws Exception{
    }
}
