package com.sinosoft.servlet.accisd.bl.action.domain;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLACCIBASEINFOSD的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciBaseInfoSDAction extends BLPrpLAcciBaseInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDAction.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciBaseInfoSDAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto,String mode)
            throws Exception{
    }
}
