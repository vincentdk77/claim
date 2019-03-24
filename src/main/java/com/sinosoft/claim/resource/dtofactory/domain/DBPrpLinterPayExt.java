package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;

/**
 * 这是传入参数子表------处理意见的数据访问对象类<br>
 * 创建于 2014-04-23 09:28:20.261<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayExt extends DBPrpLinterPayExtBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayExt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPayExt(DBManager dbManager){
        super(dbManager);
    }
}
