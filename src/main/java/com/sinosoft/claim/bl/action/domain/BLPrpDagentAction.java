package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdagent代理人代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentAction extends BLPrpDagentActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDagentAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDagentDto prpDagentDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDagentDto prpDagentDto,String mode) throws Exception{
    }
}
