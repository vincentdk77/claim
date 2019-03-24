package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashAction extends BLCiClaimCompelcrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashAction.class);

    /**
     * 构造函数
     */
    public BLCiClaimCompelcrashAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto,String mode)
            throws Exception{
    }
}
