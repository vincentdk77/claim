package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

/**
 * 这是大病医疗理赔自动流程状态查询表的数据访问对象类<br>
 * 创建于 2014-04-03 09:20:52.533<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplinterAutoClaimDetail extends DBPrplinterAutoClaimDetailBase{
    private static Logger logger = Logger.getLogger(DBPrplinterAutoClaimDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplinterAutoClaimDetail(DBManager dbManager){
        super(dbManager);
    }
}
