package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;

/**
 * 这是PRPLJOBMANAGERTIME的数据访问对象类<br>
 * 创建于 2011-11-14 11:45:25.578<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpljobmanagertime extends DBPrpljobmanagertimeBase{
    private static Logger logger = Logger.getLogger(DBPrpljobmanagertime.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpljobmanagertime(DBManager dbManager){
        super(dbManager);
    }
}
