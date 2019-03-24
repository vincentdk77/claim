package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXCformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpxcform承保数据字典表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXCformAction extends BLPrpXCformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXCformAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpXCformAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpXCformDto prpXCformDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpXCformDto prpXCformDto,String mode) throws Exception{
    }
}
