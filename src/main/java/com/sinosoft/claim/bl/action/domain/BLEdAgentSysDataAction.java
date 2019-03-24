package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdAgentSysData的业务对象扩展类<br>
 * 创建于 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdAgentSysDataAction extends BLEdAgentSysDataActionBase{
    private static Log logger = LogFactory.getLog(BLEdAgentSysDataAction.class);

    /**
     * 构造函数
     */
    public BLEdAgentSysDataAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param edAgentSysDataDto edAgentSysDataDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto,String mode) throws Exception{
    }
}
