package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcompany机构代码表的业务对象扩展类<br>
 * 创建于 2004-11-09 18:29:25.850<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyAction extends BLPrpDcompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyAction.class);

    /**
     * 构造函数
     */
    public BLPrpDcompanyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDcompanyDto prpDcompanyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcompanyDto prpDcompanyDto,String mode) throws Exception{
    }
}
