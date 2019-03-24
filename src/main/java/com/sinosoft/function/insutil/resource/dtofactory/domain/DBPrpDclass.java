package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclass的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:16:29<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclass extends DBPrpDclassBase{
    private static Log log = LogFactory.getLog(DBPrpDclass.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDclass(DBManager dbManager){
        super(dbManager);
    }
}
