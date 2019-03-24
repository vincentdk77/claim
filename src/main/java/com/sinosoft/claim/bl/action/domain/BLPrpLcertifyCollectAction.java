package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyCollect的业务对象扩展类<br>
 * 创建于 2004-07-05 17:16:11.606<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertifyCollectAction extends BLPrpLcertifyCollectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyCollectAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto,String mode) throws Exception{
    }
}
