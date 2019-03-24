package com.sinosoft.ciplatform.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimDemand;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔平台查询表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimDemandAction extends BLCIClaimDemandActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimDemandAction.class);

    /**
     * 构造函数
     */
    public BLCIClaimDemandAction(){
        super();
    }
    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIClaimDemandDto cIClaimDemandDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto,String mode)
            throws Exception{
    }
}
