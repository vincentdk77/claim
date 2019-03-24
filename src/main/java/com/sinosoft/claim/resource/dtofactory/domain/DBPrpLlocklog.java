package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是PRPLLOCKLOG的数据访问对象类<br>
 * 创建于 2012-05-25 08:48:16.609<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLlocklog extends DBPrpLlocklogBase{
    private static Logger logger = Logger.getLogger(DBPrpLlocklog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLlocklog(DBManager dbManager){
        super(dbManager);
    }
}
