package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;

/**
 * 这是立案注销交互信息关联表的数据访问对象类<br>
 * 创建于 2014-05-15 11:17:32.640<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCancelClaimDetail extends DBPrpLinterCancelClaimDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCancelClaimDetail(DBManager dbManager){
        super(dbManager);
    }
}
