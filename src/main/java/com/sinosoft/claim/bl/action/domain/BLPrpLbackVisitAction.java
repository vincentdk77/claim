package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisit--回访信息主表的业务对象扩展类<br>
 * 创建于 2005-03-25 20:44:46.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitAction extends BLPrpLbackVisitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitAction.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLbackVisitDto prpLbackVisitDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto,String mode) throws Exception{
    }
}
