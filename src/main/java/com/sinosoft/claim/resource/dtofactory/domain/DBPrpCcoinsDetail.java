package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;

/**
 * 这是PrpCcoinsDetail的数据访问对象类<br>
 * 创建于 2013-09-06 11:02:16.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCcoinsDetail extends DBPrpCcoinsDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpCcoinsDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCcoinsDetail(DBManager dbManager){
        super(dbManager);
    }
}
