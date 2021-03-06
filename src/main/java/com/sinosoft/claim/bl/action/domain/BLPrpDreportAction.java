package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDreportDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdreport报表配置文件的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDreportAction extends BLPrpDreportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDreportAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDreportAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDreportDto prpDreportDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDreportDto prpDreportDto,String mode) throws Exception{
    }
}
