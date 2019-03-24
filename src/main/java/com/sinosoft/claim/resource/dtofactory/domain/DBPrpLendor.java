package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLendor的数据访问对象类<br>
 * 创建于 2007-06-12 15:24:00.218<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLendor extends DBPrpLendorBase{
    private static Log logger = LogFactory.getLog(DBPrpLendor.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLendor(DBManager dbManager){
        super(dbManager);
    }
}
