package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDstatiTypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdstatitype险种统计分类表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDstatiTypeAction extends BLPrpDstatiTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDstatiTypeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDstatiTypeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDstatiTypeDto prpDstatiTypeDto,String mode) throws Exception{
    }
}
