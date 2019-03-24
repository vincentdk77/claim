package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCallCenterSendStatus;

/**
 * 这是CallCenterSendStatus的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCallCenterSendStatusAction extends BLCallCenterSendStatusActionBase{
    private static Logger logger = Logger.getLogger(BLCallCenterSendStatusAction.class);

    /**
     * 构造函数
     */
    public BLCallCenterSendStatusAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CallCenterSendStatusDto callCenterSendStatusDto,String mode)
            throws Exception{
    }
}
