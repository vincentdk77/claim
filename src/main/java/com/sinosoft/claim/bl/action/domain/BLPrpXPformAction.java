package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXPformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpxpform批改数据字典表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPformAction extends BLPrpXPformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPformAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpXPformAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpXPformDto prpXPformDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpXPformDto prpXPformDto,String mode) throws Exception{
    }
}
