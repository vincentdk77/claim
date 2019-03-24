package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是CIClaimCrash 车辆理赔记录的数据访问对象类<br>
 * 创建于 2007-01-24 19:03:03.937<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCrash extends DBCiClaimCrashBase{
    private static Log logger = LogFactory.getLog(DBCiClaimCrash.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCiClaimCrash(DBManager dbManager){
        super(dbManager);
    }
}
