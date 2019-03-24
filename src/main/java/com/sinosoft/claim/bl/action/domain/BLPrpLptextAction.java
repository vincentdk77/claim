package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplptext预赔文字表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLptextAction extends BLPrpLptextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLptextAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLptextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLptextDto prpLptextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLptextDto prpLptextDto,String mode) throws Exception{
    }
}
