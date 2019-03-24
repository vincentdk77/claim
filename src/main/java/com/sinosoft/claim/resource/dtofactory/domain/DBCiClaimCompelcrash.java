package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的数据访问对象类<br>
 * 创建于 2007-01-24 19:03:03.875<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCompelcrash extends DBCiClaimCompelcrashBase{
    private static Log logger = LogFactory.getLog(DBCiClaimCompelcrash.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCiClaimCompelcrash(DBManager dbManager){
        super(dbManager);
    }
}
