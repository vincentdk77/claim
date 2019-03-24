package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclauseKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclausekind条款险别关系表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseKindAction extends BLPrpDclauseKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseKindAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDclauseKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDclauseKindDto prpDclauseKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto,String mode) throws Exception{
    }
}
