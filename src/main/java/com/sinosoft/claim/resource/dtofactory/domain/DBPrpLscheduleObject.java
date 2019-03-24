package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLscheduleObject调度对象表的数据访问对象类<br>
 * 创建于 2004-07-15 21:00:43.255<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleObject extends DBPrpLscheduleObjectBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleObject.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleObject(DBManager dbManager){
        super(dbManager);
    }
}
