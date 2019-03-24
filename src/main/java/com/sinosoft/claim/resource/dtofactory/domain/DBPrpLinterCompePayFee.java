package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;

/**
 * 这是计算书赔款费用信息的数据访问对象类<br>
 * 创建于 2014-04-11 15:02:52.946<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCompePayFee extends DBPrpLinterCompePayFeeBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCompePayFee.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCompePayFee(DBManager dbManager){
        super(dbManager);
    }
}
