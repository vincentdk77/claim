package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcheck查勘/代查勘信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcheckAction extends BLPrpLcheckActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcheckAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLcheckAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcheckDto prpLcheckDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckDto prpLcheckDto,String mode) throws Exception{
    }
}
