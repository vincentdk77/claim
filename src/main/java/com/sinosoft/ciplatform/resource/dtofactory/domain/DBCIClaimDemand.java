package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔平台查询表的数据访问对象类<br>
 * 创建于 2006-06-21 20:28:57.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimDemand extends DBCIClaimDemandBase{
    private static Logger logger = Logger.getLogger(DBCIClaimDemand.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimDemand(DBManager dbManager){
        super(dbManager);
    }
}
