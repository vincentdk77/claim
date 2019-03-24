package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;

/**
 * 这是CallCenterSendStatus的数据访问对象类<br>
 * 创建于 2015-05-27 10:48:16.421<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCallCenterSendStatus extends DBCallCenterSendStatusBase{
    private static Logger logger = Logger.getLogger(DBCallCenterSendStatus.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCallCenterSendStatus(DBManager dbManager){
        super(dbManager);
    }
}
