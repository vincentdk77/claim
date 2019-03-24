package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的业务对象扩展类<br>
 * 创建于 2006-06-04 15:22:15.047<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyAction extends BLPrpLRegistRPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyAction.class);

    /**
     * 构造函数
     */
    public BLPrpLRegistRPolicyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto,String mode) throws Exception{
    }
}
