package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmedicineDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplmedicine雇员医药费清单表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmedicineAction extends BLPrpLmedicineActionBase{
    private static Log log = LogFactory.getLog(BLPrpLmedicineAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLmedicineAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLmedicineDto prpLmedicineDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmedicineDto prpLmedicineDto,String mode) throws Exception{
    }
}
