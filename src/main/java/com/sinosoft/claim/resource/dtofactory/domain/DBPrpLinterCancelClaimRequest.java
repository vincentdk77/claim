package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;

/**
 * 这是立案注销传入参主数的数据访问对象类<br>
 * 创建于 2014-05-15 11:16:43.126<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCancelClaimRequest extends DBPrpLinterCancelClaimRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimRequest.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCancelClaimRequest(DBManager dbManager){
        super(dbManager);
    }
}
