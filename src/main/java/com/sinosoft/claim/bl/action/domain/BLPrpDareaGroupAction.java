package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDareaGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdareagroup机动车费率区域分组表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDareaGroupAction extends BLPrpDareaGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpDareaGroupAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDareaGroupAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDareaGroupDto prpDareaGroupDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto,String mode) throws Exception{
    }
}
