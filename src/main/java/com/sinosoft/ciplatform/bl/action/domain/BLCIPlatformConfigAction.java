package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIPlatformConfig;

/**
 * 这是CIPlatformConfig的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIPlatformConfigAction extends BLCIPlatformConfigActionBase{
    private static Logger logger = Logger.getLogger(BLCIPlatformConfigAction.class);

    /**
     * 构造函数
     */
    public BLCIPlatformConfigAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIPlatformConfigDto cIPlatformConfigDto,String mode)
            throws Exception{
    }
}
