package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLdeductCond-计算书免赔条件表的数据访问对象类<br>
 * 创建于 2006-06-07 16:25:07.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLdeductCond extends DBPrpLdeductCondBase{
    private static Log logger = LogFactory.getLog(DBPrpLdeductCond.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLdeductCond(DBManager dbManager){
        super(dbManager);
    }
}
