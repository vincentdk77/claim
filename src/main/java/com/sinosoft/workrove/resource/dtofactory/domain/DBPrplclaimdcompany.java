package com.sinosoft.workrove.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;

/**
 * 这是PRPLCLAIMDCOMPANY的数据访问对象类<br>
 * 创建于 2011-05-23 16:35:29.500<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplclaimdcompany extends DBPrplclaimdcompanyBase{
    private static Logger logger = Logger.getLogger(DBPrplclaimdcompany.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplclaimdcompany(DBManager dbManager){
        super(dbManager);
    }
}
