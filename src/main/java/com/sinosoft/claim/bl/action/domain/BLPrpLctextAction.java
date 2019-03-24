package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplctext赔款计算文字表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLctextAction extends BLPrpLctextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLctextAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLctextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLctextDto prpLctextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLctextDto prpLctextDto,String mode) throws Exception{
    }
}
