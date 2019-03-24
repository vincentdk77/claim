package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpGrant 授权记录表的业务对象扩展类<br>
 * 创建于 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantAction extends BLPrpGrantActionBase{
    private static Log logger = LogFactory.getLog(BLPrpGrantAction.class);

    /**
     * 构造函数
     */
    public BLPrpGrantAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpGrantDto prpGrantDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGrantDto prpGrantDto,String mode) throws Exception{
    }
}
