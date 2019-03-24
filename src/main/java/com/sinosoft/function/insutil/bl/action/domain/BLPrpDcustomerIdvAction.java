package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomeridv的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvAction extends BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDcustomerIdvAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto,String mode) throws Exception{
    }
}
