package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer_idv个人客户代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
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
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto,String mode) throws Exception{
    }
}
