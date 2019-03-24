package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdProp-财产损失部位表的业务对象扩展类<br>
 * 创建于 2005-04-12 11:37:51.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPropAction extends BLPrpLthirdPropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPropAction.class);

    /**
     * 构造函数
     */
    public BLPrpLthirdPropAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLthirdPropDto prpLthirdPropDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdPropDto prpLthirdPropDto,String mode) throws Exception{
    }
}
