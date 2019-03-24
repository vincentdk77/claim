package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLtrackDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpltrack的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLtrackAction extends BLPrpLtrackActionBase{
    private static Log log = LogFactory.getLog(BLPrpLtrackAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLtrackAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLtrackDto prpLtrackDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLtrackDto prpLtrackDto,String mode) throws Exception{
    }
}
