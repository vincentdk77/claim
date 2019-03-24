package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitText--回访备注表的业务对象扩展类<br>
 * 创建于 2005-03-23 09:00:38.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextAction extends BLPrpLbackVisitTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextAction.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitTextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto,String mode) throws Exception{
    }
}
