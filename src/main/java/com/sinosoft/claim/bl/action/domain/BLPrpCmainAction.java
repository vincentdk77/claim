package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcmain保单基本信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainAction extends BLPrpCmainActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCmainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCmainDto prpCmainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCmainDto prpCmainDto,String mode) throws Exception{
    }
}
