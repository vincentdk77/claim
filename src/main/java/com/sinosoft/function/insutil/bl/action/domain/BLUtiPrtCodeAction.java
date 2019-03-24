package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtcode的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtCodeAction extends BLUtiPrtCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtCodeAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPrtCodeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPrtCodeDto utiPrtCodeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto,String mode) throws Exception{
    }
}
