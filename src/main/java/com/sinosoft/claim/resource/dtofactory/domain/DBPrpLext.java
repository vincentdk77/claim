package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLext的数据访问对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLext extends DBPrpLextBase{
    private static Log logger = LogFactory.getLog(DBPrpLext.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLext(DBManager dbManager){
        super(dbManager);
    }
}
