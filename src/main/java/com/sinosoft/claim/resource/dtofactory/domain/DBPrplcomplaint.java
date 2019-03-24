package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;

/**
 * 这是PRPLCOMPLAINT的数据访问对象类<br>
 * 创建于 2012-01-04 10:18:44.406<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcomplaint extends DBPrplcomplaintBase{
    private static Logger logger = Logger.getLogger(DBPrplcomplaint.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcomplaint(DBManager dbManager){
        super(dbManager);
    }
}
