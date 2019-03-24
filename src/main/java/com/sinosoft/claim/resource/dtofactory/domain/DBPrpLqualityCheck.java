package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLqualityCheck-质量评审内容表的数据访问对象类<br>
 * 创建于 2005-04-14 15:56:46.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLqualityCheck extends DBPrpLqualityCheckBase{
    private static Log logger = LogFactory.getLog(DBPrpLqualityCheck.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLqualityCheck(DBManager dbManager){
        super(dbManager);
    }
}
