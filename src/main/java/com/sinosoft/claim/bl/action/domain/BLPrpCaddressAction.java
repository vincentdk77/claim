package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCaddressDto;

/**
 * 这是prpcaddress保险地址表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCaddressAction extends BLPrpCaddressActionBase{
    private static Log log = LogFactory.getLog(BLPrpCaddressAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCaddressAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCaddressDto prpCaddressDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCaddressDto prpCaddressDto,String mode) throws Exception{
    }
}
