package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateLoanDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrateloan的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateLoanAction extends BLPrpDrateLoanActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateLoanAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDrateLoanAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDrateLoanDto prpDrateLoanDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateLoanDto prpDrateLoanDto,String mode) throws Exception{
    }
}
