package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utittycode终端属性记录表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyCodeAction extends BLUtiTtyCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyCodeAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiTtyCodeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiTtyCodeDto utiTtyCodeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiTtyCodeDto utiTtyCodeDto,String mode) throws Exception{
    }
}
