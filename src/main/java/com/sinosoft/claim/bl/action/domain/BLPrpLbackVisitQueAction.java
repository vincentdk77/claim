package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitQue--回访问询表的业务对象扩展类<br>
 * 创建于 2005-03-23 09:00:24.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueAction extends BLPrpLbackVisitQueActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueAction.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitQueAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto,String mode) throws Exception{
    }
}
