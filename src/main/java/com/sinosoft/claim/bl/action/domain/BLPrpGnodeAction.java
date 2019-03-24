package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGnodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgnode工作流节点模板表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGnodeAction extends BLPrpGnodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGnodeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpGnodeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpGnodeDto prpGnodeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGnodeDto prpGnodeDto,String mode) throws Exception{
    }
}
