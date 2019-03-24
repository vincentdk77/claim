package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPACKAGE工作流日志业务信息表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.932<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfPackage extends DBSwfPackageBase{
    private static Log logger = LogFactory.getLog(DBSwfPackage.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfPackage(DBManager dbManager){
        super(dbManager);
    }
}
