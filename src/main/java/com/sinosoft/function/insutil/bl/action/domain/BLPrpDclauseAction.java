package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclause的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseAction extends BLPrpDclauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDclauseAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDclauseDto prpDclauseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDclauseDto prpDclauseDto,String mode) throws Exception{
    }
}
