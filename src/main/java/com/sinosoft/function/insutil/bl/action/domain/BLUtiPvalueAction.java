package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPvalueDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipvalue的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPvalueAction extends BLUtiPvalueActionBase{
    private static Log log = LogFactory.getLog(BLUtiPvalueAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPvalueAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPvalueDto utiPvalueDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPvalueDto utiPvalueDto,String mode) throws Exception{
    }
}
