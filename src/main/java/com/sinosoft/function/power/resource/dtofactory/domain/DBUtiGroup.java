package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiGroup  权限组号表的数据访问对象类<br>
 * 创建于 2004-11-09 10:40:49.301<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiGroup extends DBUtiGroupBase{
    private static Log logger = LogFactory.getLog(DBUtiGroup.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiGroup(DBManager dbManager){
        super(dbManager);
    }
}
