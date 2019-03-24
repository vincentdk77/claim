package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是承保险别标的表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemAction extends BLPrpLkindItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemAction.class);

    /**
     * 构造函数
     */
    public BLPrpLkindItemAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLkindItemDto prpLkindItemDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLkindItemDto prpLkindItemDto,String mode)
            throws Exception{
    }
}
