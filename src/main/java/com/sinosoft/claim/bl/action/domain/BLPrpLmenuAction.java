package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmenu-菜单表(新增)的业务对象扩展类<br>
 * 创建于 2005-05-08 15:15:53.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuAction extends BLPrpLmenuActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuAction.class);

    /**
     * 构造函数
     */
    public BLPrpLmenuAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLmenuDto prpLmenuDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmenuDto prpLmenuDto,String mode) throws Exception{
    }
}
