package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;

/**
 * 这是PRPLACCIDANGERSD的数据访问对象类<br>
 * 创建于 2018-07-28 12:42:56.947<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplaccidangersd extends DBPrplaccidangersdBase{
    private static Logger logger = Logger.getLogger(DBPrplaccidangersd.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplaccidangersd(DBManager dbManager){
        super(dbManager);
    }
}
