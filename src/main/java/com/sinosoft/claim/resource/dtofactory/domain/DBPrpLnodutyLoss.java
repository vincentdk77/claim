package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;

/**
 * 这是prpLnodutyLoss的数据访问对象类<br>
 * 创建于 2008-01-28 10:57:23.203<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLnodutyLoss extends DBPrpLnodutyLossBase{
    private static Logger logger = Logger.getLogger(DBPrpLnodutyLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLnodutyLoss(DBManager dbManager){
        super(dbManager);
    }
}
