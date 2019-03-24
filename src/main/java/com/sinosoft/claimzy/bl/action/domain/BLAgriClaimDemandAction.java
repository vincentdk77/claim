package com.sinosoft.claimzy.bl.action.domain;

import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是BLAgriClaimDemandAction的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimDemandAction extends BLAgriClaimDemandActionBase{
	private static Logger logger = Logger.getLogger(BLAgriClaimDemandAction.class);

    /**
     * 构造函数
     */
    public BLAgriClaimDemandAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto,String mode)
            throws Exception{
    }
}
