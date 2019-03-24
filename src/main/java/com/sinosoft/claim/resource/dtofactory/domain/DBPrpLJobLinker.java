package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;

/**
 * 这是PrpLJobLinker的数据访问对象类<br>
 * 创建于 2012-09-06 10:43:05.218<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLJobLinker extends DBPrpLJobLinkerBase{
    private static Logger logger = Logger.getLogger(DBPrpLJobLinker.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLJobLinker(DBManager dbManager){
        super(dbManager);
    }
}
