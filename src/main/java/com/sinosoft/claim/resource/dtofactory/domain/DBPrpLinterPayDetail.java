package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;

/**
 * 这是交互信息关联表------轨迹表的数据访问对象类<br>
 * 创建于 2014-04-23 09:35:16.513<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayDetail extends DBPrpLinterPayDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPayDetail(DBManager dbManager){
        super(dbManager);
    }
}
