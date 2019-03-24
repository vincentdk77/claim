package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdpartyStatus-与第三方企业信息交互信息状态表的业务对象扩展类<br>
 * 创建于 2005-03-18 15:44:09.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdpartyStatusAction extends BLPrpLthirdpartyStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdpartyStatusAction.class);

    /**
     * 构造函数
     */
    public BLPrpLthirdpartyStatusAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto,String mode) throws Exception{
    }
}
