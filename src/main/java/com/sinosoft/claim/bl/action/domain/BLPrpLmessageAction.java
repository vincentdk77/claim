package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmessage理赔流转讨论留言表的业务对象扩展类<br>
 * 创建于 2004-07-27 16:11:43.096<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmessageAction extends BLPrpLmessageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmessageAction.class);

    /**
     * 构造函数
     */
    public BLPrpLmessageAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLmessageDto prpLmessageDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmessageDto prpLmessageDto,String mode) throws Exception{
    }



}
