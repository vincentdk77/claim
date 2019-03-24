package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;

/**
 * 这是PrpJthirdBankMapping的数据访问对象类<br>
 * 创建于 2014-08-18 19:51:23.093<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpJthirdBankMapping extends DBPrpJthirdBankMappingBase{
    private static Logger logger = Logger.getLogger(DBPrpJthirdBankMapping.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJthirdBankMapping(DBManager dbManager){
        super(dbManager);
    }
}
