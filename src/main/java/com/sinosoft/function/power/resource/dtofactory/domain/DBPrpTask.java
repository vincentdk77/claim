package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask工作任务表的数据访问对象类<br>
 * 创建于 2004-11-09 10:40:49.341<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpTask extends DBPrpTaskBase{
    private static Log logger = LogFactory.getLog(DBPrpTask.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpTask(DBManager dbManager){
        super(dbManager);
    }
}
