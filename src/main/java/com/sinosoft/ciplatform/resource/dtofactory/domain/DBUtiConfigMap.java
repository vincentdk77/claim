package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是商业险平台配置表的数据访问对象类<br>
 * 创建于 2010-09-01 10:52:44.484<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBUtiConfigMap extends DBUtiConfigMapBase{
    private static Logger logger = Logger.getLogger(DBUtiConfigMap.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiConfigMap(DBManager dbManager){
        super(dbManager);
    }
}
