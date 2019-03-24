package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;

/**
 * 这是PRPLCOMPENSATEEAR的数据访问对象类<br>
 * 创建于 2011-08-10 16:51:13.125<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplcompensateear extends DBPrplcompensateearBase{
    private static Logger logger = Logger.getLogger(DBPrplcompensateear.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcompensateear(DBManager dbManager){
        super(dbManager);
    }
}
