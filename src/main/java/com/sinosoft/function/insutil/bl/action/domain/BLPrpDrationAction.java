package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrationDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdration的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationAction extends BLPrpDrationActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDrationAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDrationDto prpDrationDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrationDto prpDrationDto,String mode) throws Exception{
    }
}
