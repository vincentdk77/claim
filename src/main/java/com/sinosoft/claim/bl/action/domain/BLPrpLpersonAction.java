package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplperson人员伤亡明细信息表的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:45.943<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonAction extends BLPrpLpersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpersonDto prpLpersonDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonDto prpLpersonDto,String mode) throws Exception{
    }
}
