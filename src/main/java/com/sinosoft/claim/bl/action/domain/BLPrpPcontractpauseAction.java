package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpPcontractpause中止保险合同信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPcontractpauseAction extends BLPrpPcontractpauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpPcontractpauseAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpPcontractpauseAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto,String mode) throws Exception{
    }
}
