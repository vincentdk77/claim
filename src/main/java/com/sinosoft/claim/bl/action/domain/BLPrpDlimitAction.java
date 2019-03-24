package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdlimit限额免赔代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDlimitAction extends BLPrpDlimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDlimitAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDlimitAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDlimitDto prpDlimitDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDlimitDto prpDlimitDto,String mode) throws Exception{
    }
}
