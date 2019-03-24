package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyDirect-索赔指引(新增)的业务对象扩展类<br>
 * 创建于 2005-03-22 17:21:39.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyDirectAction extends BLPrpLcertifyDirectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyDirectAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyDirectAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto,String mode) throws Exception{
    }
}
