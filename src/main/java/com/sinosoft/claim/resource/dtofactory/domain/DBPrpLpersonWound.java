package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonWound 伤情信息表的数据访问对象类<br>
 * 创建于 2005-02-18 10:21:18.968<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpersonWound extends DBPrpLpersonWoundBase{
    private static Log logger = LogFactory.getLog(DBPrpLpersonWound.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpersonWound(DBManager dbManager){
        super(dbManager);
    }
}
