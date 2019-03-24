package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;

/**
 * 这是中间表关联报案号的数据访问对象类<br>
 * 创建于 2014-04-14 18:10:01.267<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplinterrelation extends DBPrplinterrelationBase{
    private static Logger logger = Logger.getLogger(DBPrplinterrelation.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplinterrelation(DBManager dbManager){
        super(dbManager);
    }
}
