package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrate的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateAction extends BLPrpDrateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDrateAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDrateDto prpDrateDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateDto prpDrateDto,String mode) throws Exception{
    }
}
