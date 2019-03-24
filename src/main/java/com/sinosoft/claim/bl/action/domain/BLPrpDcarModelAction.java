package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcarModelDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcarmodel车型代码的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcarModelAction extends BLPrpDcarModelActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcarModelAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDcarModelAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDcarModelDto prpDcarModelDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcarModelDto prpDcarModelDto,String mode) throws Exception{
    }
}
