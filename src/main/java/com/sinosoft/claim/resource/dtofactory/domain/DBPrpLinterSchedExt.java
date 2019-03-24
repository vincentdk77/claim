package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;

/**
 * 这是补充说明信息的数据访问对象类<br>
 * 创建于 2014-04-01 17:10:38.515<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterSchedExt extends DBPrpLinterSchedExtBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterSchedExt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterSchedExt(DBManager dbManager){
        super(dbManager);
    }
}
