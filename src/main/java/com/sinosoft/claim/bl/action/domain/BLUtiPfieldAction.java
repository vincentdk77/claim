package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPfieldDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipfield单证打印的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPfieldAction extends BLUtiPfieldActionBase{
    private static Log log = LogFactory.getLog(BLUtiPfieldAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPfieldAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPfieldDto utiPfieldDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPfieldDto utiPfieldDto,String mode) throws Exception{
    }
}
