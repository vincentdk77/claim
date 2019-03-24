package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplPayeeInfo的数据访问对象类<br>
 * 创建于 2018-12-03 19:24:47.123<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplPayeeInfo extends DBPrplPayeeInfoBase{
    private static Logger logger = Logger.getLogger(DBPrplPayeeInfo.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplPayeeInfo(DBManager dbManager){
        super(dbManager);
    }
}
