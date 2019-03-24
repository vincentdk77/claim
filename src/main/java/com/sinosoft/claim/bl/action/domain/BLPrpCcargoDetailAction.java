package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcargoDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpccargodetail货运险货运明细信息的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcargoDetailAction extends BLPrpCcargoDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcargoDetailAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCcargoDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto,String mode) throws Exception{
    }
}
