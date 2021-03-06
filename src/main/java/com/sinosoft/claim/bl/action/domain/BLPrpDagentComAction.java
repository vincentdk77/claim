package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentComDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdagentcom承保地区,承保公司表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentComAction extends BLPrpDagentComActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentComAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDagentComAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDagentComDto prpDagentComDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDagentComDto prpDagentComDto,String mode) throws Exception{
    }
}
