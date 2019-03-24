package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUndoCancel作废或删除操作轨迹主表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelAction extends BLPrpUndoCancelActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpUndoCancelAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpUndoCancelDto prpUndoCancelDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto,String mode) throws Exception{
    }
}
