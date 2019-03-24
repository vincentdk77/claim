package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;

/**
 * 这是立案估损金额信息的数据访问对象类<br>
 * 创建于 2014-04-01 17:32:28.074<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterClaimKind extends DBPrpLinterClaimKindBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterClaimKind.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterClaimKind(DBManager dbManager){
        super(dbManager);
    }
}
