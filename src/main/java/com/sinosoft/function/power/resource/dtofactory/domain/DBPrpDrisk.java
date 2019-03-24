package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDrisk险种代码表的数据访问对象类<br>
 * 创建于 2004-11-09 10:40:49.351<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrisk extends DBPrpDriskBase{
    private static Log logger = LogFactory.getLog(DBPrpDrisk.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrisk(DBManager dbManager){
        super(dbManager);
    }
}
