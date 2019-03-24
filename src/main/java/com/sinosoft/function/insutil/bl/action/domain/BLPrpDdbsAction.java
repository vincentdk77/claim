package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdbsDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddbs的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdbsAction extends BLPrpDdbsActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdbsAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDdbsAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDdbsDto prpDdbsDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDdbsDto prpDdbsDto,String mode) throws Exception{
    }
}
