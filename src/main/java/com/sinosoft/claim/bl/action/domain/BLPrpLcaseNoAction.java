package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcaseno赔案号表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcaseNoAction extends BLPrpLcaseNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcaseNoAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLcaseNoAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcaseNoDto prpLcaseNoDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto,String mode) throws Exception{
    }
}
