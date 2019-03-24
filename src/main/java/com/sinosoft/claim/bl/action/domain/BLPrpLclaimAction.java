package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaim立案基本信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimAction extends BLPrpLclaimActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimDto prpLclaimDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimDto prpLclaimDto,String mode) throws Exception{
    }
}
