package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是CIClaimCrash 车辆理赔记录的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCrashAction extends BLCiClaimCrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCrashAction.class);

    /**
     * 构造函数
     */
    public BLCiClaimCrashAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param ciClaimCrashDto ciClaimCrashDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimCrashDto ciClaimCrashDto,String mode)
            throws Exception{
    }
}
