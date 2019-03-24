package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdAgentSysData的数据访问对象类<br>
 * 创建于 2005-07-19 09:58:57.598<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdAgentSysData extends DBEdAgentSysDataBase{
    private static Log logger = LogFactory.getLog(DBEdAgentSysData.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdAgentSysData(DBManager dbManager){
        super(dbManager);
    }
}
