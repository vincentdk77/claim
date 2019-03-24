package com.sinosoft.claimprop.common.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropDemand;

/**
 * 这是CiClaimPropDemand的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandAction extends BLCiClaimPropDemandActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandAction.class);

    /**
     * 构造函数
     */
    public BLCiClaimPropDemandAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto,String mode)
            throws Exception{
    }
}
