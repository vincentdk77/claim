package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplltext立案文字表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLltextAction extends BLPrpLltextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLltextAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLltextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLltextDto prpLltextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLltextDto prpLltextDto,String mode) throws Exception{
    }
}
