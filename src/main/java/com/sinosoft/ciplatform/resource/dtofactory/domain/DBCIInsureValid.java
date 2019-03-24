package com.sinosoft.ciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是投保确认主表-CIInsureValid的数据访问对象类<br>
 * 创建于 2006-06-21 17:31:50.703<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIInsureValid extends DBCIInsureValidBase{
    private static Log logger = LogFactory.getLog(DBCIInsureValid.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIInsureValid(DBManager dbManager){
        super(dbManager);
    }
}
