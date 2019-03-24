package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;

/**
 * 这是MessageReceiveLog的数据访问对象类<br>
 * 创建于 2012-12-13 16:41:59.000<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBMessageReceiveLog extends DBMessageReceiveLogBase{
    private static Logger logger = Logger.getLogger(DBMessageReceiveLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMessageReceiveLog(DBManager dbManager){
        super(dbManager);
    }
}
