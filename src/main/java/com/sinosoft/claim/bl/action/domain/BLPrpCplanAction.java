package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcplan收费计划表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCplanAction extends BLPrpCplanActionBase{
    private static Log log = LogFactory.getLog(BLPrpCplanAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCplanAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCplanDto prpCplanDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCplanDto prpCplanDto,String mode) throws Exception{
    }
}
