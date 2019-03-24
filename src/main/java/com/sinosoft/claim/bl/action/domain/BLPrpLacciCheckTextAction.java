package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciCheckText--调查文本信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckTextAction extends BLPrpLacciCheckTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckTextAction.class);

    /**
     * 构造函数
     */
    public BLPrpLacciCheckTextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto,String mode) throws Exception{
    }
}
