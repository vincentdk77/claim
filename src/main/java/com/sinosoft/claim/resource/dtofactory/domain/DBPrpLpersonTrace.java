package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonTrace 人伤跟踪表的数据访问对象类<br>
 * 创建于 2005-02-18 10:21:18.953<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpersonTrace extends DBPrpLpersonTraceBase{
    private static Log logger = LogFactory.getLog(DBPrpLpersonTrace.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpersonTrace(DBManager dbManager){
        super(dbManager);
    }
}
