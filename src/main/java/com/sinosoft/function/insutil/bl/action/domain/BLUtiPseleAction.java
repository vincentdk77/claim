package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPseleDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipsele的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPseleAction extends BLUtiPseleActionBase{
    private static Log log = LogFactory.getLog(BLUtiPseleAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPseleAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPseleDto utiPseleDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPseleDto utiPseleDto,String mode) throws Exception{
    }
}
