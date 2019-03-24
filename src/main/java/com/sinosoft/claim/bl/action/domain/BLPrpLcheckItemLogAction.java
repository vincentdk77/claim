package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemLogDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckItemLog-查勘任务信息处理日志表的业务对象扩展类<br>
 * 创建于 2005-03-18 15:44:09.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemLogAction extends BLPrpLcheckItemLogActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemLogAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckItemLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckItemLogDto prpLcheckItemLogDto,String mode) throws Exception{
    }
}
