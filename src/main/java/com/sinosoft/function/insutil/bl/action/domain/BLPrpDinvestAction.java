package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDinvestDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdinvest的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDinvestAction extends BLPrpDinvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpDinvestAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDinvestAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDinvestDto prpDinvestDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDinvestDto prpDinvestDto,String mode) throws Exception{
    }
}
