package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLafterwardDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplafterward案后费用处理表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLafterwardAction extends BLPrpLafterwardActionBase{
    private static Log log = LogFactory.getLog(BLPrpLafterwardAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLafterwardAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLafterwardDto prpLafterwardDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLafterwardDto prpLafterwardDto,String mode) throws Exception{
    }
}
