package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;

/**
 * 这是大病医疗接口重开赔案流程状态表的数据访问对象类<br>
 * 创建于 2014-04-28 14:43:42.410<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterRecaseDetail extends DBPrpLinterRecaseDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterRecaseDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterRecaseDetail(DBManager dbManager){
        super(dbManager);
    }
}
