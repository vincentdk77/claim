package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdeductcondDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddeductcond的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeductcondAction extends BLPrpDdeductcondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdeductcondAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDdeductcondAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDdeductcondDto prpDdeductcondDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDdeductcondDto prpDdeductcondDto,String mode) throws Exception{
    }
}
