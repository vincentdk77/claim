package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfPathLogStore的数据访问对象类<br>
 * 创建于 2006-12-08 14:08:41.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfPathLogStore extends DBSwfPathLogStoreBase{
    private static Log logger = LogFactory.getLog(DBSwfPathLogStore.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfPathLogStore(DBManager dbManager){
        super(dbManager);
    }
}
