package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的数据访问对象类<br>
 * 创建于 2005-03-11 10:51:27.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBMidResultConfig extends DBMidResultConfigBase{
    private static Log logger = LogFactory.getLog(DBMidResultConfig.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMidResultConfig(DBManager dbManager){
        super(dbManager);
    }
}
