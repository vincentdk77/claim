package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaimpolicy立案保单清单表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimPolicyAction extends BLPrpLclaimPolicyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimPolicyAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimPolicyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto,String mode) throws Exception{
    }
}
