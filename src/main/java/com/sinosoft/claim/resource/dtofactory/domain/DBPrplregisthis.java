package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;

/**
 * 这是PRPLREGISTHIS的数据访问对象类<br>
 * 创建于 2011-02-15 11:40:49.369<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplregisthis extends DBPrplregisthisBase{
    private static Logger logger = Logger.getLogger(DBPrplregisthis.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplregisthis(DBManager dbManager){
        super(dbManager);
    }
}
