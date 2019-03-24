package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;

/**
 * 这是单证信息表的数据访问对象类<br>
 * 创建于 2014-04-01 17:36:57.562<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCertify extends DBPrpLinterCertifyBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCertify.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCertify(DBManager dbManager){
        super(dbManager);
    }
}
