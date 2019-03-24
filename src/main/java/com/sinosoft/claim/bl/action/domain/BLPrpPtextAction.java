package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpptext批改文字信息的业务对象扩展类<br>
 * 创建于 2004-11-22 15:24:31.281<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextAction extends BLPrpPtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextAction.class);

    /**
     * 构造函数
     */
    public BLPrpPtextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpPtextDto prpPtextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPtextDto prpPtextDto,String mode) throws Exception{
    }
}
