package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDuser 员工代码表的数据访问对象类<br>
 * 创建于 2004-11-09 18:30:40.418<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuser extends DBPrpDuserBase{
    private static Log logger = LogFactory.getLog(DBPrpDuser.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDuser(DBManager dbManager){
        super(dbManager);
    }
}
