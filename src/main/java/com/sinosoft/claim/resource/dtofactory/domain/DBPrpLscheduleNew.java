package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLscheduleNew新案件提示表的数据访问对象类<br>
 * 创建于 2004-07-15 21:00:43.044<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleNew extends DBPrpLscheduleNewBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleNew.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleNew(DBManager dbManager){
        super(dbManager);
    }
}
