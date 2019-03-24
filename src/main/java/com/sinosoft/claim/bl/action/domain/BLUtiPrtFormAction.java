package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtFormDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtform复杂横纵表头的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtFormAction extends BLUtiPrtFormActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtFormAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPrtFormAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPrtFormDto utiPrtFormDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtFormDto utiPrtFormDto,String mode) throws Exception{
    }
}
