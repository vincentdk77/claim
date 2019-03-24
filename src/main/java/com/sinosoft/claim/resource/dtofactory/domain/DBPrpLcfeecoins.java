package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;

/**
 * 这是PrpLcfeecoins的数据访问对象类<br>
 * 创建于 2013-09-10 08:53:50.046<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcfeecoins extends DBPrpLcfeecoinsBase{
    private static Logger logger = Logger.getLogger(DBPrpLcfeecoins.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcfeecoins(DBManager dbManager){
        super(dbManager);
    }
}
