package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLsalvationDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplsalvation特约救助表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLsalvationAction extends BLPrpLsalvationActionBase{
    private static Log log = LogFactory.getLog(BLPrpLsalvationAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLsalvationAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLsalvationDto prpLsalvationDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLsalvationDto prpLsalvationDto,String mode) throws Exception{
    }
}
