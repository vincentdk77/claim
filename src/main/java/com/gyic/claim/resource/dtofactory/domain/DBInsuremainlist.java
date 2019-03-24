package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;

/**
 * 这是投保清单头表的数据访问对象类<br>
 * 创建于 2011-08-03 11:44:12.515<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBInsuremainlist extends DBInsuremainlistBase{
    private static Logger logger = Logger.getLogger(DBInsuremainlist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBInsuremainlist(DBManager dbManager){
        super(dbManager);
    }
}
