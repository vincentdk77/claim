package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdship船舶代码的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshipAction extends BLPrpDshipActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshipAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDshipAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDshipDto prpDshipDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDshipDto prpDshipDto,String mode) throws Exception{
    }
}
